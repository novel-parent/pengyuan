package com.pengyuan.backstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.pengyuan.backstage.bean.Procedures;

public interface ProcedureMapper {

	/**
	 *   插入工序表的时候  并且 返回自增的id
	 * @param procedure
	 * @return
	 */
	int saveProcedure(Procedures procedure);
	
	@Select("select * from procedures where pName = #{pName}")
	Procedures getProcedureModel(String baseModel);

	List<Procedures> searchProcedureByPage(@Param("procedures")Procedures procedures,@Param("pageBeginIndex") int pageBeginIndex);

	int searchAllColumn(@Param("procedures")Procedures p);

	@Select("select distinct times from procedures")
	List<Procedures> serachAllDate();

	@Select("select * from procedures where pid = #{pid}")
	Procedures searchProcedureById(@Param("pid") Long pid);

}
