package com.pengyuan.backstage.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author LX
 * @date 2019/7/7 - 20:56
 */
public class  DateUtil {

    /**
     *       此方法用于 格式化   数据库 里面的    long 类型的数据类型
     *                 格式为   天数
     * @param time
     * @return
     */

    public static String getDayForAdmin(Object time){

        String times = null;
        if(time instanceof Long){
            times = time + "";
        }else if(time instanceof String){
            times =(String) time;
        }

        String year = times.substring( 0 , 4 );

        String month = times.substring( 4 , 6 );

        String day = times.substring( 6 , 8 );

        String date = year + "/" + month + "/" + day;

        return date;
    }

    /**
     *       此方法用于 格式化   数据库 里面的    long 类型的数据类型
     * @param time
     * @return
     */

    public static String getMonthAndDayForAdmin(Object time){

        String times = null;
        if(time instanceof Long){
            times = time + "";
        }else if(time instanceof String){
            times =(String) time;
        }

        String year = times.substring( 0 , 4 );

        String month = times.substring( 4 , 6 );

        String day = times.substring( 6 , 8 );

        String hour = times.substring( 8 , 10);

        String minute = times.substring( 10 , 12 );

        String date = year + "/" + month + "/" + day + " " + hour + ":" + minute;

        return date;
    }

    /**
     *
     * 返回 当前  时间
     *       时间格式    2018/07/08 12:10
     * @return
     */
    public static String getMonthAndDayForAdmin(){

        String times = getTimes() + "";

        String year = times.substring( 0 , 4 );

        String month = times.substring( 4 , 6 );

        String day = times.substring( 6, 8 );

        String hour = times.substring( 8, 10);

        String minute = times.substring( 10, 12 );

        String date = year + "/" + month + "/" + day + " " + hour + ":" + minute;

        return date;
    }


    /**
     *        根据当前网络时间 得到月份  和 日
     *            返回格式
     *                   20190708
     *                   精确到天数
     * @return
     */
    public static String getMonthAndDay(){

        String times = getTimes()+"";

        times = times.substring(0, times.length()-4);

        return times;
    }

    /**
     *         根据当前网络时间   得到月份
     *              返回格式
     *              201807
     *                   精确到   月份
     * @return
     */
    public static String getMonth(){

        String times = getTimes()+"";

        times = times.substring(0, times.length()-6);

        return times;
    }


    /**
     *         得到当前网络的时间
     *              返回 格式
     *                  201907081217
     *                  精确到 分钟
     * @return
     */
    public static long getTimes(){

        try {
            String webUrl = "http://www.baidu.com";
            // 取得资源对象
            URL url = new URL(webUrl);
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            // 输出北京时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);

            String format = sdf.format(date);

            return Long.parseLong(format);
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getTimes1();
    }


    public static long getTimes1(){

        try {
            String webUrl = "http://www.taobao.com";
            // 取得资源对象
            URL url = new URL(webUrl);
            // 生成连接对象
            URLConnection uc = url.openConnection();
            // 发出连接
            uc.connect();
            // 读取网站日期时间
            long ld = uc.getDate();
            // 转换为标准时间对象
            Date date = new Date(ld);
            // 输出北京时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);

            String format = sdf.format(date);

            return Long.parseLong(format);
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getTimes2();
    }



    public static long getTimes2(){

        Date date = new Date(System.currentTimeMillis());
        // 输出北京时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);

        String format = sdf.format(date);

        return Long.parseLong(format);
    }
}
