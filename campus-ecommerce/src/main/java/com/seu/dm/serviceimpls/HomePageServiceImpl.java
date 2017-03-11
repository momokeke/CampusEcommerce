package com.seu.dm.serviceimpls;

import com.seu.dm.entities.HomePage;
import com.seu.dm.services.HomePageService;
import org.springframework.stereotype.Repository;

/**
 * Created by Greeting on 2017/3/11.
 */
@Repository
public class HomePageServiceImpl implements HomePageService {
    @Override
    public int updateTopSlider(HomePage slider1,HomePage slider2,HomePage slider3){
        return 0;
    }

    @Override
    public int updateBottomSlider(HomePage slider1,HomePage slider2,HomePage slider3){
        return 0;
    }

}
