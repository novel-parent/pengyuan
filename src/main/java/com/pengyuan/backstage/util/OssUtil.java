package com.pengyuan.backstage.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;

@Component
public class OssUtil {
	
	@Autowired
	private AliOssBaseUtil aliyunOSSUtill;
	
	
	public String upload( MultipartFile file,int type)
			throws OSSException, ClientException, IOException {
		
		String filename = file.getOriginalFilename();
		System.out.println(filename);
		try {
			if (file != null) {
				if (!"".equals(filename.trim())) {
					File newFile = new File(filename);
					FileOutputStream os = new FileOutputStream(newFile);
					os.write(file.getBytes());
					os.close();
					file.transferTo(newFile);
					String uploadUrl = aliyunOSSUtill.upLoad(newFile, 1);
					newFile.delete();
					return uploadUrl;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("上传出现异常!");
		}
		return "upload have problem!";
	}
}
