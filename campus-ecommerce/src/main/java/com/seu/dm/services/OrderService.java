package com.seu.dm.services;

import com.seu.dm.entities.Order;
import com.seu.dm.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface OrderService {
    int addOrder(Order order);

    int deleteOrder(Integer id);

    int updateOrder(Order order);

    Order findOrder(Integer id);

    HashMap<String, Integer> findHotProductsFromOrder(Integer n);

    List<Order> findOrdersByCampusId(Integer campusId);

    List<Order> screenOrders(Integer orderId,Integer orderStatus,Integer campusId);

    List<Order> findOrdersBySellerId(Integer sellerId);

    List<Order> findOrdersByBuyerId(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusWaitDeliver(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusOnRejection(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusAlreadyRejection(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusSuccess(Integer buyerId);

    List<Order> findOrdersBySellerIdWithStatusWaitDeliver(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusOnRejection(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusAlreadyRejection(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusSuccess(Integer sellerId);
}
