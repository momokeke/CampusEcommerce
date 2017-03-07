package com.seu.dm.services;

import com.seu.dm.entities.Product;
<<<<<<< HEAD
=======

import org.springframework.stereotype.Service;
>>>>>>> 6d922c4f9852be6b709282e23836dfc8aea84e05

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */

public interface ProductService {
    Product findAllProducts();

    int addProduct(Product product);

    Product findProduct(Integer id);

    List<Product> findProductsByName(String s);

    List<Product> findProductsByCategory(String s);

    int getCountOfResultsByName(String s);

    int deleteProduct(Integer id);

    int updateProduct(Product product);

    BigDecimal getProductPriceById(Integer id);
}
