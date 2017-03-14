package com.seu.dm.mappers;

import com.seu.dm.entities.SchoolAdmin;

import java.util.List;

public interface SchoolAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SchoolAdmin record);

    int insertSelective(SchoolAdmin record);

    SchoolAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SchoolAdmin record);

    int updateByPrimaryKey(SchoolAdmin record);

    List<SchoolAdmin> findAllBySchoolId(Integer campusId);

    SchoolAdmin findAdmin(SchoolAdmin schoolAdmin);
}