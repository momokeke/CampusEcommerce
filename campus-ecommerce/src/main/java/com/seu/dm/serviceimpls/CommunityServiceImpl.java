package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Community;
import com.seu.dm.mappers.CommunityMapper;
import com.seu.dm.services.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public int addCommunity(Community community) {
        return communityMapper.insert(community);
    }

    @Override
    public int deleteCommunity(Integer id) {
        return communityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCommunity(Community community) {
        return communityMapper.updateByPrimaryKey(community);
    }

    @Override
    public Community findCommunity(Integer id) {
        return communityMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Community> getAllCommunities() {
        List<Community> communities = communityMapper.getAllCommunities();
        return communities;
    }

    @Override
    public Community findCommunityByName(String name) {
        return communityMapper.findCommunityByName(name);
    }
}
