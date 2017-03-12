package com.seu.dm.controllers;

import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Seller;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                        HttpServletRequest request, Model model){
        if("buyer".equals(userType)){
            System.out.println("buyer");
            Buyer buyerFromDB = buyerService.findBuyerByName(name);
            if(buyerFromDB == null) {
                model.addAttribute("message","登录失败，请注册买家账号");
                model.addAttribute("jumpUrl","/register");
                return "common/alert";
//                return "redirect:/register";
            }
            if(!password.equals(buyerFromDB.getPassword())) {
                model.addAttribute("message","密码错误");
                model.addAttribute("jumpUrl","/");
                return "common/alert";
            }
            HttpSession httpSession = request.getSession();
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setRole("buyer");
            userBase.setId(buyerFromDB.getId());
            userBase.setLogin(true);
            userBase.setCampusId(1);
            httpSession.setAttribute("userBase",userBase);
            return "redirect:/";
        }
        if("seller".equals(userType)){
            System.out.println("seller");
            Seller sellerFromDB = sellerService.findSellerByName(name);
            if(sellerFromDB == null) {
                model.addAttribute("message","登录失败，请注册卖家账号");
                model.addAttribute("jumpUrl","/register");
                return "common/alert";
//                System.out.println("login fail!");
//                return "redirect:/register";
            }
            if(!password.equals(sellerFromDB.getPassword())) {
                model.addAttribute("message","密码错误");
                model.addAttribute("jumpUrl","/");
                return "common/alert";
            }
            System.out.println("there");
            HttpSession httpSession = request.getSession();
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setRole("seller");
            userBase.setId(sellerFromDB.getId());
            userBase.setLogin(true);
            userBase.setCampusId(1);
            httpSession.setAttribute("userBase",userBase);
            return "redirect:/";
        }
        model.addAttribute("message","请选择类别");
        model.addAttribute("jumpUrl","/");
        return "common/alert";
    }

    @RequestMapping(value = "/register")
    public String jumpToRegister(){
        return "register";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null) return "redirect:/";
        httpSession.removeAttribute("userBase");
        return "redirect:/";
    }
}
