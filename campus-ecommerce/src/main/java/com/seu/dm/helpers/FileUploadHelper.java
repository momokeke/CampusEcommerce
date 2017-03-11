package com.seu.dm.helpers;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by Greeting on 2017/3/11.
 */
public class FileUploadHelper {
    /**
     * 上传文件
     * 传入 request 和文件名 目标保存地址
     * @return
     */
    public static String upload(HttpServletRequest request,String fileName,String destPathPre) throws IOException{
        MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
        MultipartFile file = multiRequest.getFile(fileName);
        if(file == null){
            return "";
        }
        String path = destPathPre + file.getOriginalFilename();
        file.transferTo(new File(path));
        return path;
    }


    public static String uploadPicture(HttpServletRequest request,String fileName,String destPathPre) throws IOException{
        return upload(request,fileName,destPathPre);
    }



}
