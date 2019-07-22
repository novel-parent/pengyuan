package com.pengyuan.backstage.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pengyuan.backstage.bean.Procedures;

public interface ProcedureMapper {

	@Insert("insert into procedures(name,main,remarks,path) values(#{name},#{main},#{remarks},#{path})")
	int saveProcedure(Procedures procedure);
	
	@Select("select * from procedures where name = #{name}")
	Procedures getProcedureModel(String baseModel);

}
