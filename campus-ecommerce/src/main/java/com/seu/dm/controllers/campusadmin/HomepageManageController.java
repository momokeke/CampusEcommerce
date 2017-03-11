package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.configs.UploadConfigure;
import com.seu.dm.dto.UserBaseDTO;
import com.seu.dm.helpers.FileUploadHelper;
import com.seu.dm.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    public String index(Model model,HttpSession httpSession) {
        Integer campusAdminId = ((UserBaseDTO)httpSession.getAttribute("userBase")).getId();
        model.addAttribute("list",homePageService.getHomePagesByCampusAdminId(campusAdminId));
        return "admin/campusadmin/homepage/manage";
    }

    @RequestMapping("/edit/{id}")
    @CampusAdminPermission
    public String edit(@PathVariable Integer id,Model model){
        model.addAttribute("one",homePageService.getHomePageById(id));
        return "admin/campusadmin/homepage/edit";
    }

    @RequestMapping("/doedit/{id}")
    @CampusAdminPermission
    public String doEdit(HttpServletRequest request,
                         @PathVariable Integer id,
                         @RequestParam Integer positionId,
                         @RequestParam String title,
                         @RequestParam String description,
                         @RequestParam String url,
                         @RequestParam Integer orderId,
                         HttpSession httpSession) throws IOException{


        Long currentTime = System.currentTimeMillis();
        String homePagePicturePath = UploadConfigure.homePagePicturesPath;
        String pictureSrc = FileUploadHelper.uploadPicture(request,"picture",homePagePicturePath + currentTime.toString());
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        homePageService.editHomePage(id,positionId,userBase.getId(),title,description,pictureSrc,url,orderId);
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
                        @RequestParam Integer positionId,
                        @RequestParam String description,
                        @RequestParam String url,
                        @RequestParam Integer orderId,
                        HttpSession httpSession) throws IOException{
        Long currentTime = System.currentTimeMillis();
        String homePagePicturePath = UploadConfigure.homePagePicturesPath;
        String pictureSrc = FileUploadHelper.uploadPicture(request,"picture",homePagePicturePath + currentTime.toString());
        UserBaseDTO userBase = (UserBaseDTO)httpSession.getAttribute("userBase");
        homePageService.addHomePage(userBase.getId(),positionId,title,description,pictureSrc,url,orderId);
        return "redirect:/campusadmin/homepagemanage/";
    }

    @RequestMapping("/dodelete/{id}")
    @CampusAdminPermission
    public String doDelete(@PathVariable Integer id,Model model){
        homePageService.deleteHomePageById(id);
        model.addAttribute("message","删除成功");
        model.addAttribute("jumpUrl","/campusadmin/homepagemanage/");
        return "common/alert";
    }



}
