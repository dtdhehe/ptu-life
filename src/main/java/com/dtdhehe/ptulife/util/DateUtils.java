package com.dtdhehe.ptulife.util;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create By Xie_东
 * on 2018/12/21 10:59
 * @author admin
 */
public class DateUtils {

    /**
     * 获取当前年月日，
     * 格式为 2018-10-10
     * @return
     */
    public static String getCurrentDate(){
        Date now = new Date();
        //获取当前年月日
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String currentDate = dateFormat.format(now);
        return currentDate.replace("/","-");
    }

    /**
     * 获取当前年月日,时分秒毫秒
     * 格式 2018101015000000   16位
     * @return
     */
    public static String getCurrentDateTime(){
        Date now = new Date();
        //获取当前年月日
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:mm");
        String currentDate = dateFormat.format(now);
        String time = currentDate.replace("/","");
        String currentTime = time.replace(" ","");
        return currentTime.replace(":","");
    }

    public static String date2ViewType(String dateTime){
        String formateDate;
        if (StringUtils.isEmpty(dateTime)){
            return dateTime;
        }
        formateDate = dateTime.substring(0,4)+"-"
                    + dateTime.substring(4,6)+"-"
                    + dateTime.substring(6,8)+" "
                    + dateTime.substring(8,10)+":"
                    + dateTime.substring(10,12)+":"
                    + dateTime.substring(12,14);
        return formateDate;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDateTime());
    }

}
