package com.seu.dm.services;

import com.seu.dm.entities.Product;
import com.seu.dm.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */

public interface ProductService {
    Product findAllProducts();
    int addProduct(Product product);
    Product findProduct(Integer id);
    List<Product> findProductsByName(String s);
    Integer getCountOfResults(String s);
    int getMaleCount();
    int addUser(User user);
}
