package com.seu.dm.serviceimpls;

import com.seu.dm.entities.OrderProduct;
import com.seu.dm.mappers.OrderProductMapper;
import com.seu.dm.services.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by momomo on 2017/3/14.
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    private OrderProductMapper orderProductMapper;

    @Override
    public int addOrderProduct(OrderProduct orderProduct) {
        return orderProductMapper.insert(orderProduct);
    }

    @Override
    public int deleteOrderProduct(Integer id) {
        return orderProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateOrderProduct(OrderProduct orderProduct) {
        return orderProductMapper.updateByPrimaryKeySelective(orderProduct);
    }

    @Override
    public OrderProduct findOrderProducts(Integer id) {
        return orderProductMapper.findOneOrderProductByOrderId(id);
    }

    @Override
    public List<OrderProduct> findOrderProductsByOrderId(Integer orderId) {
        return orderProductMapper.findOrderProductsByOrderId(orderId);
    }
}
