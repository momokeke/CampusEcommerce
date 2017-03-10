package com.seu.dm.mappers;

import com.seu.dm.entities.Campus;

import java.util.List;

public interface CampusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);

    List<Campus> selectAll();
}