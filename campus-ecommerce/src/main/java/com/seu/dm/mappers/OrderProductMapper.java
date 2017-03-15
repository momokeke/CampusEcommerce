package com.seu.dm.mappers;

import com.seu.dm.entities.OrderProduct;

import java.util.HashMap;
import java.util.List;


public interface OrderProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    OrderProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);

    List<HashMap<String,Integer>> findHotProducts(Integer n);

    OrderProduct findOrderProductByProductId(Integer id);

    OrderProduct findOneOrderProductByOrderId(Integer id);

    List<OrderProduct> findOrderProductsByOrderId(Integer orderId);
 }