package com.seu.dm.mappers;

import com.seu.dm.entities.Community;

import java.util.List;

public interface CommunityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Community record);

    int insertSelective(Community record);

    Community selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Community record);

    int updateByPrimaryKey(Community record);

    List<Community> getAllCommunities();

    Community findCommunityByName(String name);

    List<Community> findAllCommunities();
}