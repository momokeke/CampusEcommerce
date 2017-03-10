package com.seu.dm.controllers.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 超级管理员看统计信息
 */
@Controller("/superadmin/statistics")
@RequestMapping(value="/superadmin/statistics")
public class StatisticsController {
    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(){
        return "admin/superadmin/statistics";
    }
}
