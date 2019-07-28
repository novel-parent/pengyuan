package com.pengyuan.backstage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pengyuan.backstage.bean.JsonModel;
import com.pengyuan.backstage.bean.ProcedureModel;
import com.pengyuan.backstage.bean.Procedures;
import com.pengyuan.backstage.service.ProcedureService;

@Controller
public class ProcedureController {

	@Autowired
	private ProcedureService ps;
	
	/**
	  * 将模板信息保存至数据库
	 * @param procedure 模板信息
	 * @param file 文件
	 * @return
	 */
	@ResponseBody
	@RequestMapping("SaveProcedureString.b")
	public Object SaveProcedure(Procedures procedure,MultipartFile file) {
		JsonModel jm=new JsonModel();
		
		
		int i = ps.saveFromWork(procedure,file);
		
		if(i>0) {
			jm.setCode(1);
			jm.setMsg("模板保存成功");
		}else {
			jm.setCode(-1);
			jm.setMsg("请求失败");
		}
		
		
		return jm;
	}
	
	/**
	  * 从数据库中读取名称为baseModel的基础模板信息
	 * @param baseModel ：前台ajax传入的模板名
	 * @return
	 */
	@RequestMapping("getProcedureInfo.b")
	@ResponseBody
	public Object getProcedureInfo(String baseModel) {
		JsonModel jm=new JsonModel();
		
		Procedures p=ps.getProcedureModel(baseModel);
		
		if(p != null) {
			jm.setCode(1);
			jm.setObj(p);
		}else {
			jm.setCode(-1);
			jm.setMsg("没有查询到相应模板信息");
		}
		return jm;
	}
	/**
	  * 获取模板信息列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getProcedureList.b")
	public Object getProcedureList(Procedures pd,int currentPage) {
		
		
		ProcedureModel pp = ps.searchProcedureByPage(pd,currentPage);
		
		if(pp.getObj().isEmpty()) {
			pp.setCode(-1);
			pp.setMsg("没有查找到与条件匹配的数据");
		}else {
			pp.setCode(1);
		}
		
		return pp;
	}
	
	/**
	  *  获取所有日期信息
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping("serachAllDate.b")
	public Object serachAllDate() {
		JsonModel jm = new JsonModel();
		try {
		
			List<Procedures> rowpdList =  ps.searchAllDate();
			
			List<Procedures> pdList = ps.HandleYear(rowpdList);
		
			jm.setObj(pdList);
			jm.setCode(1);
		}catch (Exception e) {
			e.printStackTrace();
			jm.setCode(-1);
		}
		
		return jm;
	}*/
	
	@ResponseBody
	@RequestMapping("checkProcedureName.b")
	public Object checkProcedureName(String name) {
		JsonModel jm=new JsonModel();
		
		Procedures pro = ps.getProcedureModel(name);
		
		if(pro == null) {
			jm.setCode(1);
		}else {
			jm.setCode(-1);
		}
		return jm;
	}
	
	@ResponseBody
	@RequestMapping("addDataForProcedure.b")
	public Object addDataForProcedure(Long pid) {
		JsonModel jm = new JsonModel();
		
		try {
			Procedures procedure = ps.searchProcedureById(pid);
			jm.setObj(procedure);
			jm.setCode(1);
		}catch(Exception e) {
			jm.setCode(-1);
			jm.setMsg("请求失败");
			e.printStackTrace();
		}
		return jm;
	}
	
	@ResponseBody
	@RequestMapping("SaveProcedureData.b")
	public Object SaveProcedureData(Procedures p) {
		JsonModel jm=new JsonModel();
		
		System.out.println(p);
		
		return jm;
	}
	
	@ResponseBody
	@RequestMapping("deleteProcedureByPid.b/{currentPage}")
	public Object deleteProcedureByPid(Long pid,@PathVariable("currentPage")int currentPage) {
		JsonModel jm = new JsonModel();
		
		int i = ps.deleteProcedureByPid(pid);
		
		if(i>0) {
			jm.setCode(currentPage);
			jm.setMsg("删除成功");
		}else {
			jm.setCode(-1);
			jm.setMsg("请求失败");
		}
		
		return jm;
	}
	
}
