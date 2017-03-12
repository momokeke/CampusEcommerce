package com.seu.dm.controllers;

import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Order;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */

@Controller
@RequestMapping(value = "/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private OrderService orderService;
    /**
     * 注册用户
     * @param buyer
     * @param model
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String addBuyer(Buyer buyer, Model model, HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        System.out.println("call");
        int i = buyerService.addBuyer(buyer);
        httpSession.setAttribute("user",buyer);
        return "redirect:/";
    }

    /**
     * 登陆时确认是否为一个用户
     * @return
     */
    @RequestMapping(value = "/loginConfirm",method = RequestMethod.POST)
    public String confirmBuyer(Buyer buyer,Model model){
        Integer id = buyer.getId();
        Buyer buyer1 = buyerService.findBuyer(id);
        System.out.println("ok");
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginBuyer(Buyer buyer,HttpServletRequest request){
        Integer studentNumber = buyer.getStudentNumber();
        Buyer buyerFromDB = buyerService.findBuyerByStudentNumber(studentNumber);
        if(buyerFromDB == null) return "buyer/register";
        if(buyer.getPassword().equals(buyerFromDB.getPassword())) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", buyer);
            return "redirect:/";
        }
        return "";
    }

    @RequestMapping(value = "/buyerLogout")
    public String logoutBuyer(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null) return "redirect:/";
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/orders")
    public String findBuyerOrders(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("user");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerId(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/waitdeliver")
    public String findBuyerOrdersWithStatusWaitDeliver(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("user");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusWaitDeliver(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/onrejection")
    public String findBuyerOrdersWithStatusOnRejection(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("user");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusOnRejection(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/alreadyrejection")
    public String findBuyerOrdersWithStatusAlreadyRejection(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("user");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusAlreadyRejection(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/success")
    public String findBuyerOrdersWithStatusSuccess(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("user");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusSuccess(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }
    /*
    *跳转到买家登录
     */
    @RequestMapping(value = "/buyer_login")
    public String jumpToBuyerLogin(){
        return "buyer/buyer_login";
    }

    /*
    *跳转到买家注册
     */
    @RequestMapping(value = "/buyer_register")
    public String jumpToBuyerRegister(){
        return "buyer/buyer_register";
    }

    /*
    *跳到买家中心
     */
    @RequestMapping(value = "/buyer_center")
    public String jumpToBuyerCenter(){
        return "buyer/buyer_center";
    }


    /**
     *跳到买家购物车
    */
    @RequestMapping(value = "/shopping_cart")
    public String jumpToBuyerShoppingCart(){
        return "buyer/shopping_cart";
    }


    @RequestMapping(value = "/shopping_cart_change")
    @ResponseBody
    public Object changeShoppingCart(@RequestParam Integer id,@RequestParam Integer newNum,HttpSession httpSession){
        httpSession.setAttribute("cart",new HashMap<Integer,Integer>());
        HashMap<Integer,Integer> cart = (HashMap<Integer,Integer>)httpSession.getAttribute("cart");
        cart.put(id,newNum);
        return "ok";
    }




    /*
    *跳到买家收藏夹
     */
    @RequestMapping(value = "/buyer_favorite")
    public String jumpToBuyerFavorite(){
        return "buyer/buyer_favorite";
    }

    /*
    *跳到买家已买到的宝贝
     */
    @RequestMapping(value = "/bought_products")
    public String jumpToBoughtProducts(){
        return "buyer/bought_products";
    }
    /*
      *跳到买家已买过得店铺
       */
    @RequestMapping(value = "/bought_shops")
    public String jumpToBoughtShops(){
        return "buyer/bought_shops";
    }
    /*
      *跳到买家评价管理页面
       */
    @RequestMapping(value = "/comment_management")
    public String jumpToCommentManagement(){
        return "buyer/comment_management";
    }
    /*
      *跳到买家我的足迹
       */
    @RequestMapping(value = "/foot_print")
    public String jumpToFootPrint(){
        return "buyer/foot_print";
    }
    /*
          *跳到买家我的设置
           */
    @RequestMapping(value = "/buyer_setting")
    public String jumpToBuyerSetting(){
        return "buyer/buyer_setting";
    }


}
