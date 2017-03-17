package com.seu.dm.controllers;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seu.dm.annotations.permissions.SellerPermission;
import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Order;
import com.seu.dm.entities.Product;
import com.seu.dm.entities.Seller;
import com.seu.dm.helpers.PageGenerateHelper;
import com.seu.dm.services.OrderService;
import com.seu.dm.services.ProductService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
    @Autowired
    private ProductService productService;

    @RequestMapping(value="/checkregister/{name}")
    @ResponseBody
    public Boolean checkRegister(@PathVariable String name){
        if(sellerService.findSellerByName(name)!=null){
            return false;
        }
        return true;
    }

    /**
     * 根据店铺注册信息向数据库添加卖家
     * @param seller
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addSeller(Seller seller,HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        System.out.println("call");

        String name = seller.getName();
        if(sellerService.findSellerByName(name)!=null){
            model.addAttribute("message","用户名已存在");
            model.addAttribute("jumpUrl","/register");
            return "common/alert";
        }

        seller.setCampusId((Integer)httpSession.getAttribute("campusId"));
        sellerService.addSeller(seller);                //由service层负责添加工作
        Seller sellerFromDB = sellerService.findSellerByName(seller.getName());
        UserBaseDTO userBase = new UserBaseDTO();
        userBase.setRole("seller");
        userBase.setId(sellerFromDB.getId());
        userBase.setLogin(true);
        userBase.setCampusId(1);
        httpSession.setAttribute("userBase",userBase);
        return "redirect:/";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginSeller(Seller seller,HttpServletRequest request){
        String name = seller.getName();
        Seller sellerFromDB = sellerService.findSellerByName(name);
        if(sellerFromDB == null) return "seller/register";
        if(seller.getPassword().equals(sellerFromDB.getPassword())) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", seller);
            return "redirect:/";
        }
        return "";
    }

    @RequestMapping(value = "/sellerLogout")
    @SellerPermission
    public String logoutSeller(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null) return "redirect:/";
        httpSession.removeAttribute("user");
        return "redirect:/";
    }

    /**
     * 根据修改信息向数据库提交店铺修改
     * @param seller
     * @return
     */
    @RequestMapping(value = "/updateSellerInfo",method = RequestMethod.POST)
    @SellerPermission
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
    @CampusAdminPermission
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
    @CampusAdminPermission
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
    @CampusAdminPermission
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
    @CampusAdminPermission
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
    @CampusAdminPermission
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
    @RequestMapping(value = "/center")
    @SellerPermission
    public String jumpToSellerCenter() {
        return "seller/seller_center";
    }


    @RequestMapping(value = "/shop_homepage")
    @SellerPermission
    public String test(){
        return "shop/shop_homepage";
    }

    @RequestMapping(value = "/stock")
    @SellerPermission
    public String manageInventory(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                  HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        PageHelper.startPage(pageNum,10);
        List<Product> products = productService.findProductsBySellerId(sellerId);
        PageInfo pageInfo = new PageInfo(products);
        PageGenerateHelper.generatePage(request,model,pageInfo);
        model.addAttribute("products",products);
        return "/seller/stock_goods";
    }

    @RequestMapping(value = "/updateproduct/{id}")
    @SellerPermission
    public String updateProductInfo(@PathVariable Integer id,
                                    @RequestParam(value = "inventory")Integer inventory,
                                    @RequestParam(value = "price")Double price,
                                    HttpServletRequest request,Model model){
        Product product = productService.findProduct(id);
        product.setInventory(inventory);
        product.setPrice(BigDecimal.valueOf(price));
        productService.updateProduct(product);
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Product> products = productService.findProductsBySellerId(sellerId);
        model.addAttribute("products",products);
        return "/seller/stock_goods";
    }

    @RequestMapping(value = "/unshelfproduct/{id}")
    @SellerPermission
    public String unshelfproduct(@PathVariable Integer id,HttpServletRequest request,Model model){
        Product product = productService.findProduct(id);
        product.setIsShelf(false);
        productService.updateProduct(product);
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Product> products = productService.findProductsBySellerId(sellerId);
        model.addAttribute("products",products);
        return "/seller/stock_goods";
    }


    @RequestMapping(value = "/orders")
    @SellerPermission
    public String getAllOrdersOfSeller(Model model, HttpSession httpSession){
        // Integer sellerId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getSellerId();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Order> orders = orderService.findOrdersBySellerId(sellerId);
        model.addAttribute("orders",orders);
        return "seller/transaction_manage";
    }

    @RequestMapping(value = "/ordersWaitdeliver")
    @SellerPermission
    public String findSellerOrdersWithStatusWaitDeliver(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Order> orders = orderService.findOrdersBySellerIdWithStatusWaitDeliver(sellerId);
        model.addAttribute("orders",orders);
        return "seller/transaction_managewaitdeliver";
    }

    @RequestMapping(value = "/ordersAlreadydeliver")
    @SellerPermission
    public String findSellerOrdersWithStatusAlreadyDelever(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Order> orders = orderService.findOrdersBySellerIdWithStatusAlreadyDeliver(sellerId);
        model.addAttribute("orders",orders);
        return "seller/transaction_managealreadydeliver";
    }

    @RequestMapping(value = "/ordersOnrejection")
    @SellerPermission
    public String findSellerOrdersWithStatusOnRejection(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Order> orders = orderService.findOrdersBySellerIdWithStatusOnRejection(sellerId);
        model.addAttribute("orders",orders);
        return "seller/transaction_manageonrejection";
    }

    @RequestMapping(value = "/ordersAlreadyrejection")
    @SellerPermission
    public String findSellerOrdersWithStatusAlreadyRejection(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Order> orders = orderService.findOrdersBySellerIdWithStatusAlreadyRejection(sellerId);
        model.addAttribute("orders",orders);
        return "seller/transaction_managealreadyrejection";
    }

    @RequestMapping(value = "/ordersSuccess")
    @SellerPermission
    public String findSellerOrdersWithStatusSuccess(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        Integer sellerId = userBase.getId();
        List<Order> orders = orderService.findOrdersBySellerIdWithStatusSuccess(sellerId);
        model.addAttribute("orders",orders);
        return "seller/transaction_managesuccess";
    }
}
