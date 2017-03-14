package com.seu.dm.services;

import com.seu.dm.entities.HomePage;

import java.util.List;

/**
 * Created by Greeting on 2017/3/11.
 */
public interface HomePageService {
    int addHomePage(HomePage homePage);
    int editHomePage(HomePage homePage);
    HomePage getHomePageById(Integer id);
    List<HomePage> getHomePagesByCampusAdminId(Integer campusAdminId);
    int deleteHomePageById(Integer id);
    List<HomePage> findHomePage(HomePage homePage);

}
