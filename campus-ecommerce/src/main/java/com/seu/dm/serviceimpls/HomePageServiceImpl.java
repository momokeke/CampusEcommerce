package com.seu.dm.serviceimpls;

import com.seu.dm.entities.HomePage;
import com.seu.dm.mappers.HomePageMapper;
import com.seu.dm.mappers.SchoolAdminMapper;
import com.seu.dm.services.HomePageService;
import com.seu.dm.services.SchoolAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<HomePage> findHomePage(HomePage homePage) {
        return homePageMapper.findHomePage(homePage);
    }

    @Override
    public int addHomePage(HomePage homePage) {
        return homePageMapper.insert(homePage);
    }

    @Override
    public int editHomePage(HomePage homePage) {
        return homePageMapper.updateByPrimaryKey(homePage);
    }

    @Override
    public HomePage getHomePageById(Integer id){
        return homePageMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<HomePage> getHomePagesByCampusAdminId(Integer campusAdminId){
        Integer campusId = schoolAdminService.findAdmin(campusAdminId).getCampusId();
        return homePageMapper.getByCampusId(campusId);
    }

    @Override
    public int deleteHomePageById(Integer id){
        return homePageMapper.deleteByPrimaryKey(id);
    }

}
