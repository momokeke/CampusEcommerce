package com.seu.dm.services;

import com.seu.dm.entities.Campus;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/9.
 */
public interface CampusService {
    int addNewCampus(String campusName);

    List<Campus> findAllCampuses();

    int deleteCampusById(Integer id);

    int updateCampus(Integer id,String name);
}
