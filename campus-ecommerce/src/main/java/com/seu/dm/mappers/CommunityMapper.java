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

<<<<<<< HEAD
    List<Community> getAllCommunities();

    Community findCommunityByName(String name);
=======
    List<Community> findAllCommunities();
>>>>>>> db67bb3c9fa65f979a692289942183ea742e95fc
}