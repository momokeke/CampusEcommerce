package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.entities.Campus;
import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.services.CampusService;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员个人信息管理
 */
@Controller("/campusadmin/infomanage")
@RequestMapping("/campusadmin/infomanage")
public class InfoManageController {
    @Autowired
    private SchoolAdminService schoolAdminService;
    @Autowired
    private CampusService campusService;
    @RequestMapping("/")
    @CampusAdminPermission
    public String index(Model model){
//        int id = 107;
//        SchoolAdmin schoolAdmin = schoolAdminService.findAdim(Integer.valueOf(id));
//        System.out.println(schoolAdmin.getName());
//        System.out.println(schoolAdmin.getSchoolId());
//        Campus campus = campusService.findCampus(schoolAdmin.getSchoolId());
//        model.addAttribute("schoolAdmin",schoolAdmin);
//        model.addAttribute("campus",campus);
        return "admin/campusadmin/info/manage";
    }
}
