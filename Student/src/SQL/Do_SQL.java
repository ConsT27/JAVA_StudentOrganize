package SQL;
import SQL.Conn_SQL;
import java.sql.*;
import java.util.Arrays;



public class Do_SQL{
    // public static void main(String[] args){
    //     Connection conn = new Conn_SQL().conn_to_mysql();
    //     Object [][] res = list_all(conn);
    //     System.out.print(Arrays.toString(res[0]));
    // }

    public Object[][] list_all(Connection conn) {
        int i=0;
        int j=0;
        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from student";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String[][] res = new String[i][];
        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from student";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String number = rs.getString("number");
                String age = rs.getString("age");
                String class1 = rs.getString("class");
                String grade = rs.getString("grade");
                String [] tmp={name,age,sex,class1,grade,number};
                res[j] = tmp;
                j++;
            }
            return res;
        }
        catch(Exception e){
            e.printStackTrace();
            return res;
        }
        finally{
            return res;
        }
    }

    public Object[][] search_name(Connection conn,String name_for_search){
        int i=0;
        int j=0;
        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from student where name = \'"+name_for_search+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String[][] res = new String[i][];
        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from student where name = \'"+name_for_search+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String number = rs.getString("number");
                String age = rs.getString("age");
                String class1 = rs.getString("class");
                String grade = rs.getString("grade");
                String [] tmp={name,age,sex,class1,grade,number};
                res[j] = tmp;
                j++;
            }
            return res;
        }
        catch(Exception e){
            e.printStackTrace();
            return res;
        }
        finally{
            return res;
        }
    }

    public Object[][] search_number(Connection conn,String number_for_search){
        int i=0;
        int j=0;
        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from student where number = \'"+number_for_search+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        String[][] res = new String[i][];
        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from student where number = \'"+number_for_search+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String number = rs.getString("number");
                String age = rs.getString("age");
                String class1 = rs.getString("class");
                String grade = rs.getString("grade");
                String [] tmp={name,age,sex,class1,grade,number};
                res[j] = tmp;
                j++;
            }
            return res;
        }
        catch(Exception e){
            e.printStackTrace();
            return res;
        }
        finally{
            return res;
        }
    }

    public void add(Connection conn,String name,String sex,String number,String age,String class1,String grade){
        try{
            String sql = String.format("insert into student(name,sex,age,class,grade,number) values(\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\')",name,sex,age,class1,grade,number);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void delete_by_number(Connection conn,String number){
        try{
            String sql = String.format("delete from student where number = \'%s\'",number);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void change_by_num(Connection conn,String name,String sex,String number,String new_number,String age,String class1,String grade){
        try{
            String sql = String.format("update student set name=\'%s\',sex=\'%s\',number=\'%s\',age=\'%s\',class=\'%s\',grade=\'%s\' where number = \'%s\'",name,sex,new_number,age,class1,grade,number);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}