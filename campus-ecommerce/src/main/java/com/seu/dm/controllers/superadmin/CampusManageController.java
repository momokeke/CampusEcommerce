package com.seu.dm.controllers.superadmin;

import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.entities.Campus;
import com.seu.dm.entities.SchoolAdmin;
import com.seu.dm.services.CampusService;
import com.seu.dm.services.SchoolAdminService;
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
    @Autowired
    private SchoolAdminService schoolAdminService;

    /**
     * 超级管理员首页，显示所有校区
     * @param model
     * @return
     */
    @RequestMapping(value="/")
    @SuperAdminPermission
    public String index(Model model){
        List<Campus> campuses = campusService.findAllCampuses();
        model.addAttribute("campuses",campuses);
        return "/admin/superadmin/campus_manage";
    }

    /**
     * 链接到校区添加页面
     * @return
     */
    @RequestMapping(value="/addcampus")
    @SuperAdminPermission
    public String addCampus(){
        return "/admin/superadmin/campus_add";
    }

    /**
     * 链接到校区编辑页面，并在model中加入
     * 对应校区所有的管理员供前端使用
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/editcampus/{id}")
    @SuperAdminPermission
    public String editCampus(@PathVariable Integer id,Model model){
        List<SchoolAdmin> schoolAdmins = schoolAdminService.findAllSchoolAdminsBySchoolId(id);
        model.addAttribute("campusId",id);
        model.addAttribute("schooladmins",schoolAdmins);
        //System.out.println(schoolAdmins.size());
        return "/admin/superadmin/campus_edit";
    }

    /**
     * 修改校区名称，重定向到校园管理员首页
     * @param id
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/editcampus/updatecampus/{id}")
    @SuperAdminPermission
    public String updateCampus(@PathVariable Integer id,@RequestParam(value = "campus")String name,Model model){
        campusService.updateCampus(id,name);
        return "redirect:/superadmin/campusmanage/";
    }

    /**
     * 加入新校区，重定向到超级管理员首页
     * @param campusName
     * @param request
     * @param response
     * @param model
     * @return
     */
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

    @RequestMapping(value = "/addschooladmin/{id}")
    public String addSchoolAdmin(@PathVariable Integer id,HttpServletRequest request,Model model){
        model.addAttribute("campusId",id);
        //System.out.println(id);
        return "admin/superadmin/campus_add_schooladmin";
    }

    @RequestMapping(value = "/addschooladmin/add/{id}")
    public String addSchoolAdminByNumAndName(@PathVariable Integer id,
                                             @RequestParam(value = "schoolAdminId")Integer studentNumber,
                                             @RequestParam(value = "schoolAdminname")String name,
                                             HttpServletRequest request){
        int i = schoolAdminService.addSchoolAdminByNumAndName(id,studentNumber,name);
        return "redirect:/superadmin/campusmanage/editcampus/"+id;
    }

    @RequestMapping("/deleteschooladmin/{schoolid}/{schooladminid}")
    public String deleteSchoolAdmin(@PathVariable Integer schoolid,
                                    @PathVariable Integer schooladminid,HttpServletRequest request){
        int i = schoolAdminService.deleteSchoolAdmin(schooladminid);
        return "redirect:/superadmin/campusmanage/editcampus/"+schoolid;
    }
}
