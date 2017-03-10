package com.seu.dm.controllers;
import com.seu.dm.entities.Community;
import com.seu.dm.services.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * Created by 张老师 on 2017/3/8.
 */
@Controller
public class CommunityController {
    private CommunityService communityService;

    @RequestMapping(value = "/testCommunity")
    public String getAllCommunities(Model model){
        List<Community> communities = communityService.getAllCommunities();
        System.out.println(communities.size());
        model.addAttribute("communities",communities);
        System.out.println(communities.size());
        for (Community community : communities) {
            System.out.println("community: " + community.getName());
        }
        return "/buyer/shopping_cart";
    }

}
