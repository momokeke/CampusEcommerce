package com.seu.dm.services;

import com.seu.dm.mappers.DemoMapper;
import com.seu.dm.entities.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Greeting on 2017/2/25.
 */

public interface DemoService {
    List<DemoEntity> getDemos();
    DemoEntity getDemo(Integer id);
    void testAspect();
    void showPage();
}
