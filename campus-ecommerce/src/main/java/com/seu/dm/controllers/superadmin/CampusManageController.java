package com.seu.dm.controllers.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.entities.Campus;
import com.seu.dm.services.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Greeting on 2017/3/9.
 * 超级管理员管理校区管理员
 */
@Controller("/superadmin/campusmanage")
@RequestMapping(value="/superadmin/campusmanage")
public class CampusManageController {
    @Autowired
    private CampusService campusService;

    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(Model model){
        List<Campus> campuses = campusService.findAllCampuses();
        model.addAttribute("campuses",campuses);
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

    @RequestMapping(value = "/addcampus/newcampus")
    @SuperAdminPermission
    public String addNewCampus(@RequestParam(value = "campusname")String campusName,
                               HttpServletRequest request, HttpServletResponse response,Model model){
        int i = campusService.addNewCampus(campusName);
        return "redirect:/superadmin/campusmanage/";
    }

    @RequestMapping(value = "/deletecampus/{id}")
    public String deleteCampus(@PathVariable Integer id,HttpServletRequest request){
        int i = campusService.deleteCampusById(id);
        return "redirect:/superadmin/campusmanage/";
    }
}
