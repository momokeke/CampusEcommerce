package com.seu.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Greeting on 2017/3/14.
 */
@Controller
@RequestMapping("/campus")
public class CampusController {
    @RequestMapping("/change/{id}")
    public String change(@PathVariable Integer id, HttpSession httpSession){
        httpSession.setAttribute("campusId",id);
        return "redirect:/index.html";
    }
}
