package com.pengyuan.backstage.util;



import java.io.File;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;


@Component
public class AliOssBaseUtil {
  
    private  final static org.slf4j.Logger logger = LoggerFactory.getLogger(AliOssBaseUtil.class);

    //** 上传文件*//*
    public   String upLoad(File file,int ty){
        logger.info("------OSS文件上传开始--------"+file.getName());
        String endpoint="oss-cn-beijing.aliyuncs.com";
        System.out.println("获取到的Point为:"+endpoint);
        String accessKeyId="LTAIITWT4M4azCLU";
        String accessKeySecret="9d7R60FOUvIuKAOKZDMS7nAwA7777X";
        String bucketName="doki-l";
        String fileHost="UploadFile";
        String type="";
        
        if(ty==1) {
        	type="header";
        }else if(ty==10){
        	type="shopimg";
        }else {
        	type="img";
        }

        OSSClient client=new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 判断容器是否存在,不存在就创建
            if (!client.doesBucketExist(bucketName)) {
                client.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = fileHost + "/" + (type + "/"  + file.getName());
            // 上传文件
            PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            // 设置权限(公开读)
            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            if (result != null) {
                logger.info("------OSS文件上传成功------" + fileUrl);
            }
        }catch (OSSException oe){
             logger.error(oe.getMessage());
        }catch (ClientException ce){
            logger.error(ce.getErrorMessage());
        }finally{
            if(client!=null){
                client.shutdown();
            }
        }
        return "http://"+bucketName+"."+endpoint+"/"+fileHost + "/" + (type + "/"  + file.getName());
    }
}


