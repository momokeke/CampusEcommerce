package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Order;
import com.seu.dm.mappers.OrderMapper;
import com.seu.dm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

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
}
