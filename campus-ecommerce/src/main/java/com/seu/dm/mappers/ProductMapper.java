package com.seu.dm.mappers;

import com.seu.dm.entities.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);                       //根据主键删除记录

    int insert(Product record);                              //根据记录添加到数据库

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);                  //根据主键查找记录

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);                  //更新数据库记录

    List<Product> getProductsByName(String s);              //通过商品名模糊查找对应商品列表

    int getCountOfResultsByName(String s);                  //通过商品名模糊查找得到查找结果数量

    List<Product> getResultsByCategory(String s);           //通过分类名模糊查找对应商品列表

    BigDecimal  getPriceById(Integer id);                   //通过主键得到商品价格

    List<Product> getProductsBySellerId(Integer sellerId);

    List<Product> getProductsByNameAndScreenByPrice(@Param(value = "s") String s,
                                                    @Param(value = "minPrice") Double minPrice,
                                                    @Param(value = "maxPrice") Double maxPrice);

    List<Product> getNewProductsByCampusId(Integer campusId);

    List<Product> getCheapProductsByCampusId(Integer campusId);

    Product findProductByName(String name);

    List<Product> getProductByKeyword(String keyword);
}