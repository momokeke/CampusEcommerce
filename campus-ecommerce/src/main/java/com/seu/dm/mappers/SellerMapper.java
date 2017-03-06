package com.seu.dm.mappers;

import com.seu.dm.entities.Seller;

public interface SellerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seller record);

    int insertSelective(Seller record);

    Seller selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seller record);

    int updateByPrimaryKey(Seller record);

    Seller selectByName(String name);

    int deleteByName(String name);

    int selectCountOfAll();
}