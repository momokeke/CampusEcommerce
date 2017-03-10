package com.seu.dm.controllers;

import com.seu.dm.entities.Community;
import com.seu.dm.services.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */
@Controller
public class CommunityController {
    private CommunityService communityService;

    @RequestMapping(value = "/testCommunity")
    public String getAllCommunities(Model model){
        List<Community> communities = communityService.findAllCommunities();
        model.addAttribute("communities",communities);
        return "/seller/new_products";
    }
}
