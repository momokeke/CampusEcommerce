package com.seu.dm.mappers;

import com.seu.dm.entities.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> findOrdersByCampusId(Integer campusId);

    List<Order> screenOrders(String orderStatus,Integer campusId);
}