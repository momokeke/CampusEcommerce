package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.dto.UserBaseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/8.
 * 校区管理员首页
 */
@Controller("/campusadmin")
@RequestMapping(value="/campusadmin")
public class IndexController {
    @RequestMapping(value="/")
    @CampusAdminPermission
    public String index(HttpSession httpSession){
        return "/admin/index";
    }

}
