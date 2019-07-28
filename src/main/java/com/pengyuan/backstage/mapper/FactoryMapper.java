package com.pengyuan.backstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pengyuan.backstage.bean.Factory;

/**
 * @author LX
 * @date 2019/7/7 - 15:24
 */
public interface FactoryMapper {
	
	/**
	 * 	通过fid查找factory对象
	 * @param fid
	 * @return
	 */
	Factory selectFactoryByFid(@Param("fid") long fid);
	
	/**
	 * 查找所有的factory对象
	 * @return
	 */
	@Select("select * from factory ")
	List<Factory> getAllFactory();
}
