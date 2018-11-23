package com.tal.dao;

import com.tal.pojo.SysPer;

public interface SysPerMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(SysPer record);

    int insertSelective(SysPer record);

    SysPer selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(SysPer record);

    int updateByPrimaryKey(SysPer record);
}