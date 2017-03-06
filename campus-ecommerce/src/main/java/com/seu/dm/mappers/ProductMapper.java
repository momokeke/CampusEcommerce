package com.seu.dm.mappers;

import com.seu.dm.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> getProductsByName(String s);

    int getCountOfResultsByName(String s);

    List<Product> getResultsByCategory(String s);

    BigDecimal getPriceById(Integer id);
}