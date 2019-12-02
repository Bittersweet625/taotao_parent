package com.xidian.controller;

import com.xidian.common.utils.JsonUtils;
import com.xidian.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
@Controller
public class PictureController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;


    @RequestMapping("/pic/upload")
    @ResponseBody
    public String picUpload(MultipartFile uploadFile){
        try {
            //获取上传的文件
            //获取扩展名
            String oriinalFilename=uploadFile.getOriginalFilename();//原始文件名
            String extName=oriinalFilename.substring(oriinalFilename.lastIndexOf(".")+1);//文件后缀名
            //上传到服务器
            FastDFSClient fastDFSClient=new FastDFSClient("/Users/zhangjiafeng/Desktop/Java/IntelJ Idea/taotao_parent/taotao_manger_web/src/main/resources/resource/client.conf");
            String url=fastDFSClient.uploadFile(uploadFile.getBytes(),extName);
            url=IMAGE_SERVER_URL+url;
            Map result=new HashMap();
            result.put("error",0);
            result.put("url",url);
            return JsonUtils.objectToJson(result);
        }catch (Exception e){
            e.printStackTrace();
            Map result=new HashMap();
            result.put("error",1);
            result.put("message","图片上传失败");
            return JsonUtils.objectToJson(result);
        }

    }

}
