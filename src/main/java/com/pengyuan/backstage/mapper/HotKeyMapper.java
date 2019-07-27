package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.ProcedureHotKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/10 - 12:59
 */
public interface HotKeyMapper {

    /**
     *      查询所有工序名
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT pid ,pName FROM procedures GROUP BY pName ")
    List<ProcedureHotKey> selProcedure();

    /**
     *         搜索 所有的 corporateName 的名字 作为关键词  提示
     * @return
     */
    @Select("SELECT DISTINCT(corporateName) FROM orders ")

    List<String> selAllCorporateName();

    /**
     *           搜索 所有的 goodsName 的名字 作为关键词  提示
     * @param corporateName
     * @return
     */
    List<String> selGoodsName(@Param("corporateName") String corporateName);
}
