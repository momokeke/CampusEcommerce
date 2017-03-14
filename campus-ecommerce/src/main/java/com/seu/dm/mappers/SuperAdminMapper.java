package com.seu.dm.mappers;

import com.seu.dm.entities.SuperAdmin;

public interface SuperAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SuperAdmin record);

    int insertSelective(SuperAdmin record);

    SuperAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SuperAdmin record);

    int updateByPrimaryKey(SuperAdmin record);

    Integer getCount(SuperAdmin superAdmin);
}