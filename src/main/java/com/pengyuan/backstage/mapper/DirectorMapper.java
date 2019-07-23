package com.pengyuan.backstage.mapper;

import com.pengyuan.backstage.bean.Director;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author LX
 * @date 2019/7/7 - 15:28
 */
public interface DirectorMapper {

    /**
     *       查询用户是否为  主管
     * @param uid
     * @return
     */
    @Select("SELECT * FROM director WHERE uid = #{uid}")
    Director selByUid(@Param("uid") Long uid);
}
