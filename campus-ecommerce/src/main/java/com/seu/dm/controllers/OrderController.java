package com.seu.dm.controllers;

import com.seu.dm.entities.Order;
import com.seu.dm.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/7.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/hotProduct")
    public String findHotProductsFromOrder(@RequestParam(value = "num")Integer num, Model model){
        HashMap<String, Integer> productNameAndNum = orderService.findHotProductsFromOrder(num);
        for (String s : productNameAndNum.keySet()) {
            System.out.println(s+": "+productNameAndNum.get(s));
        }
        model.addAttribute("map",productNameAndNum);
        return "/testOrder";
    }
}
