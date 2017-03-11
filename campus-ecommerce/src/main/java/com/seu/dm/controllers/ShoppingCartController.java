package com.seu.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by momomo on 2017/3/9.
 */
@Controller
@RequestMapping(value = "/buyer")
public class ShoppingCartController {
    /*
    *跳到买家购物车
    */
    @RequestMapping(value = "/shopping_cart")
    public String jumpToBuyerShoppingCart(){
        return "buyer/shopping_cart";
    }
}
