package com.seu.dm.serviceimpls;

import com.seu.dm.entities.*;
import com.seu.dm.mappers.OrderProductMapper;
import com.seu.dm.mappers.PictureMapper;
import com.seu.dm.mappers.ProductMapper;
import com.seu.dm.mappers.SellerMapper;
import com.seu.dm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private PictureMapper pictureMapper;
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;

    final static double MAXPRICEVALUE = 123456789.0;
    final static double MINPRICEVALUE = 0.0;

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

    /**
     * 根据商品名返回查找数量
     * @param s
     * @return
     */
    @Override
    public int getCountOfResultsByName(String s) {
        int i = productMapper.getCountOfResultsByName(s );
        return i;
    }

    /**
     *根据主键删除商品
     * @param id
     * @return
     */
    @Override
    public int deleteProduct(Integer id) {
        int i = productMapper.deleteByPrimaryKey(id);
        return i;
    }

    /**
     * 更新商品
     * @param product
     * @return
     */
    @Override
    public int updateProduct(Product product) {
        int i =productMapper.updateByPrimaryKey(product);
        return i;
    }

    /**
     * 通过分类名查找商品列表
     * @param s
     * @return
     */
    @Override
    public List<Product> findProductsByCategory(String s) {
        return productMapper.getResultsByCategory(s);
    }

    /**
     * 根据主键得到价格
     * @param id
     * @return
     */
    @Override
    public BigDecimal getProductPriceById(Integer id) {
        return productMapper.getPriceById(id);
    }

//    /**
//     * 根据商品名得到对应商品列表页需要的实体SearchGoodEntity列表，便于前端显示数据，
//     * @param name
//     * @return
//     */
//    @Override
//    public List<SearchGoodEntity> searchEntitiesByName(String name) {
//        List<SearchGoodEntity> goods = new ArrayList<>();
//        List<Product> products = findProductsByName(name);
//        SearchGoodEntity newEntity;
//        Picture picture;
//        Seller seller;
//        OrderProduct orderProduct;
//        for (Product product : products) {
//            //根据商品ID和卖家ID得到对应picture、seller、orderProduct，并初始化实体加入list列表
//            picture = pictureMapper.findPictureByProductId(product.getId());
//            seller = sellerMapper.selectByPrimaryKey(product.getSellerId());
//            orderProduct = orderProductMapper.findOrderProductByProductId(product.getId());
//            if(picture != null &&seller != null&&orderProduct != null) {
//                newEntity = new SearchGoodEntity(product, picture, seller, orderProduct);
//                goods.add(newEntity);
//            }else {
//                System.out.println("null");
//            }
//        }
//        //List<Picture> pictures = findPicturesByProductId()
//        return goods;
//    }
//
//    @Override
//    public List<SearchGoodEntity> serachEntitiesByCategory(String category) {
//        List<SearchGoodEntity> goods = new ArrayList<>();
//        List<Product> products = findProductsByCategory(category);
//        SearchGoodEntity newEntity;
//        for (Product product : products) {
//            //根据商品ID和卖家ID得到对应picture、seller、orderProduct，并初始化实体加入list列表
//            Picture picture = pictureMapper.findPictureByProductId(product.getId());
//            Seller seller = sellerMapper.selectByPrimaryKey(product.getSellerId());
//            OrderProduct orderProduct = orderProductMapper.findOrderProductByProductId(product.getId());
//            newEntity = new SearchGoodEntity(product,picture,seller,orderProduct);
//            goods.add(newEntity);
//        }
//        //List<Picture> pictures = findPicturesByProductId()
//        return goods;
//    }

    @Override
    public List<Product> findProductsBySellerId(Integer selledId) {
        List<Product> products = productMapper.getProductsBySellerId(selledId);
        return products;
    }

    @Override
    public Integer unshelfProduct(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        product.setIsShelf(false);
        productMapper.updateByPrimaryKey(product);
        return 1 ;
    }

    @Override
    public List<Product> findProductsByNameAndScreenByPrice(String name, Double minPrice, Double maxPrice) {
        System.out.println("name is :" + name+"  minprice is :" +minPrice+"  maxprice is : "+maxPrice);
        if(minPrice!=null && maxPrice == null) return productMapper.getProductsByNameAndScreenByPrice(name,minPrice,MAXPRICEVALUE);
        if(minPrice==null && maxPrice == null)return productMapper.getProductsByNameAndScreenByPrice(name,MINPRICEVALUE,MAXPRICEVALUE);
        if(minPrice==null && maxPrice != null) return productMapper.getProductsByNameAndScreenByPrice(name,MINPRICEVALUE,maxPrice);
        return productMapper.getProductsByNameAndScreenByPrice(name,minPrice,maxPrice);

    }

    @Override
    public List<Product> findNewProducts(Integer campusId) {
        return productMapper.getNewProductsByCampusId(campusId);
    }


    @Override
    public List<Product> findCheapProducts(Integer campusId) {
        return productMapper.getCheapProductsByCampusId(campusId);
    }

}
