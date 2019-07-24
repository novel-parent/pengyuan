package com.pengyuan.backstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pengyuan.backstage.bean.Procedures;

public interface ProcedureMapper {

	@Insert("insert into procedures(name,main,remarks,path,times,flag) values(#{name},#{main},#{remarks},#{path},#{times},#{flag})")
	int saveProcedure(Procedures procedure);
	
	@Select("select * from procedures where name = #{name}")
	Procedures getProcedureModel(String baseModel);

	List<Procedures> searchProcedureByPage(@Param("procedures")Procedures procedures,@Param("pageBeginIndex") int pageBeginIndex);

	int searchAllColumn(@Param("procedures")Procedures p);

	@Select("select distinct times from procedures")
	List<Procedures> serachAllDate();

}
