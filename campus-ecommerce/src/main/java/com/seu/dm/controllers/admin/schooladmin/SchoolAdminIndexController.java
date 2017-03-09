package com.seu.dm.controllers.admin.schooladmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/8.
 */
@Controller
@RequestMapping(value="/schooladmin")
public class SchoolAdminIndexController {
    @RequestMapping(value="/")
    public String index(){
        return "/admin/index";
    }
    @RequestMapping(value="/login")
    public String login() {
        return "/admin/login";
    }
}
