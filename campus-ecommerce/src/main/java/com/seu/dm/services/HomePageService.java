package com.seu.dm.services;

import com.seu.dm.entities.HomePage;

/**
 * Created by Greeting on 2017/3/11.
 */
public interface HomePageService {
    public int updateTopSlider(HomePage slider1,HomePage slider2,HomePage slider3);
    public int updateBottomSlider(HomePage slider1,HomePage slider2,HomePage slider3);
}
