package SQL;
import java.sql.*;

public class Conn_SQL{
    public Connection conn_to_mysql(){
        Connection conn=null;
        String url = "jdbc:mysql://localhost:3306/jav";
        String jdbc = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "332161999";
        try{
        Class.forName(jdbc);
        conn = DriverManager.getConnection(url,user,pass);
        System.out.print("Start to connect Mysql\n");
        System.out.print("Connected to Mysql!\n\n");
        return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.print("Database connected fail..\n\n");
        }
        return conn;  //Return the conn
    }
}