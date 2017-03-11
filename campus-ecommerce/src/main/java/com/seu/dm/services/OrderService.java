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
}
