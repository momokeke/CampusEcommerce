package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 校园首页管理
 */
@Controller("/campusadmin/homepagemanage")
@RequestMapping("/campusadmin/homepagemanage")
public class HomepageManageController {
    @RequestMapping("/")
    @CampusAdminPermission
    public String index(){
        return "admin/campusadmin/homepage/manage";
    }
}
