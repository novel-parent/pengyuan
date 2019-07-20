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

        jedisUtil.set("user:48", "7");

        Long del = jedisUtil.del("user:48");

        System.out.println(del);
    }
}
