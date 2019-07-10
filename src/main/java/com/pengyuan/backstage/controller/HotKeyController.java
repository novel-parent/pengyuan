package com.pengyuan.backstage.controller;

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
    @RequestMapping("/corporateName")
    public List<String> corporateNameKey(){

        List<String> list = hotKeyService.corporateNameList();

        return list;
    }

    @ResponseBody
    @RequestMapping("/goodsName")
    public List<String> goodsName(@RequestParam(required = false) String corporateName){

        return hotKeyService.goodsNameList(corporateName);
    }

    @ResponseBody
    @RequestMapping("/orderSearchKeys")
    public List<String> getOrderSearchKeys(@RequestParam(required = false) String key){

        List<String> searchKeys = hotKeyService.getOrderSearchKeys(key);

        return searchKeys;
    }
}
