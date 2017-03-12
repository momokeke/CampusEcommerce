package com.seu.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Greeting on 2017/2/28.
 * 首页
 */
@Controller
public class IndexController {
    @RequestMapping(value={"/","/index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam String name,@RequestParam String password,@RequestParam String userType){
        if("buyer".equals(userType)) return "buyer/login";
        return "";
    }
}
