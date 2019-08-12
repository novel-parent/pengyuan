package com.pengyuan.backstage.service;

import com.pengyuan.backstage.bean.ProcedureHotKey;
import com.pengyuan.backstage.bean.UserHotKey;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/10 - 12:55
 */
public interface HotKeyService {

    List<UserHotKey> getUserByKeyAndFid(Long fid , String key);

    /**
     *     得到用户名字  通过 工厂
     * @param fid
     * @return
     */
    List<UserHotKey> getUser(Long fid);

    /**
     *     袋子类型
     * @return
     */
    List<ProcedureHotKey> getProcedure(String key);

    /**
     *        得到key   用户 有关的  查询
     * @param key
     * @return
     */
    List<String> userNameList(String key);

    /**
     *       得到所有的  corporateName  的名字
     * @return
     */
    List<String> corporateNameList();

    /**
     *       得到所有的   goodsName
     * @param corporateName
     * @return
     */
    List<String> goodsNameList(String corporateName);

    /**
     *           从redis  拿到匹配的  key
     * @param key
     * @return
     */
    List<String> getOrderSearchKeys(String key);

}
