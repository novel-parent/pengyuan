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

    private final static int len = 3;

    private final static String end = "0";

    public static String formatMoney(long money){

        String tMoney = null;

        if(money > multiple){
            //   单价大于  一块钱
            String t = money+"";
             //     1256
            int length = t.length() - len ;
            tMoney =t.substring(0,length )+"."+ t.substring(length);

        }else{
            //   单价或者等于小于  一块钱
            tMoney = "0."+money;
        }

        if(tMoney.endsWith( end )){
            tMoney = tMoney.substring(0,tMoney.length()-1 );
        }

        return tMoney;
    }

}
