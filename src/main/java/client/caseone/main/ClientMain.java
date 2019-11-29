package client.caseone.main;

import client.caseone.DB.DBConn;
import client.caseone.catchweb.Getcontent;
import client.caseone.model.Objj;
import client.caseone.write.OutputTxt;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class ClientMain {
    public static void main(String[] args) throws ParseException {
        Objj ob = new Objj();
        int dog = 0 ;
        if(dog == 0) {

            while(dog!=2) {
                dog++;
                String content = Getcontent.getSource("https://www.mobile01.com/forumtopic.php?c=16&p="+dog);

                List<Map<String, String>> list = Getcontent.sortIndexTolist(content);
                //DBConn.insert(list);
            }

        }
    }

    }
