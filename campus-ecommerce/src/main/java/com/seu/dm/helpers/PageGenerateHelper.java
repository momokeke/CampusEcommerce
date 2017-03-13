package com.seu.dm.helpers;

import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Greeting on 2017/3/13.
 */
public class PageGenerateHelper {
    public static void generatePage(HttpServletRequest request, Model model, PageInfo pageInfo){
        String parameters = "?";
        Map<String, String[]> map =  request.getParameterMap();
        Set<String> keys = map.keySet();
        for(String key : keys){
            if(key.equals("pageNum")){
                continue;
            }
            String[] value = map.get(key);
            parameters += key + "=" + value[0] + '&';
        }
        String baseUrl = request.getRequestURL().toString() + parameters;
        System.out.println(baseUrl);
        List<String> pageList = new LinkedList<>();
        for(int i = pageInfo.getNavigateFirstPage(); i <= pageInfo.getNavigateLastPage(); ++i){
            pageList.add(parameters+"pageNum="+i);
        }
        model.addAttribute("pageBaseUrl",parameters+"pageNum=");
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pageList",pageList);
    }
}
