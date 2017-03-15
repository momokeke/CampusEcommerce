package com.seu.dm.services;

import com.seu.dm.entities.OrderProduct;

import java.util.List;

/**
 * Created by momomo on 2017/3/14.
 */
public interface OrderProductService {
    int addOrderProduct(OrderProduct orderProduct);

    int deleteOrderProduct(Integer id);

    int updateOrderProduct(OrderProduct orderProduct);

    OrderProduct findOrderProducts(Integer id);

    List<OrderProduct> findOrderProductsByOrderId(Integer orderId);
}
