package client.caseone.write;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;


public class OutputTxt {


    public static boolean outputIndex(List<Map<String, String>> list, String path) {

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(path);
            osw = new OutputStreamWriter(fos, "UTF-8");
            bw = new BufferedWriter(osw);

            int i = 1;
            for (Map m : list) {


                bw.write(i + ". 標題:" + m.get("標題"));
                bw.newLine();
                bw.write("網址:" + m.get("網址"));
                bw.newLine();
                bw.newLine();
                i++;
            }

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                bw.close();

            } catch (IOException e) {

                e.printStackTrace();
            }

            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;

    }
}