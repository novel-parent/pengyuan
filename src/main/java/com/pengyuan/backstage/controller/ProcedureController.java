package com.pengyuan.backstage.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@ResponseBody
	@RequestMapping("SaveProcedureString")
	public Object SaveProcedure(Procedures procedure,@RequestParam("file")MultipartFile file) {
		JsonModel jm=new JsonModel();
		
		
		int i = ps.saveFromWork(procedure,file);
		
		if(i>0) {
			jm.setCode(1);
			jm.setMsg("模板保存成功");
		}else {
			jm.setCode(-1);
			jm.setMsg("系统繁忙！");
		}
		
		
		return jm;
	}
	
	@RequestMapping("getProcedureInfo")
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
	
}
