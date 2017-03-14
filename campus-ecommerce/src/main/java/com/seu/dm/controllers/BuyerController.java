package com.seu.dm.controllers;

import com.seu.dm.dto.CartProductDTO;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.Buyer;
import com.seu.dm.entities.Order;
import com.seu.dm.helpers.mail.MailSender;
import com.seu.dm.entities.Product;
import com.seu.dm.entities.Seller;
import com.seu.dm.services.BuyerService;
import com.seu.dm.services.OrderService;
import com.seu.dm.services.ProductService;
import com.seu.dm.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private ProductService productService;
    @Autowired
    private SellerService sellerService;
    /**
     * 注册用户
     * @param buyer
     * @param model
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String addBuyer(Buyer buyer, Model model, HttpServletRequest request){
        //置标志位为未激活
        buyer.setIsActive(false);
        HttpSession httpSession = request.getSession();
        System.out.println("call");

        //向数据库中添加买家
        int i = buyerService.addBuyer(buyer);
        Buyer buyerFromDB = buyerService.findBuyerByName(buyer.getName());

        //发送验证激活邮件
        MailSender.send(buyerFromDB.getId(),buyerFromDB.getEmail());

        //
        UserBaseDTO userBase = new UserBaseDTO();
        userBase.setRole("buyer");
        userBase.setId(buyerFromDB.getId());
        userBase.setLogin(true);
        userBase.setCampusId(1);
        httpSession.setAttribute("userBase",userBase);
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
//        Integer studentNumber = buyer.getStudentNumber();
//        Buyer buyerFromDB = buyerService.findBuyerByStudentNumber(studentNumber);
        String buyerName = buyer.getName();
        Buyer buyerFromDB = buyerService.findBuyerByName(buyerName);
        if(buyerFromDB == null) return "buyer/register";
        if(buyer.getPassword().equals(buyerFromDB.getPassword())) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", buyer);
            return "redirect:/";
        }
        return "";
    }

    /**
     * 移除session中的userBase并回到首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/buyerLogout")
    public String logoutBuyer(HttpServletRequest request){
        HttpSession httpSession = request.getSession(false);
        if(httpSession == null) return "redirect:/";
        httpSession.removeAttribute("userBase");
        return "redirect:/";
    }

    @RequestMapping(value = "/orders")
    public String findBuyerOrders(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("userBase");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerId(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/waitdeliver")
    public String findBuyerOrdersWithStatusWaitDeliver(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("userBase");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusWaitDeliver(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/onrejection")
    public String findBuyerOrdersWithStatusOnRejection(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("userBase");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusOnRejection(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/alreadyrejection")
    public String findBuyerOrdersWithStatusAlreadyRejection(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("userBase");
        Integer buyerId = buyer.getId();
        List<Order> orders = orderService.findOrdersByBuyerIdWithStatusAlreadyRejection(buyerId);
        model.addAttribute("orders",orders);
        return "redirect:/buyer/orders";
    }

    @RequestMapping(value = "/orders/success")
    public String findBuyerOrdersWithStatusSuccess(HttpServletRequest request,Model model){
        HttpSession httpSession = request.getSession();
        Buyer buyer = (Buyer) httpSession.getAttribute("userBase");
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
    @RequestMapping(value = "/center")
    public String jumpToBuyerCenter(){
        return "buyer/buyer_center";
    }


    /**
     *跳到买家购物车
    */
    @RequestMapping(value = "/shopping_cart")
    public String jumpToBuyerShoppingCart(HttpSession httpSession,Model model){
        Map<Integer,Integer> cartMap = (Map<Integer,Integer>)httpSession.getAttribute("cart");

        List<CartProductDTO> cartProducts = new ArrayList<>();
        //遍历cartMap，遍历出来的key是productid，value是这个商品的数量
        //根据id调用Service获得商品的信息，在for里面new一个CartProduct，在CartProduct取好所有数据填好，放进list
        //然后把要的数据放进Model，然后去html里面用th取出来
        for (Map.Entry<Integer, Integer> entry : cartMap.entrySet()) {
            Integer productid = (Integer)  entry.getKey();
            Integer num = (Integer)entry.getValue();
            Product product=productService.findProduct(productid);
            Seller seller= sellerService.findSeller(product.getSellerId());
            CartProductDTO cartProductDTO=new CartProductDTO();
            cartProductDTO.setId(product.getId());
            cartProductDTO.setName(product.getName());
            cartProductDTO.setPictureId(product.getPictureId());
            cartProductDTO.setNum(num);
            cartProductDTO.setPrice(product.getPrice());
            cartProductDTO.setShopName(seller.getShopName());
            cartProducts.add(cartProductDTO);

        }
        model.addAttribute("cartProducts",cartProducts);
        return "buyer/shopping_cart";
    }

    @RequestMapping(value = "/shopping_cart_change")
    @ResponseBody
    public Object changeShoppingCart(@RequestParam Integer id,@RequestParam Integer newNum,HttpSession httpSession){
        Map<Integer,Integer> cartMap = (Map<Integer,Integer>)httpSession.getAttribute("cart");
        cartMap.put(id,newNum);
        return "ok";
    }

    @RequestMapping(value = "/shopping_cart/remove/{id}")
    public String removeProductFromCart(@PathVariable Integer id, HttpSession httpSession, Model model){
        Map<Integer,Integer> cartMap = (Map<Integer,Integer>)httpSession.getAttribute("cart");
        cartMap.remove(id);
        httpSession.setAttribute("cartMap",cartMap);
        return "redirect:/buyer/shopping_cart";
    }

    /*
    *加入购物车
     */

    @RequestMapping(value = "/shopping_cart/add/{id}")
    public String addProductFromCart( @PathVariable Integer id, HttpSession httpSession, Model model){
        HashMap<Integer,Integer> cartMap = null;
        if(httpSession.getAttribute("cart") == null){
            cartMap = new HashMap<>();
        }else {
            cartMap = (HashMap<Integer, Integer>) httpSession.getAttribute("cart");
        }
        cartMap.put(id,1);
        httpSession.setAttribute("cart",cartMap);
        return "redirect:/buyer/shopping_cart";
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
