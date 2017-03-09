package com.seu.dm.controllers.admin.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 */
@Controller
@RequestMapping(value="/superadmin/statistics")
public class SuperAdminStatisticsController {
    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(){
        return "/admin/superadmin/statistics";
    }
}
