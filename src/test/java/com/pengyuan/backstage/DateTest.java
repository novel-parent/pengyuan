package com.pengyuan.backstage;

import com.pengyuan.backstage.util.DateUtil;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author LX
 * @date 2019/7/7 - 20:45
 */
public class DateTest {


    @Test
    public void regexTest(){

        String str = "/login..u";

        System.out.println(str.matches("^.{0,30}(.u)$"));
    }


    @Test
    public void test5(){

        String monthAndDayForAdmin = DateUtil.getMonthAndDayForAdmin();

        String s = DateUtil.getMonthAndDayForAdmin(DateUtil.getTimes()+"");

        System.out.println(monthAndDayForAdmin+ " "+ s);
    }



    @Test
    public void test4(){

        String times = DateUtil.getTimes() + "";

        String year = times.substring( 0 , 4 );

        String month = times.substring( 4 , 6 );

        String day = times.substring(6,8 );

        String hour = times.substring(8, 10);

        String minute = times.substring(10,12 );

        String date = year+"/"+month+"/"+day+" "+hour+":"+minute;

        System.out.println(date);

    }


    @Test
    public void test3(){

        String times = DateUtil.getTimes()+"";

        times = times.substring(0, times.length());

        System.out.println(times);
    }

    @Test
    public void test1(){

        long start = System.currentTimeMillis();
        System.out.println(getWebsiteDatetime("http://www.baidu.com"));
        System.out.println(System.currentTimeMillis()-start);
    }

    @Test
    public void test2(){

        Date date = new Date(System.currentTimeMillis());
        // 输出北京时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);

        String format = sdf.format(date);

        System.out.println(format);
    }

    /**
     * 获取指定网站的日期时间
     *
     * @param webUrl
     * @return
     */
    private  String getWebsiteDatetime(String webUrl){
        try {
            URL url = new URL(webUrl);// 取得资源对象
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.connect();// 发出连接
            long ld = uc.getDate();// 读取网站日期时间
            Date date = new Date(ld);// 转换为标准时间对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm", Locale.CHINA);// 输出北京时间
            return sdf.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





}
