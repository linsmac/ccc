package client.caseone.catchweb;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Getcontent {
    public static String getSource(String url) {
        //取出網頁全部內容
        String content = new String();


        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        //以get請求

        CloseableHttpResponse response = null;

        try {

            response = httpclient.execute(httpget);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //取得狀態代碼    200表示成功

                content = EntityUtils.toString(response.getEntity(), "utf-8");
                //透過EntityUtils.toString
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return content;
    }



    public static List<Map<String, String>> sortIndexTolist(String content) throws ParseException {
        //整理內容,回傳List
        String regex = "<div class=\"c-listTableTd__title\">[\\s\\S]*?<a href=\"(\\w+\\.\\w+.f=\\w+&t=\\w+)\"\\s"
                + "class=\"c-link u-ellipsis\">(.*?)</a>[\\s\\S]*?class=\"c-link\">"
                + "(.*?)</a>[\\s\\S]*?class=\"o-fNotes\">[\\s\\S]*?(\\w+-\\w+-\\w+ \\w+:\\w+)</div>[\\s\\S]*?class=\"c-link\">"
                + "(.*?)</a>[\\s\\S]*?class=\"o-fNotes\">(.*?)</div>[\\s\\S]*?class=\"o-fMini\">(.*?)</div>";
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Pattern pa = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        //設定比對的模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Matcher ma = pa.matcher(content);




        while (ma.find()) {



            int fish = 0;
            if (fish == 0) {

                Map<String, String> map = new HashMap<String, String>();
                map.put("標題", ma.group(2));
                map.put("網址", "https://www.mobile01.com/" + ma.group(1));
                map.put("作者",  ma.group(3));
                map.put("發佈時間",ma.group(4));
                map.put("最後回覆時間", "(" + ma.group(5) + ")" + ma.group(6));
                map.put("回應數", ma.group(7));
                list.add(map);
            }

        }
        for(int i = 0;i<list.size();i++)
        {
            System.out.println((i+1)+". 標題: "+list.get(i).get("標題")+"\n網址: "+list.get(i).get("網址")+ "\n發佈時間:"
                    +list.get(i).get("發佈時間")+"\n作者: "
                    +list.get(i).get("作者")+"\n最後回覆時間"
                    +list.get(i).get("最後回覆時間")+"\n回應數: "
                    +list.get(i).get("回應數")+"\n\n");

        }

        return list;
    }

}





//找出需要的group
       /* SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long now = new Date().getTime();
        long lt = 0;
        Date date;
        while (ma.find()) {
            date = sdf.parse(ma.group(4));
            lt = date.getTime();
            System.out.println(lt);


            if(((now-lt)<=(time*1000*60))?true:time==0?true:false){

                Map<String, String> map = new HashMap<String, String>();
                map.put("標題", ma.group(2));
                map.put("網址", "https://www.mobile01.com/" + ma.group(1));*/
               /* map.put("發佈時間", "(" + ma.group(3) + ")" + ma.group(4));
                map.put("最後回復時間", "(" + ma.group(5) + ")" + ma.group(6));
                map.put("回應數", ma.group(7));*/
             //   list.add(map);
         //   }
      //  }

  /*      for(int i = 0;i<list.size();i++)
        {
            System.out.println((i+1)+". 標題: "+list.get(i).get("標題")+"\n網址: "+list.get(i).get("網址")+"\n\n");
                     *//*"\n發佈時間:"
                    +list.get(i).get("發佈時間")+"\n最後回復時間: "
                    +list.get(i).get("最後回復時間")+"\n回應數: "
                    +list.get(i).get("回應數")+"\n\n");*//*



        }



        return list;
    }

}*/
