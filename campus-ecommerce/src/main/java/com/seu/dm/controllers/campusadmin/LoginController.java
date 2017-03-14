package com.seu.dm.controllers.campusadmin;

import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.entities.SuperAdmin;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/9.
 * 处理校区管理员登录
 */
@Controller("/campusadmin/login")
@RequestMapping(value="/campusadmin/login")
public class LoginController {

    @Autowired
    private SchoolAdminService schoolAdminService;

    @RequestMapping(value="/")
    public String login() {
        return "admin/campusadmin/login";
    }

    @RequestMapping(value="/dologin", method = RequestMethod.POST)
    public String doLogin(HttpSession httpSession,
                          @RequestParam String username,
                          @RequestParam String password) {
        SchoolAdmin schoolAdmin = new SchoolAdmin();
        schoolAdmin.setName(username);
        schoolAdmin.setPassword(password);
        schoolAdminService.findAdmin(schoolAdmin);

        /*
        if(checkResult){
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setId(0);
            userBase.setRole("superAdmin");
            httpSession.setAttribute("userBase" , userBase);
            return "redirect: /superadmin/";
        }else{
            model.addAttribute("isWrong",true);
            return "admin/superadmin/login";
        }*/
        return "xxx";
    }
}
