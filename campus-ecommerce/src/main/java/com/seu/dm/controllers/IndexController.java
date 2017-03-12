package com.seu.dm.controllers;

import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Seller;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/2/28.
 * 首页
 */
@Controller
public class IndexController {
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private SellerService sellerService;

    @RequestMapping(value={"/","/index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam String name, @RequestParam String password, @RequestParam String userType,
                        HttpServletRequest request){
        if("buyer".equals(userType)){
            System.out.println("buyer");
            Buyer buyerFromDB = buyerService.findBuyerByName(name);
            if(buyerFromDB == null) {
                System.out.println("login fail!");
                return "buyer/register";
            }
            if(!password.equals(buyerFromDB.getPassword())) {
                System.out.println("password error!");
            }
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", buyerFromDB);
            return "redirect:/";
        }
        if("seller".equals(userType)){
            System.out.println("seller");
            Seller sellerFromDB = sellerService.findSellerByName(name);
            if(sellerFromDB == null) {
                System.out.println("login fail!");
                return "seller/register";
            }
            if(!password.equals(sellerFromDB.getPassword())) {
                System.out.println("password error!");
            }
            System.out.println("there");
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", sellerFromDB);
            return "redirect:/";
        }
        return "";
    }
}
