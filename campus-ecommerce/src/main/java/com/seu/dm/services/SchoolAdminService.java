package com.seu.dm.services;

import com.seu.dm.entities.SchoolAdmin;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface SchoolAdminService {
    int addAdim(SchoolAdmin schoolAdmin);

    int deleteAdim(Integer id);

    int updateAdim(SchoolAdmin schoolAdmin);

    SchoolAdmin findAdim(Integer id);
}
