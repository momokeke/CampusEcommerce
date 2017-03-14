package com.seu.dm.mappers;

import com.seu.dm.entities.Order;

import java.util.HashMap;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectWeekTransactions();

    Integer getCount(Order order);

    List<Order> findOrders(Order order);

    List<Order> findOrdersBySellerId(Integer sellerId);

    List<Order> screenOrders(Integer orderStatus,Integer campusId);

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