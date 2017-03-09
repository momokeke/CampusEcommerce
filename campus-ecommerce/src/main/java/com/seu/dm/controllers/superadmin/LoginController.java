package com.seu.dm.controllers.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 超级管理员登录
 */
@Controller("/superadmin/login")
@RequestMapping(value="/superadmin/login")
public class LoginController {
    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(){
        return "";
    }
}
