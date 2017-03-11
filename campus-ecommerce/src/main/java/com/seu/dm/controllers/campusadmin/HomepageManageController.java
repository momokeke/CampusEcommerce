package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.configs.UploadConfigure;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.entities.HomePage;
import com.seu.dm.helpers.FileUploadHelper;
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
    public String doEdit(HttpServletRequest request,
                         @RequestParam Integer id,
                         @RequestParam String title,
                         @RequestParam String description,
                         @RequestParam String url,
                         @RequestParam Integer order,
                         HttpSession httpSession){

        return "redirect:/campusadmin/homepagemanage/";
    }

    @RequestMapping("/add")
    @CampusAdminPermission
    public String add(){

        return "admin/campusadmin/homepage/add";
    }

    @RequestMapping("/doadd")
    @CampusAdminPermission
    public String doAdd(HttpServletRequest request,
                        @RequestParam String title,
                        @RequestParam String description,
                        @RequestParam String url,
                        @RequestParam Integer order,
                        HttpSession httpSession) throws IOException{
        Long currentTime = System.currentTimeMillis();
        String homePagePicturePath = UploadConfigure.homePagePicturesPath;
        String pictureSrc = FileUploadHelper.uploadPicture(request,"picture",homePagePicturePath + currentTime.toString());
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        homePageService.addHomePage(userBase.getCampusId(),title,description,pictureSrc,url,order);
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
