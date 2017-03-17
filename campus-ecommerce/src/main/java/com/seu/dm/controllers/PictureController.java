package com.seu.dm.controllers;

import com.seu.dm.entities.Picture;
import com.seu.dm.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Greeting on 2017/3/12.
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping("/picture/{id}")
    public void picture(@PathVariable Integer id, HttpServletResponse response) throws IOException{
        Picture picture = pictureService.getPictureById(id);
        response.setHeader("Cache-Control","max-age=86400");
        response.setContentType("image/jpeg");
        OutputStream stream = response.getOutputStream();
        stream.write(picture.getBinaryFile());
        stream.flush();
        stream.close();
    }


}
