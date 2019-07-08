package com.pengyuan.backstage;

import com.pengyuan.backstage.util.MoneyUtil;
import org.junit.Test;

/**
 * @author LX
 * @date 2019/7/8 - 14:32
 */
public class MoneyTest {

    @Test
    public void test(){

        String s = MoneyUtil.formatMoney(1015000);

        System.out.println(s);
    }
}
