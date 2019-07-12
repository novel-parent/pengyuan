package com.pengyuan.backstage;

import com.pengyuan.backstage.util.JedisUtil;
import org.junit.Test;

/**
 * @author LX
 * @date 2019/7/12 - 10:05
 */
public class JedisTest {

    @Test
    public void test1(){

        JedisUtil jedisUtil = new JedisUtil();

        String s = jedisUtil.get("vip:8");

        System.out.println(s);

        Long del = jedisUtil.del("vip:5");

        System.out.println(del);
    }
}
