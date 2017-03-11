package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.configs.UploadConfigure;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.util.Iterator;

/**
 * Created by Greeting on 2017/3/9.
 * 校园首页管理
 */
@Controller("/campusadmin/homepagemanage")
@RequestMapping("/campusadmin/homepagemanage")
public class HomepageManageController {

    @Autowired
    private HomePageService homePageService;



    @RequestMapping("/")
    @CampusAdminPermission
    public String index() {
        return "admin/campusadmin/homepage/manage";
    }

    @RequestMapping("/edit")
    @CampusAdminPermission
    public String edit(){
        return "admin/campusadmin/homepage/edit";
    }

    @RequestMapping("/doedit")
    @CampusAdminPermission
    public String doEdit(){
        return "redirect:/campusadmin/homepagemanage/";
    }

    @RequestMapping("/add")
    @CampusAdminPermission
    public String add(){

        return "admin/campusadmin/homepage/add";
    }

    @RequestMapping("/doadd")
    @CampusAdminPermission
    public String doAdd(HttpServletRequest request, HttpSession httpSession) throws IOException{
        long startTime = System.currentTimeMillis();



        return "redirect:/campusadmin/homepagemanage/";

    }

    @RequestMapping("/dodelete")
    @CampusAdminPermission
    public String doDelete(){
        return "redirect:/campusadmin/homepagemanage/";
    }



    @RequestMapping("/doupdate")
    @CampusAdminPermission
    public String doUpdate() {






        return "redirect:/campusadmin/homepagemanage/";
    }
}
