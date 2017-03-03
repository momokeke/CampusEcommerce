package com.seu.dm.controllers;

import com.seu.dm.entities.DemoEntity;
import com.seu.dm.entities.Product;
import com.seu.dm.entities.User;
import com.seu.dm.services.DemoService;
import com.seu.dm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/2.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String addProduct(@RequestBody Product product, Model model){
//
//    }

    @RequestMapping(value = "/findAll")
    public String findAllProducts( Model model){
//        Product product = ;
//        model.addAttribute("product",product);
//        int i = productService.addProduct(product);
//        System.out.println(product);
       return "demo/helloworld";
    }

    @RequestMapping(value = "/login")
    public String addUser(User user, Model model){
        System.out.println("call");
        int i = productService.addUser(user);
        System.out.println("i = "+i);
        return "/demo/helloworld";
    }
    @RequestMapping(value = "/search/{id}")
    public String findProduct(@PathVariable Integer id,Model model){
        Product product =productService.findProduct(id);
        model.addAttribute("product",product);
        System.out.println("OK");
        return "/index";
    }
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findProductsByName(@RequestParam(value = "wd")String wd,Model model){
        List<Product> products = productService.findProductsByName(wd);
        for (Product product : products) {
            System.out.println(product.getName());
        }
        model.addAttribute("products",products);
       // System.out.println("ok");
        return "/index";
    }

    @RequestMapping(value = "/getCount")
    public String getCounts(@RequestParam(value = "wd")String wd, Model model){
        int i = productService.getCountOfResults(wd);
        System.out.println("find"+i+"messages");
        return "";
    }

    @RequestMapping(value = "/male")
    public String getMaleCount(Model model){
        int i = productService.getMaleCount();
        System.out.println("get "+i+"results");
        return "";
    }

}
