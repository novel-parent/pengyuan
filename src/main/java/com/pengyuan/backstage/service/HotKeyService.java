package com.pengyuan.backstage.service;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/10 - 12:55
 */
public interface HotKeyService {

    /**
     *       得到所有的  corporateName  的名字
     * @return
     */
    List<String> corporateNameList();

    /**
     *    得到所有的   goodsName
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
