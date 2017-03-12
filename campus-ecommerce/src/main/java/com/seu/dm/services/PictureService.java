package com.seu.dm.services;

import com.seu.dm.entities.Picture;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface PictureService {
    Picture getPictureById(Integer id);
    int updatePicture(Picture picture);
    int deletePictureById(Integer id);

}
