package com.tal.dao;

import com.tal.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    SysUser findByKeyword( String keyword);

    int deleteByPrimaryKey(Integer uid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysUser> getAlluser();

    int countByNameAndParentId(@Param("parentid") Integer parentId, @Param("name") String name, @Param("uid") Integer uid);

    List<SysUser> getChildDeptListByLevel(@Param("level") String level);

    void batchUpdateLevel(@Param("sysUserList") List<SysUser> sysUserList);

    List<SysUser> selectUserByPage(@Param(value = "startpagecolumn") Integer startpagecolumn,
                                   @Param(value = "pagesize") Integer pagesize,@Param(value = "uid") Integer uid);

    int getUserCount(@Param(value = "uid") Integer uid);
}