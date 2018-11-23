package com.tal.service;

import com.google.common.base.Preconditions;
import com.tal.common.RequestHolder;
import com.tal.dao.SysUserMapper;
import com.tal.exception.ParamException;
import com.tal.param.UserParam;
import com.tal.pojo.SysUser;
import com.tal.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class SysUserService {
//    一定不能忘记autowired，注入会引起空指针错误
    @Autowired
    private SysUserMapper sysUserMapper;

    public void save(UserParam param){
        BeanValidator.check(param);
        String password = PasswordUtil.randomPassword();
        String encryptedPassword = MD5Util.encrypt(password);
//        或者直接构造方法进行 参数传递就可以
        SysUser sysUser=SysUser.builder().name(param.getName()).password(encryptedPassword).status(param.getStatus()).parentid(param.getParentid())
                .seq(param.getSeq()).build();


        sysUser.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentid()), param.getParentid()));
        sysUser.setOperator("2324");
//        sysUser.setOperateip(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        sysUser.setOperateip("123,324");
        sysUser.setOperatetime(new Date());
//        发送email
        sysUserMapper.insertSelective(sysUser);

    }




    private String getLevel(Integer useruid) {
        SysUser user = sysUserMapper.selectByPrimaryKey(useruid);
        if (user == null) {
            return null;
        }
        return user.getLevel();
    }

//更新：1.检验  2.从页面得到欲更新的参数 3.利用mapper更新进入 （但此时的问题，用户是树结构，所以更新要连着整个树结构进行更新）
//    所以 在更新之前，（1） 比较更新之前的level与更新之后的level，如果不一样，将更新前的level 输入利用mapper得到userlist
//    如果此userlist不为空，遍历这个list，得到现在这个list的level（经过计算）
    public void update(UserParam param) {
//（1）检查同一层级下是否存在相同用户，利用id和parentid  （2）利用id得到此用户，看此用户是否存在
        BeanValidator.check(param);
        if(checkExist(param.getParentid(),param.getName(),param.getUid())){
            throw new ParamException("同一层级下存在相同用户");
        }
        SysUser before=sysUserMapper.selectByPrimaryKey(param.getUid());
        Preconditions.checkNotNull(before,"待更新的用户不存在");

//设置更新后的用户信息
        SysUser after=SysUser.builder().uid(param.getUid()).name(param.getName()).parentid(param.getParentid())
                .seq(param.getSeq()).build();
        after.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentid()), param.getParentid()));
        after.setOperator(RequestHolder.getCurrentUser().getName());
        after.setOperateip(IpUtil.getRemoteIp(RequestHolder.getCurrentRequest()));
        after.setOperatetime(new Date());

//        因为是树结构，所以要连带用户树一起改变
        updateWithChild(before,after);



    }
//得到更新前后的用户level  如果前后不等（因为level是否相等决定了子结构是否改变），先根据用户之前的level，通过mapper得到用户列表，
// 遍历用户列表，得到每个用户的level？？，
//    赋给新的level值，更新deptlist的level    更新用户
    private void updateWithChild(SysUser before, SysUser after) {
        String newLevel=after.getLevel();
        String oldlevel=before.getLevel();
//        将用户之前的level与欲更新后的level进行比较，不相同嘛，说明子结构需要改变
        if (!after.getLevel().equals(before.getLevel())){
//            得到所有的子结构用户 形成列表，然后改遍历子结构用户的level
            List<SysUser> userList=sysUserMapper.getChildDeptListByLevel(before.getLevel());
            if (!CollectionUtils.isEmpty(userList)) {
                for (SysUser user : userList) {
//               原来的level
                    String level = user.getLevel();
//                取原来level的parentlevel部分，就是与改后level重叠的部分
                    if (level.indexOf(oldlevel) == 0) {
                        level = newLevel + level.substring(oldlevel.length());
//                    得到改后的level
                        user.setLevel(level);

                    }

                }

//            然后将数据库中的子结构进行更新
                sysUserMapper.batchUpdateLevel(userList);
            }

        }
//        更新自身
        sysUserMapper.updateByPrimaryKey(after);



    }

    private boolean checkExist(Integer parentid, String Name, Integer userid) {
        return sysUserMapper.countByNameAndParentId(parentid, Name, userid) > 0;
    }

    public SysUser findByKeyword(String keyword) {
        return sysUserMapper.findByKeyword(keyword);
    }

    public int gettotalCount(int uid){
         return sysUserMapper.getUserCount(uid);
    }

    public List<SysUser> selectUserByPage(int pagenow,int pagasize,int uid){
        return sysUserMapper.selectUserByPage(pagenow,pagasize,uid);

    }
}
