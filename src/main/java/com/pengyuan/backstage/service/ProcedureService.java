package com.pengyuan.backstage.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pengyuan.backstage.bean.ProcedureModel;
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
	/**
	 * 从数据库中获取名字为base的模板信息
	 * @param baseModel
	 * @return
	 */

	Procedures getProcedureModel(String baseModel);

	ProcedureModel searchProcedureByPage(Procedures pd, int currentPage);

}
