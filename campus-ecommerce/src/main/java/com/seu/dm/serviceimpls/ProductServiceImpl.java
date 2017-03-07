package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Product;
import com.seu.dm.mappers.ProductMapper;
import com.seu.dm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Product findAllProducts() {
        int i =1;
        Product product = productMapper.selectByPrimaryKey(i);
        return product;
    }

    /**
     * 向数据库加入商品
     * @param product
     * @return
     */
    @Override
    public int addProduct(Product product) {
        int i =productMapper.insert(product);
        return i;
    }

    /**
     * 根据id从数据库中找到对应商品
     * @param id
     * @return
     */
    @Override
    public Product findProduct(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    /**
     * 根据商品名找到对应商品
     * @param s
     * @return
     */
    @Override
    public List<Product> findProductsByName(String s) {
        List<Product> products = productMapper.getProductsByName(s);
        return products;
    }

    @Override
    public Integer getCountOfResults(String s) {
        Integer i = productMapper.getCountOfResults(s);
        return i;
    }

    @Override
    public int getMaleCount() {
        int i = productMapper.getMaleCount();
        return i;
    }

    @Override
    public int addUser(User user) {
        int i = userMapper.insert(user);
        return i;
    }
}
