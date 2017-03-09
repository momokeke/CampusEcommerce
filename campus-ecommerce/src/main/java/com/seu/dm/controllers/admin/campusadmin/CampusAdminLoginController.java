package com.seu.dm.controllers.admin.campusadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/9.
 */
@Controller
@RequestMapping(value="/campusadmin/login")
public class CampusAdminLoginController {
    @RequestMapping(value="/")
    public String login() {
        return "/admin/login";
    }

    @RequestMapping(value="/doLogin")
    public String doLogin(HttpSession httpSession) {
        return "/xxx";
    }
}
