package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Campus;
import com.seu.dm.mappers.CampusMapper;
import com.seu.dm.services.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/9.
 */
@Service
public class CampusServiceImpl implements CampusService {
    @Autowired
    private CampusMapper campusMapper;

    @Override
    public int addNewCampus(String campusName) {
        Campus newCampus = new Campus();
        newCampus.setName(campusName);
        return campusMapper.insert(newCampus);
    }

    @Override
    public List<Campus> findAllCampuses() {
        List<Campus> campuses = campusMapper.selectAll();
        for (Campus campus : campuses) {
            System.out.println(campus.getName());
        }
        return campuses;
    }

    @Override
    public int deleteCampusById(Integer id) {
        return campusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCampus(Integer id, String name) {
        Campus campus = new Campus();
        campus.setId(id);
        campus.setName(name);
        int i = campusMapper.updateByPrimaryKey(campus);
        return i;
    }

    @Override
    public Campus findCampus(Integer id) {
        return campusMapper.selectByPrimaryKey(id);
    }
}
