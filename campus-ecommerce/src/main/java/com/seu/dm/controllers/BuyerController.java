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
        return "/demo/helloworld";
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
        return "/index";
    }


}
