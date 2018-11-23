package com.tal.dao;

import com.tal.pojo.SysperModel;

public interface SysperModelMapper {
    int deleteByPrimaryKey(Integer pmid);

    int insert(SysperModel record);

    int insertSelective(SysperModel record);

    SysperModel selectByPrimaryKey(Integer pmid);

    int updateByPrimaryKeySelective(SysperModel record);

    int updateByPrimaryKey(SysperModel record);
}