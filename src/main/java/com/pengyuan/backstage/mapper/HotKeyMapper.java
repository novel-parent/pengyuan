package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.ProcedureHotKey;
import com.pengyuan.backstage.bean.UserHotKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/10 - 12:59
 */
public interface HotKeyMapper {

    /**
     *      蘑菇查询工序名
     * @param key
     * @return
     */
    List<ProcedureHotKey> selProcedureByKey(@Param("key") String key);

    /**
     *        查询 用户
     * @param fid
     * @param key
     * @return
     */
    List<UserHotKey> selUserByKey(@Param("fid") Long fid , @Param("key") String key);

    /**
     *      根据工程来 查询user 名字
     * @param fid
     * @return
     */
    List<UserHotKey> selUser(@Param("fid") Long fid);

    /**
     *      查询所有工序名
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
