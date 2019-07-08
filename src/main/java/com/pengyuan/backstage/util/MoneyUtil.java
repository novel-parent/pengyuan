package com.pengyuan.backstage.util;

/**
 * @author LX
 * @date 2019/7/8 - 14:23
 */
public class MoneyUtil {

    /**
     *    默认的 钱的扩大倍数
     */
    private final static int multiple = 1000;

    private final static String end = "0";

    public static String formatMoney(long money){

        String tMoney = money+"";

        String yuan = money/multiple +".";

        String li = tMoney.substring( yuan.length()-1 );

        if(li.endsWith( end )){
            li = li.substring(0,li.length()-1 );
        }

        return yuan+li;
    }

}
