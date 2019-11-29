package test.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatDemo {

    public static void main(String[] args) throws ParseException {
        System.out.println("找出指定年月日的  禮拜幾");
        //  準備輸出的格式，如：星期四 2009/01/01
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy/MM/dd");//E是星期幾的格式
        //  利用 DateFormat 來parse 日期的字串
        DateFormat df = DateFormat.getDateInstance();
        Date date = df.parse("2009/1/1");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println("===============================================");
        System.out.println("取得現在時間日期");
        //  直接格式化輸出現在時間的方法
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date current = new Date();
        System.out.println(sdFormat.format(current));//SimpleDateFormat.format 設定的日期格式.以Date方式顯示//Date=今日日期時間等
        System.out.println("取得毫秒");
        System.out.println(current.getTime());//Date.getTime取得毫秒
        System.out.println("===============================================");
        //取的3天前的Date
        System.out.println("取得三天前日期");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-3);
        Date d = cal.getTime();//3天前的Date
        System.out.println(sdFormat.format(d));

        System.out.println("===============================================");


        }


    }