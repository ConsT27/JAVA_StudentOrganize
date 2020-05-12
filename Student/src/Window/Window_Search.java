package Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SQL.*;
import java.sql.*;


public class Window_Search {
    public void search_index(){
        JFrame window = new JFrame("Student_Search");
        window.setSize(450,200);
        JPanel panel = new JPanel();
        place(panel,window);
        window.add(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void place(JPanel panel,JFrame window){
        panel.setLayout(null);

        JLabel bel1 = new JLabel("Search System");
        JLabel bel2 = new JLabel("Search by name:");
        JLabel bel3 = new JLabel("Search by student number:");
        bel1.setBounds(120, 1, 350, 25);
        bel2.setBounds(1,25,175,25);
        bel3.setBounds(1,50,175,25);
        panel.add(bel1);
        panel.add(bel2);
        panel.add(bel3);

        JTextField text1 = new JTextField();
        JTextField text2 = new JTextField();
        text1.setBounds(175,25,150,25);
        text2.setBounds(175,50,150,25);
        panel.add(text1);
        panel.add(text2);

        JButton but1 = new JButton("Search");
        JButton but2 = new JButton("Search");
        JButton but3 = new JButton("Show all");
        but1.setBounds(325, 25, 75, 25);
        but2.setBounds(325, 50, 75, 25);
        but3.setBounds(325, 75, 100, 25);

        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Result result = new Result();
                Connection conn = new Conn_SQL().conn_to_mysql();
                Do_SQL sql_result = new Do_SQL();
                result.show(sql_result.search_name(conn,text1.getText())); 
            }
        });
        panel.add(but1);

        but2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Result result = new Result();
                Connection conn = new Conn_SQL().conn_to_mysql();
                Do_SQL sql_result = new Do_SQL();
                result.show(sql_result.search_number(conn,text2.getText())); 
            }
        });
        panel.add(but2);

        but3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Result result = new Result();
                Connection conn = new Conn_SQL().conn_to_mysql();
                Do_SQL sql_result = new Do_SQL();
                result.show(sql_result.list_all(conn));
            }
        });
        panel.add(but3);

    }
}