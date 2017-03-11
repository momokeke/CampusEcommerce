package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Order;
import com.seu.dm.mappers.OrderProductMapper;
import com.seu.dm.mappers.OrderMapper;
import com.seu.dm.mappers.ProductMapper;
import com.seu.dm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public int deleteOrder(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public Order findOrder(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public HashMap<String, Integer> findHotProductsFromOrder(Integer n) {

//        HashMap<Integer,Integer> productIdAndNum = orderProductMapper.findHotProducts(3);//返回商品ID和对应销售量前几位的Map
//        HashMap<String, Integer> productNameAndNum = new HashMap<>();                   //新建商品名和销售量表存储
//        for (Integer productId : productIdAndNum.keySet()) {                            //循环从Product表中取出商品名联合销售量加入上表中
//            Integer sellNum = productIdAndNum.get(productId);
//            System.out.println("productId: "+productId+" prodcutNum: "+sellNum);
//            String productName = productMapper.selectByPrimaryKey(productId).getName();
//            productNameAndNum.put(productName,sellNum);
//        }
//        return productNameAndNum;
        List<HashMap<String, Integer>> productIdAndNum = orderProductMapper.findHotProducts(n);
        HashMap<String, Integer> productNameAndNum = new HashMap<>();
        System.out.println(productIdAndNum.size());
        for (HashMap<String, Integer> stringIntegerHashMap : productIdAndNum) {
            String productName = new String();
            int sellNum = 0;
            for (String s : stringIntegerHashMap.keySet()) {
//                System.out.println(s);
                if("product_id".equals(s)){
                    Integer productIdOfMap = stringIntegerHashMap.get(s);
                    productName = productMapper.selectByPrimaryKey(productIdOfMap).getName();
//                    System.out.println("proId:  "+productIdOfMap+"  proNa:  "+productName);
                }
                if("m".equals(s)){
//                    System.out.println("test");
//                    System.out.println(stringIntegerHashMap.get(s));
//                    Integer.valueOf(((Object)(stringIntegerHashMap.get(s))).toString()).intValue();
                     sellNum = Integer.valueOf(((Object)(stringIntegerHashMap.get(s))).toString()).intValue();//来自于章铖大佬的神秘代码，迷之封拆
//                    System.out.println(sellNum);
//                    System.out.println("sellNUm:  " +sellNum);
                }
            }
            productNameAndNum.put(productName,sellNum);
        }
        return productNameAndNum;
    }

    @Override
    public List<Order> findOrdersByCampusId(Integer campusId) {
        return orderMapper.findOrdersByCampusId(campusId);

    }

    @Override
    public List<Order> screenOrders(Integer orderId, Integer orderStatus, Integer campusId) {

        if(orderId != null) {
           List<Order> orders = new ArrayList<>();
           Order order = orderMapper.selectByPrimaryKey(orderId);
           if(order == null) System.out.println("null");
           orders.add(order);
           return orders;
        }
        if("全部".equals(orderStatus)) return orderMapper.findOrdersByCampusId(campusId);
        List<Order> orders = orderMapper.screenOrders(orderStatus,campusId);
        return orders;
    }

    @Override
    public List<Order> findOrdersBySellerId(Integer sellerId) {
        return orderMapper.findOrdersBySellerId(sellerId);
    }
}
