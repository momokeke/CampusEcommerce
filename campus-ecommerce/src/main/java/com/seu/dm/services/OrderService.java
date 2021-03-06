package com.seu.dm.services;

import com.seu.dm.entities.Order;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface OrderService {
    int addOrder(Order order);

    int deleteOrder(Integer id);

    int updateOrder(Order order);

    List<Order> selectWeekTransactions();

    Order findOrder(Integer id);

    Integer getCount(Order order);

    List<Order> findOrders(Order order);

    HashMap<String, Integer> findHotProductsFromOrder(Integer n);

    List<Order> screenOrders(Integer orderId,Integer orderStatus,Integer campusId);

    List<Order> findOrdersBySellerId(Integer sellerId);

    List<Order> findOrdersByBuyerId(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusWaitDeliver(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusAlreadyDeliver(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusOnRejection(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusAlreadyRejection(Integer buyerId);

    List<Order> findOrdersByBuyerIdWithStatusSuccess(Integer buyerId);

    List<Order> findOrdersBySellerIdWithStatusWaitDeliver(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusAlreadyDeliver(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusOnRejection(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusAlreadyRejection(Integer sellerId);

    List<Order> findOrdersBySellerIdWithStatusSuccess(Integer sellerId);
}
