package com.seu.dm.serviceimpls;

import com.seu.dm.entities.HomePage;
import com.seu.dm.mappers.HomePageMapper;
import com.seu.dm.mappers.SchoolAdminMapper;
import com.seu.dm.services.HomePageService;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Greeting on 2017/3/11.
 */
@Repository
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    SchoolAdminService schoolAdminService;

    @Autowired
    HomePageMapper homePageMapper;

    @Override
    public int addHomePage(Integer campusAdminId,String title,String description,String pictureSrc,String url,Integer order){
        Integer campusId = schoolAdminService.findAdmin(campusAdminId).getSchoolId();
        HomePage homePage = new HomePage();
        if(pictureSrc != null && pictureSrc != "" ) {
            homePage.setPictureSrc(pictureSrc);
        }
        homePage.setDescription(description);
        homePage.setPictureUrl(url);
        homePage.setCampusId(campusId);
        homePage.setTitle(title);
        homePage.setOrder(order);
        return homePageMapper.insert(homePage);
    }

    @Override
    public int editHomePage(Integer id,Integer campusAdminId,String title,String description,String pictureSrc,String url,Integer order){
        Integer campusId = schoolAdminService.findAdmin(campusAdminId).getSchoolId();
        HomePage homePage = new HomePage();
        if(pictureSrc != null && pictureSrc != "" ) {
            homePage.setPictureSrc(pictureSrc);
        }
        homePage.setDescription(description);
        homePage.setPictureUrl(url);
        homePage.setCampusId(campusId);
        homePage.setTitle(title);
        homePage.setOrder(order);
        homePage.setId(id);
        return homePageMapper.updateByPrimaryKey(homePage);
    }

}
