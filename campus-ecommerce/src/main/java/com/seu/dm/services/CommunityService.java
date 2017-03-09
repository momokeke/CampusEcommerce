package com.seu.dm.services;

import com.seu.dm.entities.Community;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface CommunityService {
    int addCommunity(Community community);

    int deleteCommunity(Integer id);

    int updateCommunity(Community community);

    Community findCommunity(Integer id);
}