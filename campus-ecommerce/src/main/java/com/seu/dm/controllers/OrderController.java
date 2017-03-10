package com.seu.dm.controllers;

import com.seu.dm.entities.Order;
import com.seu.dm.services.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/8.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/findOrder")
    public String findOrderById(@Param(value = "id") Integer id, Model model){
        Order order = orderService.findOrder(id);
        model.addAttribute("order", order);
        return "/seller/transaction_manage";
    }
}
