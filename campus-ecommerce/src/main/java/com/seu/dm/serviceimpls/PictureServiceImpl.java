package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Picture;
import com.seu.dm.mappers.PictureMapper;
import com.seu.dm.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class PictureServiceImpl implements PictureService{

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public Picture getPictureById(Integer id) {
        return pictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePicture(Picture picture) {
        return pictureMapper.updateByPrimaryKeySelective(picture);
    }

    @Override
    public int deletePictureById(Integer id) {
        return pictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int addPicture(Picture picture) {
        return pictureMapper.insert(picture);
    }
}
