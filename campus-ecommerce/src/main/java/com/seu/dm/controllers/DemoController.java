package com.seu.dm.controllers;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.seu.dm.entities.DemoEntity;
import com.seu.dm.helpers.alipay.constants.AlipayServiceEnvConstants;
import com.seu.dm.helpers.alipay.factory.AlipayAPIClientFactory;
import com.seu.dm.services.DemoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Greeting on 2017/2/25.
 */
@Controller
@RequestMapping(value="/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * The simplest example for showing hello world
     * @return
     */
    @RequestMapping(value="/helloworld")
    public String helloWorld(HttpServletRequest request, HttpServletResponse response){
        demoService.testAspect();
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "seller/new_products";
    }

    @RequestMapping(value = "/jump")
    public String jumpTo(){
        return "buyer/buyer_center";
    }
    /**
     * Example for returing Object in Json
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/json")
    public Object json(){
        DemoEntity demo = new DemoEntity();
        demo.setId(1);
        demo.setUsername("admin");
        demo.setAddress("123");
        return demo;
    }

    /**
     * Example for showing objects in list
     * @return
     */
    @RequestMapping(value="/demos")
    public String getDemos(Model model){
        List<DemoEntity> demos = demoService.getDemos();
        model.addAttribute("demos",demos);
        return "demo/demos";
    }

    /**
     * Example for getting the parameter from the URL(get) and returing the specific object
     * @param id
     * @return
     */
    @RequestMapping(value="/demo")
    public String getDemoById(@RequestParam(value="id",required=true) Integer id,Model model){
        DemoEntity demo = demoService.getDemo(id);
        model.addAttribute("demo",demo);
        return "demo/demo";
    }

    /**
     * Example for getting the parameter from the URL(restful) and returing the specific object
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value={"/demo/{id}","/demo.html/{id}"})
    public String getRestfulDemoById(@PathVariable Integer id,Model model){
        DemoEntity demo = demoService.getDemo(id);
        model.addAttribute("demo",demo);
        return "demo/demo";
    }


    @RequestMapping(value = "/aspect")
    public void testAspect(){
        demoService.testAspect();
    }


    /**
     * 进入店铺主页
     * @return
     */
    @RequestMapping(value="/shopHomepage")
    public String jumpToShopHomepage(){
        return "shop/shop_homepage";
    }
    /**
     * 进入店铺商品分类页面
     * @return
     */
    @RequestMapping(value="/shopProductCla")
    public String jumpToShopProductCla(){
        return "shop/shop_product_classification";
    }
    /**
     * 进入商品详情页面
     * @return
     */
    @RequestMapping(value="/productDetails")
    public String jumpToProductDetails(){
        return "product/product_details";
    }
    /**
     * 进入商品列表页面
     * @return
     */
    @RequestMapping(value="/productList")
    public String jumpToProductList(){
        return "product/product_list";
    }




    @RequestMapping(value ="/seller")
    public  String jumpToSellerCenter(){
        return "seller/seller_center";
    }

    @RequestMapping(value ="/modify")
    public  String jumpToModify(){
        return "seller/modify_message";
    }

    @RequestMapping(value ="/new")
    public  String jumpToNewProduct(){
        return "seller/new_products";
    }

    @RequestMapping(value ="/sold")
    public  String jumpToSoldGoods(){
        return "seller/sold_goods";
    }

    @RequestMapping(value ="/stock")
    public  String jumpToStockGoods(){
        return "seller/stock_goods";
    }

    @RequestMapping(value ="/transaction")
    public  String jumpToTransaction(){
        return "seller/transaction_manage";
    }

    @RequestMapping(value ="/refund")
    public  String jumpToRefund(){
        return "seller/refund";
    }
    @RequestMapping(value={"/register"})
    public String jumpToRegister(){return "register";}

    @RequestMapping(value={"/aboutUs"})
    public String jumpToAboutUs(){
        return "aboutus/aboutUs";}

    @RequestMapping(value={"/service"})
    public String jumpToService(){
        return "aboutus/service";}

    @RequestMapping(value={"/disclaimer"})
    public String jumpToDisclaimer(){
        return "aboutus/disclaimer";}

    @RequestMapping(value={"/map"})
    public String jumpToWebMap(){
        return "aboutus/webMap";}

    @RequestMapping(value={"/contactUs"})
    public String jumpToContactUs(){
        return "aboutus/ContactUs";}

    @RequestMapping(value = "/testAipay")
    public void Ailipay(HttpServletRequest request,HttpServletResponse response) throws IOException {
        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        System.out.println("called");
        alipayRequest.setReturnUrl("http://139.199.222.147:8080/demo/testAliReturn");
        alipayRequest.setNotifyUrl("http://139.199.222.147:8080/demo/testNotifyUrl");

        JSONObject json = new JSONObject();
        json.put("out_trade_no","20150320010101123140");
        json.put("total_amount","0.88");
        json.put("subject","test");
        json.put("seller_id","2088102169780725");
        json.put("product_code","QUICK_WAP_PAY");

        alipayRequest.setBizContent(json.toString());
        try {
            String form = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=" + AlipayServiceEnvConstants.CHARSET);
            response.getWriter().write(form);
            response.getWriter().flush();
        }catch (AlipayApiException e){
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/testAliReturn")
    public String returnFromAlipay(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        System.out.println("ss");
        return "demo/testAliReturn";
    }

    @RequestMapping(value = "/testNotifyUrl")
    public String swss(){
        System.out.println("swss");
        return "demo/testNotifyUrl";
    }
}
