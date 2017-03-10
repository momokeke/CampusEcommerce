package com.seu.dm.serviceimpls;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seu.dm.entities.DemoEntity;
import com.seu.dm.mappers.DemoMapper;
import com.seu.dm.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Greeting on 2017/2/26.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<DemoEntity> getDemos(){
        List<DemoEntity> demos = demoMapper.getDemos();
        return demos;
    }

    @Override
    public DemoEntity getDemo(Integer id){
        DemoEntity demo = demoMapper.getDemoById(id);
        return demo;
    }

    @Override
    public void testAspect(){
        System.out.println("testAspect()");

    }


    @Override
    public void showPage(){
        PageHelper.startPage(1,10);
        List<DemoEntity> demos = demoMapper.getDemos();
        PageInfo page = new PageInfo(demos);
        /**
         *
         assertEquals(1, page.getPageNum());
         assertEquals(10, page.getPageSize());
         assertEquals(1, page.getStartRow());
         assertEquals(10, page.getEndRow());
         assertEquals(183, page.getTotal());
         assertEquals(19, page.getPages());
         assertEquals(1, page.getFirstPage());
         assertEquals(8, page.getLastPage());
         assertEquals(true, page.isFirstPage());
         assertEquals(false, page.isLastPage());
         assertEquals(false, page.isHasPreviousPage());
         assertEquals(true, page.isHasNextPage());
         */
    }



}