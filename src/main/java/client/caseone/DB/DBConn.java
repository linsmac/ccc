package client.caseone.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBConn {
    public static boolean insert(List<Map<String,String>> list)
    {
        Connection conn =null;
        PreparedStatement st = null;
        String query = "INSERT INTO mobile.mobile016 ("
                + " title,"
                + " url,"+"writer,"+"datetime ) VALUES ("
                + "?, ?, ?, ?)";

        try {
            conn = DBConn.conn();
            st = conn.prepareStatement(query);

            for(Map m : list){
                st.setString(1, m.get("標題").toString());
                st.setString(2, m.get("網址").toString());
                st.setString(3, m.get("作者").toString());
                st.setString(4, m.get("發佈時間").toString());
                st.execute();
            }

        }
        catch (SQLException se)
        {
            se.printStackTrace();
            // log exception

        }finally
        {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;



    }

    public static Connection conn()
    {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile?characterEncoding=UTF-8 & serverTimezone=UTC", "root", "1234");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }


        return conn;
    }



    public static void main(String[] args) {

        // TODO Auto-generated method stub

    }
}
