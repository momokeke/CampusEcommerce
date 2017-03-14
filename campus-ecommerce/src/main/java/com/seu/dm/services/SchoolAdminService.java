package com.seu.dm.services;

import com.seu.dm.entities.SchoolAdmin;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface SchoolAdminService {
    int addAdim(SchoolAdmin schoolAdmin);

    int deleteSchoolAdmin(Integer id);

    int updateAdim(SchoolAdmin schoolAdmin);

    SchoolAdmin findAdmin(Integer id);

    int addSchoolAdminByNumAndName(Integer id,Integer studentNumber,String name);

    List<SchoolAdmin> findAllSchoolAdminsBySchoolId(Integer id);

    SchoolAdmin findAdmin(SchoolAdmin schoolAdmin);
}
