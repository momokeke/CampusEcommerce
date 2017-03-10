package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员看统计信息
 */
@Controller("/campusadmin/statistics")
@RequestMapping(value="/campusadmin/statistics")
public class StatisticsController {
    @RequestMapping("/")
    @CampusAdminPermission
    public String index(){
        return "admin/campusadmin/statistics/manage";
    }
}
