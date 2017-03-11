package com.seu.dm.services;

import com.seu.dm.entities.HomePage;

/**
 * Created by Greeting on 2017/3/11.
 */
public interface HomePageService {
    public int addHomePage(Integer campusAdminId,String title,String description,String pictureSrc,String url,Integer order);
    public int editHomePage(Integer id,Integer campusAdminId,String title,String description,String pictureSrc,String url,Integer order);

}
