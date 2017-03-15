package com.seu.dm.controllers.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.SuperAdmin;
import com.seu.dm.services.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/9.
 * 超级管理员登录
 */
@Controller("/superadmin/login")
@RequestMapping(value="/superadmin/login")
public class LoginController {

    @Autowired
    private SuperAdminService superAdminService;

    @RequestMapping(value="/")
    public String index(){

        return "admin/superadmin/login";
    }

    @RequestMapping(value="/out")
    public String logout(HttpSession httpSession,Model model){
        httpSession.removeAttribute("userBase");
        model.addAttribute("message","退出成功");
        model.addAttribute("jumpUrl","/superadmin/login/");
        return "common/alert";
    }

    @RequestMapping(value="/dologin", method = RequestMethod.POST)
    public String doLogin(HttpSession httpSession,
                          @RequestParam String username,
                          @RequestParam String password,
                          Model model){
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setName(username);
        superAdmin.setPassword(password);
        boolean checkResult = superAdminService.checkSuperAdmin(superAdmin);
        if(checkResult){
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setId(0);
            userBase.setRole("superAdmin");
            httpSession.setAttribute("userBase" , userBase);
            return "redirect:/superadmin/";
        }else{
            model.addAttribute("isWrong",true);
            return "admin/superadmin/login";
        }
    }
}
