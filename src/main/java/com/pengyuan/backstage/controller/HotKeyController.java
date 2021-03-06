package com.pengyuan.backstage.controller;

import com.pengyuan.backstage.bean.ProcedureHotKey;
import com.pengyuan.backstage.bean.UserHotKey;
import com.pengyuan.backstage.service.HotKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LX
 * @date 2019/7/10 - 12:52
 */
@Controller
public class HotKeyController {

    @Autowired
    private HotKeyService hotKeyService;

    @ResponseBody
    @RequestMapping("/getUserByKey")
    List<UserHotKey> getUserByKey(@RequestParam(required = false) Long fid,@RequestParam(required = false) String key){

        List<UserHotKey> userHotKeys = hotKeyService.getUserByKeyAndFid(fid, key);

        return userHotKeys;
    }


    @ResponseBody
    @RequestMapping("/getUser.b")
    List<UserHotKey> getUserKey(@RequestParam(required = false) Long fid){

        return hotKeyService.getUser(fid);
    }


    @ResponseBody
    @RequestMapping("/getProcedures.b")
    public List<ProcedureHotKey> getProcedureKey(@RequestParam(required = false) String key){

        List<ProcedureHotKey> procedure = hotKeyService.getProcedure(key);
        return procedure;
    }

    @ResponseBody
    @RequestMapping("/corporateName.b")
    public List<String> corporateNameKey(){

        List<String> list = null ;

        try {
            list = hotKeyService.corporateNameList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @ResponseBody
    @RequestMapping("/goodsName.b")
    public List<String> goodsName(@RequestParam(required = false) String corporateName){

        List<String> list = null ;

        try {
            list = hotKeyService.goodsNameList(corporateName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list ;
    }

    @ResponseBody
    @RequestMapping("/orderSearchKeys.b")
    public List<String> getOrderSearchKeys(@RequestParam(required = false) String key){

        List<String> searchKeys = null ;

        try {
            searchKeys = hotKeyService.getOrderSearchKeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchKeys;
    }

    @ResponseBody
    @RequestMapping("/userKey.b")
    public List<String> getUserNameKeys(@RequestParam(required = false) String key){

        List<String> list = hotKeyService.userNameList(key);

        return list;

    }
}
