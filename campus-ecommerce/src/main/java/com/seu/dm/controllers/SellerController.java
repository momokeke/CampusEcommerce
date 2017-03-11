package com.seu.dm.controllers;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.annotations.permissions.SellerPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Order;
import com.seu.dm.entities.Seller;
import com.seu.dm.services.OrderService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private OrderService orderService;

    /**
     * 根据店铺注册信息向数据库添加卖家
     * @param seller
     * @return
     */
    @RequestMapping(value = "/addSellerInfo", method = RequestMethod.POST)
    public String addSeller(Seller seller){
        sellerService.addSeller(seller);                //由service层负责添加工作
        return "/";
    }

    /**
     * 根据修改信息向数据库提交店铺修改
     * @param seller
     * @return
     */
    @RequestMapping(value = "/updateSellerInfo",method = RequestMethod.POST)
    public String updateSellerInfo(Seller seller){
        sellerService.updateSeller(seller);
        return "modify_message";
    }

    /**
     * 根据店铺ID从数据库中删除指定店铺
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteSellerInfo/{id}")
    public String deleteSellerInfo(@PathVariable Integer id){
        sellerService.deleteSeller(id);
        return "/";
    }

    /**
     *根据店铺ID查找对应店铺
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/findSellerInfoById")
    public String findSellerInfoById(@RequestParam(value = "id") Integer id, Model model){
        Seller seller = sellerService.findSeller(id);
        model.addAttribute("seller", seller);
        return "/";
    }

    /**\
     * 根据店铺名从数据库找到对应店铺
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/findSellerInfoByName")
    public String findSellerInfoByName(@RequestParam(value = "name") String name, Model model){
        Seller seller = sellerService.findSellerByName(name);
        System.out.println(seller);
        model.addAttribute("seller", seller);
        return "/";
    }

    /**
     * 根据店铺名从数据库中删除指定店铺
     * @param name
     * @return
     */
    @RequestMapping(value = "/deleteSellerInfo",method = RequestMethod.GET)
    public String deleteSellerInfoByName(@RequestParam(value = "name")String name){
        sellerService.deleteSellerByName(name);
        return "/";
    }

    /**
     * 返回所有的店铺数
     * @param model
     * @return
     */
    @RequestMapping(value = "/findCountOfAllSellers")
    public String findCountOfAllSellers(Model model){
        int i = sellerService.selectCountOfSellers();
        model.addAttribute("countOfAllSellers",i);
        return "/";
    }

    /**
     * 进入卖家登录页面
     */


    /*
    *进入买家注册页面
     */
    @RequestMapping(value = "/seller_register")
    public String jumpToSellerRegister(){
        return "seller/seller_register";
    }

    /*
    *进入买家中心页面
     */
    @RequestMapping(value = "/seller_center")
    public String jumpToSellerCenter() {
        return "seller/seller_center";
    }


    @RequestMapping(value = "/shop_homepage")
    public String test(){
        return "shop/shop_homepage";
    }


    @RequestMapping(value = "/ordersmanage")
    @SellerPermission
    public String getAllOrdersOfSeller(Model model, HttpSession httpSession){
        Integer sellerId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getSellerId();
        List<Order> orders = orderService.findOrdersBySellerId(sellerId);
        model.addAttribute("orders",orders);
        return "";
    }
}
