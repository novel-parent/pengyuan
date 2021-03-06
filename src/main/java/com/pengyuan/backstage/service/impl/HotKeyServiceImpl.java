package com.pengyuan.backstage.service.impl;

import com.pengyuan.backstage.bean.ProcedureHotKey;
import com.pengyuan.backstage.bean.Procedures;
import com.pengyuan.backstage.bean.UserHotKey;
import com.pengyuan.backstage.mapper.HotKeyMapper;
import com.pengyuan.backstage.service.HotKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author LX
 * @date 2019/7/10 - 12:56
 */
@Service
public class HotKeyServiceImpl implements HotKeyService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private HotKeyMapper hotKeyMapper;

    @Override
    public List<UserHotKey> getUserByKeyAndFid(Long fid, String key) {

        List<UserHotKey> userHotKeys = hotKeyMapper.selUserByKey(fid, key);

        return userHotKeys;
    }

    @Override
    public List<UserHotKey> getUser(Long fid) {

        List<UserHotKey> userHotKeys = hotKeyMapper.selUser(fid);
        return userHotKeys;
    }

    @Override
    public List<ProcedureHotKey> getProcedure(String key) {

        List<ProcedureHotKey> list = hotKeyMapper.selProcedureByKey(key);

        return list;
    }

    @Override
    public List<String> userNameList(String key) {

        List<UserHotKey> userHotKeys = hotKeyMapper.selUserByKey(null, key);

        List<String> list = new ArrayList<>();

        for (UserHotKey hotKey : userHotKeys) {
            list.add(hotKey.getUserName());
        }

        return list;
    }

    @Override
    public List<String> corporateNameList() {

        List<String> stringList = hotKeyMapper.selAllCorporateName();

        return stringList;
    }


    @Override
    public List<String> goodsNameList(String corporateName) {

        List<String> stringList = hotKeyMapper.selGoodsName(corporateName);

        return stringList;
    }

    @Override
    public List<String> getOrderSearchKeys(String key) {

        List<String> keysList = new ArrayList<>();
        Set keys = redisTemplate.keys("goodsName:" + "*" + key + "*");

        if(keys != null && keys.size() > 0){

            keys.forEach( ele->

                keysList.add(ele.toString().replace("goodsName:", ""))
            );
        }

        Set keys1 = redisTemplate.keys("corporateName:" + "*" + key + "*");

        if( keys1 !=null && keys1.size() > 0){

            keys1.forEach( ele->
                keysList.add(ele.toString().replace("corporateName:", ""))
            );
        }

        if(keysList.size()>0){
            return keysList;
        }
        return null;
    }

}
