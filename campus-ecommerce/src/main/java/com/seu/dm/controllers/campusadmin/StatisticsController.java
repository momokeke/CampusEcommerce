package com.seu.dm.controllers.campusadmin;

import com.seu.dm.annotations.permissions.CampusAdminPermission;
import com.seu.dm.annotations.permissions.SuperAdminPermission;
import com.seu.dm.entities.Order;
import com.seu.dm.services.OrderService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Greeting on 2017/3/9.
 * 校区管理员看统计信息
 */
@Controller("/campusadmin/statistics")
@RequestMapping(value="/campusadmin/statistics")
public class StatisticsController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/")
    @CampusAdminPermission
    public String index(Model model){
        List<Order> transactions = orderService.selectWeekTransactions();
        Map<String,String> calendarMap = new HashMap<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < transactions.size(); ++i){
            String theKey = dateFormat.format(transactions.get(i).getCreateTime());
            calendarMap.put(theKey,transactions.get(i).getTotalPrice().toString());
        }
        System.out.println(calendarMap);
        List<Pair<String,String>> data = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for(int i = 0; i < 7; ++i) {
            calendar.add(Calendar.DATE, -1);
            Date targetTime = calendar.getTime();

            String timeKey = dateFormat.format(targetTime);
            if(calendarMap.containsKey(timeKey)) {
                data.add(new Pair<>(timeKey,calendarMap.get(timeKey)));
            }else{
                data.add(new Pair<>(timeKey,"0"));
            }
        }
        Collections.reverse(data);
        model.addAttribute("javascriptData",makeJavascriptData(data));
        model.addAttribute("javascriptTicks",makeJavascriptTicks(data));
        return "admin/campusadmin/statistics/manage";
    }

    private String makeJavascriptData(List<Pair<String,String>> data){
        String res = "[";
        for(int i = 0; i < data.size(); ++i){
            res += "[" + String.valueOf(i) + "," + data.get(i).getValue() + "],";
        }
        res = res.substring(0,res.length()-1);
        res += "]";
        return res;
    }

    private String makeJavascriptTicks(List<Pair<String,String>> data){
        String res = "[";
        for(int i = 0; i < data.size(); ++i){
            res += "[" + String.valueOf(i) + "," + '"' + data.get(i).getKey() + '"' + "],";
        }
        res = res.substring(0,res.length()-1);
        res += "]";
        return res;
    }
}
