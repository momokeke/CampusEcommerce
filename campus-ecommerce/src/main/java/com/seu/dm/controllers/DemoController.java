package com.seu.dm.controllers;

import com.seu.dm.entities.DemoEntity;
import com.seu.dm.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String helloWorld(){
        demoService.testAspect();
        return "demo/helloworld";
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

    @RequestMapping(value ="/seller")
    public  String jumpToSellerCenter(){
        return "seller/seller_center";
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

}
