package com.seu.dm.mappers;

import com.seu.dm.entities.Product_type;

public interface Product_typeMapper {
    int deleteByPrimaryKey(Integer productTypeId);

    int insert(Product_type record);

    int insertSelective(Product_type record);

    Product_type selectByPrimaryKey(Integer productTypeId);

    int updateByPrimaryKeySelective(Product_type record);

    int updateByPrimaryKey(Product_type record);
}