package com.seu.dm.controllers.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/9.
 * 超级管理员首页
 */
@Controller("/superadmin")
@RequestMapping(value="/superadmin")
public class IndexController {
    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(HttpSession httpSession){
        return "/admin/index";
    }
}
