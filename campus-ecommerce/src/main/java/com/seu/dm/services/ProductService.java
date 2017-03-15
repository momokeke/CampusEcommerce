package com.seu.dm.services;

import com.seu.dm.entities.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */

public interface ProductService {

    double minPrice = -321312213.0;
    double maxPrice = 231231123.0;

    int addProduct(Product product);

    Product findProduct(Integer id);

    List<Product> findProductsByName(String s);

    List<Product> findProductsByCategory(String s);

    int getCountOfResultsByName(String s);

    int deleteProduct(Integer id);

    int updateProduct(Product product);

    BigDecimal getProductPriceById(Integer id);

//    List<SearchGoodEntity> searchEntitiesByName(String name);
//
//    List<SearchGoodEntity> serachEntitiesByCategory(String category);

    List<Product> findProductsBySellerId(Integer selledId);

    Integer unshelfProduct(Integer productId);

    List<Product> findProductsByNameAndScreenByPrice(String name,Double minPrice,Double maxPrice);

    List<Product> findNewProducts(Integer campusId);

    List<Product> findCheapProducts(Integer campusId);

}
