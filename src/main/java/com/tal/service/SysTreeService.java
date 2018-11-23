package com.tal.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.tal.dao.SysUserMapper;

import com.tal.dto.UserLevelDto;
import com.tal.pojo.SysUser;
import com.tal.util.LevelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
//1.将所有的user全部 查询而来mapper.get 2。都变成dto 3，dto变成tree，---取出rootlist，然后遍历处理，----递归
public class SysTreeService {
    @Autowired
    private SysUserMapper userMapper;
    //将所有的user变成userdto
    public List<UserLevelDto> userTree(){
        List<SysUser> sysUsers=userMapper.getAlluser();
        List<UserLevelDto> userLevelDtoList= Lists.newArrayList();
        for (SysUser user :sysUsers){
            UserLevelDto userdto=UserLevelDto.adapt(user);
            userLevelDtoList.add(userdto);
        }
        return userListToTree(userLevelDtoList);

    }
//创建 rootlist mulitmap 然后遍历userdtolist，遍历的时候遇到符合rootlist条件的，就放到rootlist中

//    接下来处理rootlist，（1）先按seq排序，
    public List<UserLevelDto> userListToTree(List<UserLevelDto> userLevelDtoList) {
        if(CollectionUtils.isEmpty(userLevelDtoList))
        {
            return Lists.newArrayList();
        }
        Multimap<String,UserLevelDto> levelDtoMultimap= ArrayListMultimap.create();
        List<UserLevelDto> rootlist=Lists.newArrayList();

        for (UserLevelDto userLevelDto:userLevelDtoList){
            levelDtoMultimap.put(userLevelDto.getLevel(),userLevelDto);
            if (LevelUtil.ROOT.equals(userLevelDto.getLevel())){
                rootlist.add(userLevelDto);
            }
        }
        Collections.sort(rootlist, new Comparator<UserLevelDto>() {
            @Override
            public int compare(UserLevelDto o1, UserLevelDto o2) {
                return o1.getSeq()-o2.getSeq();
            }
        });

        transformDeptTree(rootlist,LevelUtil.ROOT,levelDtoMultimap);
        return rootlist;

//        将rootlist进行排序完成后就可以按序号遍历，递归进行,参数1选择当下遍历第几层，参数2层级，参数3 下一个分支；遍历就是
//        处理完此层后，给出下一层，继续调用当前函数


    }
//递归函数的处理逻辑，（2）遍历rootlist,每一个变成dto，得到level，然后得到下一层
    private void transformDeptTree(List<UserLevelDto> rootlist, String level,
                                   Multimap<String, UserLevelDto> levelDtoMultimap) {
        for (int i=0;i<rootlist.size();i++){
//    取出rootlist中的每一个 先变成dto
            UserLevelDto userLevelDto = rootlist.get(i);
//            计算出此节点对应的下一层的level值，这样就能将此节点的子结构全部都取出来，然后进行排序，就得到了此节点完整的子结构
            String nextLevel=LevelUtil.calculateLevel(level,userLevelDto.getUid());
//            得到下一层的list
            List<UserLevelDto> tempUserList =(List<UserLevelDto>)levelDtoMultimap.get(nextLevel);
//            下一层进行排序，然后将下一层规到此节点，然后开始下一层的处理
            if (!CollectionUtils.isEmpty(tempUserList)){

                Collections.sort(tempUserList,userSeqComparator);

                userLevelDto.setUserLevelDtoList(tempUserList);
                transformDeptTree(tempUserList,nextLevel,levelDtoMultimap);
            }
        }

    }
    public Comparator<UserLevelDto> userSeqComparator = new Comparator<UserLevelDto>() {
        public int compare(UserLevelDto o1, UserLevelDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };






}
