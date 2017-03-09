package com.seu.dm.controllers.admin.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/8.
 */
@Controller
@RequestMapping(value="/campusadmin")
public class CampusAdminIndexController {
    @RequestMapping(value="/")
    @CampusAdminPermission
    public String index(HttpSession httpSession){
        UserBaseDTO userBase = new UserBaseDTO();
        userBase.setRole("schoolAdmin");
        httpSession.setAttribute("userBase",userBase);
        return "/admin/index";
    }

}
