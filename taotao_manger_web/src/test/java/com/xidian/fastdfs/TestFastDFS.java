package com.xidian.fastdfs;

import com.xidian.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;

public class TestFastDFS {
    @Test
    public void uploadFile() throws Exception{
        //添加jar包
        //创建一个配置文件。配置tracker服务器的地址
        //加载配置文件
        ClientGlobal.init("/Users/zhangjiafeng/Desktop/Java/IntelJ Idea/taotao_parent/taotao_manger_web/src/main/resources/resource/client.conf");
        //创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //使用TrackerClient对象获得trackerServer对象
        TrackerServer trackerServer=trackerClient.getConnection();
        //创建一个storageServer的引用
        StorageServer storageServer=null;
        //创建一个StorgeClient对象， trackerServer，storageServer两个参数
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
        //使用storgeClient上传文件
        String[] strings=storageClient.upload_file("/Users/zhangjiafeng/Desktop/截图/123.png","png",null);
        for(String string:strings){
            System.out.println(string);
        }
    }
    @Test
    public void testFastDfsClient() throws Exception{
        FastDFSClient fastDFSClient=new FastDFSClient("/Users/zhangjiafeng/Desktop/Java/IntelJ Idea/taotao_parent/taotao_manger_web/src/main/resources/resource/client.conf");
        String strings=fastDFSClient.uploadFile("/Users/zhangjiafeng/Desktop/截图/456.png","png",null);
        System.out.println(strings);
    }
}
