package com.pengyuan.backstage.service;

import org.springframework.web.multipart.MultipartFile;

import com.pengyuan.backstage.bean.Procedures;

public interface ProcedureService {
	/**
	 * 
	 * @param procedure  :工序
	 * 		  file	:图片
	 * @return int 
	 * 
	  *  将工序存储进数据库
	 */
	int saveFromWork(Procedures procedure, MultipartFile file);

	Procedures getProcedureModel(String baseModel);

}
