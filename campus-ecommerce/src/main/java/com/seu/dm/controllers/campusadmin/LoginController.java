package com.seu.dm.controllers.campusadmin;

import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.entities.SuperAdmin;
import com.seu.dm.serviceimpls.CampusServiceImpl;
import com.seu.dm.services.CampusService;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private CampusService campusService;

    @RequestMapping(value="/")
    public String login() {
        return "admin/campusadmin/login";
    }

    @RequestMapping(value="/dologin", method = RequestMethod.POST)
    public String doLogin(HttpSession httpSession,
                          @RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        SchoolAdmin schoolAdminCondition = new SchoolAdmin();
        schoolAdminCondition.setName(username);
        schoolAdminCondition.setPassword(password);
        SchoolAdmin schoolAdmin = schoolAdminService.findAdmin(schoolAdminCondition);
        if(schoolAdmin != null){
            UserBaseDTO userBase = new UserBaseDTO();
            userBase.setId(schoolAdmin.getId());
            userBase.setCampusId(schoolAdmin.getCampusId());
            String campusName = campusService.findCampus(schoolAdmin.getCampusId()).getName();
            userBase.setCampusName(campusName);
            userBase.setLogin(true);
            userBase.setRole("campusAdmin");
            httpSession.setAttribute("userBase" , userBase);
            return "redirect: /campusadmin/";
        }else{
            model.addAttribute("isWrong",true);
            return "admin/campusadmin/login";
        }
    }
}
