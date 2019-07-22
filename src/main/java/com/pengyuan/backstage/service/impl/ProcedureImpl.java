package com.pengyuan.backstage.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.pengyuan.backstage.bean.Procedures;
import com.pengyuan.backstage.mapper.ProcedureMapper;
import com.pengyuan.backstage.service.ProcedureService;
import com.pengyuan.backstage.util.OssUtil;

@Service
public class ProcedureImpl implements ProcedureService {
	
	@Autowired
	private ProcedureMapper pm;
	
	@Autowired
	private OssUtil oss;


	@Override
	public int saveFromWork(Procedures procedure, MultipartFile file) {
		
		try {
			//存储文件
			String path = oss.upload(file, 1);
			
			procedure.setPath(path);
			
			procedure.setMain(procedure.getMain().trim());
			
		    return	pm.saveProcedure(procedure);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
			return -1;
		}
		
	}


	@Override
	public Procedures getProcedureModel(String baseModel) {
		
		return pm.getProcedureModel(baseModel);
	}

	
}
