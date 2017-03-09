package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员个人信息管理
 */
@Controller("/campusadmin/infomanage")
@RequestMapping("/campusadmin/infomanage")
public class InfoManageController {
    @RequestMapping("/")
    @CampusAdminPermission
    public String index(){
        return "";
    }
}
