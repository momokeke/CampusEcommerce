package com.seu.dm.controllers;

import com.seu.dm.entities.CartProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by 张老师 on 2017/3/9.
 */
@Controller
public class CartController {
    @RequestMapping("/addCart")
    public String addToCart(CartProduct cartProduct,
                          HttpServletResponse response,
                          HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
       return "";
    }
}
