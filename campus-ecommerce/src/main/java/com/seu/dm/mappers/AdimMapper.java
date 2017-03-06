package com.seu.dm.mappers;

import com.seu.dm.entities.Adim;

public interface AdimMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Adim record);

    int insertSelective(Adim record);

    Adim selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Adim record);

    int updateByPrimaryKey(Adim record);
}