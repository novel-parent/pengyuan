package com.pengyuan.backstage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
	/**
	 * 	通过 pName查询工序
	 */
	
	@Select("select * from procedures where pName = #{pName}")
	Procedures getProcedureModel(String baseModel);
	/**
	 * 	工序的带条件分页查询
	 * @param procedures	: 工序
	 * @param pageBeginIndex	: 开始记录条数
	 * @return
	 */
	List<Procedures> searchProcedureByPage(@Param("procedures")Procedures procedures,@Param("pageBeginIndex") int pageBeginIndex);

	/**
	 * 	带条件查询记录的条数
	 * @param p
	 * @return
	 */
	int searchAllColumn(@Param("procedures")Procedures p);
	
	/**
	 * 	查询所有时间（去重）
	 * @return
	 */

	@Select("select distinct times from procedures")
	List<Procedures> serachAllDate();
	/**
	 * 通过pid查找工序
	 * @param pid
	 * @return
	 */

	@Select("select * from procedures where pid = #{pid}")
	Procedures searchProcedureById(@Param("pid") Long pid);
	/**
	 * 	删除模板信息通过pid
	 * @param pid
	 * @return
	 */
	@Delete("delete from procedures where pid = #{pid}")
	int deleteProcedureByPid(@Param("pid")Long pid);

}
