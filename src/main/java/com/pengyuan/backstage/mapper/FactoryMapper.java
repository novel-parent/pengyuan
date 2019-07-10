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
	
	Factory selectFactoryByFid(@Param("fid") long i);

	@Select("select * from factory ")
	List<Factory> getAllFactory();
}
