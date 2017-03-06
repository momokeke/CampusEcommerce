package com.seu.dm.services;

import com.seu.dm.entities.Adim;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface AdimService {
    int addAdim(Adim adim);

    int deleteAdim(Integer id);

    int updateAdim(Adim adim);

    Adim findAdim(Integer id);
}
