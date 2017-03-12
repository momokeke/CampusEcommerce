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
    public static byte[] upload(HttpServletRequest request,String fileName) throws IOException{
        MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
        MultipartFile file = multiRequest.getFile(fileName);
        if(file == null){
            return null;
        }
        return file.getBytes();
    }

    public static byte[] uploadPicture(HttpServletRequest request,String fileName) throws IOException{
        return upload(request,fileName);
    }

}
