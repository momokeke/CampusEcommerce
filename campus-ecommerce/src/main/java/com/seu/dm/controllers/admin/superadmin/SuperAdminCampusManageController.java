package com.seu.dm.controllers.admin.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 */
@Controller
@RequestMapping(value="/superadmin/campusmanage")
public class SuperAdminCampusManageController {
    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(){
        return "/admin/superadmin/campus_manage";
    }

    @RequestMapping(value="/addcampus")
    @SuperAdminPermission
    public String addCampus(){
        return "/admin/superadmin/campus_add";
    }

    @RequestMapping(value="/editcampus")
    @SuperAdminPermission
    public String editCampus(){
        return "/admin/superadmin/campus_edit";
    }
}
