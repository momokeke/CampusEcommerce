package com.seu.dm.services;

import com.seu.dm.entities.HomePage;

import java.util.List;

/**
 * Created by Greeting on 2017/3/11.
 */
public interface HomePageService {
    int addHomePage(Integer campusAdminId,Integer positionId,String title,String description,String pictureSrc,String url,Integer order);
    int editHomePage(Integer id,Integer positionId,Integer campusAdminId,String title,String description,String pictureSrc,String url,Integer order);
    HomePage getHomePageById(Integer id);
    List<HomePage> getHomePagesByCampusAdminId(Integer campusAdminId);
    int deleteHomePageById(Integer id);
}
