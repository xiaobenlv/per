package com.tal.dao;

import com.tal.pojo.SysRolePer;

public interface SysRolePerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePer record);

    int insertSelective(SysRolePer record);

    SysRolePer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePer record);

    int updateByPrimaryKey(SysRolePer record);
}