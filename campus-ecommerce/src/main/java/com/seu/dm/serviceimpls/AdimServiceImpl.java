package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Adim;
import com.seu.dm.mappers.AdimMapper;
import com.seu.dm.services.AdimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class AdimServiceImpl implements AdimService{
    @Autowired
    private AdimMapper adimMapper;

    @Override
    public int addAdim(Adim adim) {
        return adimMapper.insert(adim);
    }

    @Override
    public int deleteAdim(Integer id) {
        return adimMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAdim(Adim adim) {
        return adimMapper.updateByPrimaryKey(adim);
    }

    @Override
    public Adim findAdim(Integer id) {
        return adimMapper.selectByPrimaryKey(id);
    }
}
