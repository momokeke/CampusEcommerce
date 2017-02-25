package com.seu.dm.services;

import com.seu.dm.mappers.DemoMapper;
import com.seu.dm.entities.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Greeting on 2017/2/25.
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public List<DemoEntity> getDemos(){
        List<DemoEntity> demos = demoMapper.getDemos();
        return demos;
    }

    public DemoEntity getDemo(Integer id){
        DemoEntity demo = demoMapper.getDemoById(id);
        return demo;
    }
}
