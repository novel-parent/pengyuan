package com.pengyuan.backstage.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.pengyuan.backstage.bean.ProcedureModel;
import com.pengyuan.backstage.bean.Procedures;
import com.pengyuan.backstage.mapper.ProcedureMapper;
import com.pengyuan.backstage.service.ProcedureService;
import com.pengyuan.backstage.util.DateUtil;
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
			
			if(file != null) {
			//存储文件
			String path = oss.upload(file, 1);
				procedure.setPath(path);
			}else {
				procedure.setPath("");
			}
			
			procedure.setMain(procedure.getMain().trim());
			
			//设置时间精确到天
			procedure.setTimes(Long.valueOf(DateUtil.getMonthAndDay()));
			
			procedure.setFlag(1);
			
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


	@Override
	public ProcedureModel searchProcedureByPage(Procedures pd, int currentPage) {
		
		Procedures p =new Procedures();
		
		if(currentPage <= 0) {
			currentPage = 1;
		}
		
		int pageBeginIndex = (currentPage-1)*8;
		
		if(pd.getName() != null ) {
			p.setName(pd.getName());
		}
		
		if(pd.getRemarks() != null ) {
			p.setRemarks(pd.getRemarks());
		}
		
		if(pd.getTimes() != null) {
			p.setTimes(pd.getTimes());
		}
		
		//默认查找flag为1的
		p.setFlag(1);
		
		ProcedureModel ppb=new ProcedureModel();
		
		System.out.println("1: "+pd);
		System.out.println("2: "+p);
		
		List<Procedures>  ProcedureList = pm.searchProcedureByPage(p,pageBeginIndex);
		
		int allColumn =  pm.searchAllColumn(p);
		
		int totalPage = 0;
		
		if( allColumn%8 == 0) {
			totalPage = allColumn/8;
		}else if(allColumn%8 != 0) {
			totalPage = (allColumn/8)+1;
		}
		
		ppb.setObj(ProcedureList);
		ppb.setCurrentPage(currentPage);
		ppb.setPageSize(8);
		ppb.setTotalPage(totalPage);
		
		
		return ppb;
	}


	@Override
	public List<Procedures> searchAllDate() {
		
		return pm.serachAllDate();
	}



	
}
