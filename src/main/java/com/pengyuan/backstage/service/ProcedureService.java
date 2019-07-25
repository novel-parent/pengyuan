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
	
	/**
	  * 分页查询数据
	 * @param pd	前台传过来的要查询的工序信息
	 * @param currentPage :当前页
	 * @return
	 */

	ProcedureModel searchProcedureByPage(Procedures pd, int currentPage);
	
	/**
	  * 获取所有的日期信息
	 * @return
	 */
	List<Procedures> searchAllDate();
	/**
	  * 通过fid查找模板信息   
	 * @param fid
	 * @return
	 */
	Procedures searchProcedureById(Long fid);
	/**
	  *  过滤重复的年份
	 * @param rowpdList
	 * @return
	 */
	List<Procedures> HandleYear(List<Procedures> rowpdList);

}
