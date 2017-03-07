package com.seu.dm.services;

import com.seu.dm.entities.Picture;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface PictureService {
    int addPicture(Picture picture);

    int deletePicture(Integer id);

    int updatePicture(Picture picture);

    Picture findPicture(Integer id);
}
