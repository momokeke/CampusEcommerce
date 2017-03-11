package com.seu.dm.controllers;

import com.seu.dm.entities.Buyer;
import com.seu.dm.services.BuyerService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 * Created by 张老师 on 2017/3/3.
 */

@Controller
@RequestMapping(value = "/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    /**
     * 注册用户
     * @param buyer
     * @param model
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String addBuyer(Buyer buyer, Model model){
        System.out.println("call");
        int i = buyerService.addBuyer(buyer);
        System.out.println("i = "+i);
        if(i == 0) return "/index"; // 如果返回值为0 添加失败
        return "demo/helloworld";
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
