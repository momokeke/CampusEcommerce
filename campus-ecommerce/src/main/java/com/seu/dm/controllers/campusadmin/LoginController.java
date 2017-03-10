package com.seu.dm.controllers.campusadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/9.
 * 处理校区管理员登录
 */
@Controller("/campusadmin/login")
@RequestMapping(value="/campusadmin/login")
public class LoginController {
    @RequestMapping(value="/")
    public String login() {
        return "admin/login";
    }

    @RequestMapping(value="/dologin")
    public String doLogin(HttpSession httpSession) {
        return "/xxx";
    }
}
