package com.seu.dm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Greeting on 2017/3/12.
 */
@Controller
public class PictureController {

    @RequestMapping("/picture/{id}")
    public void picture(@PathVariable Integer id, HttpServletResponse response){

    }


}
