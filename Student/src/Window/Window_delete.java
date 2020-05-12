package Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SQL.*;
import java.sql.*;

public class Window_delete{
    public void delete_index(){
        JFrame window = new JFrame("Student_Delete");
        window.setSize(450,200);
        JPanel panel = new JPanel();
        place(panel,window);
        window.add(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void place(JPanel panel,JFrame window){
        panel.setLayout(null);

        JLabel bel1 = new JLabel("Delete System(Only support to delete by Student number)");
        JLabel bel3 = new JLabel("Input student number :");
        bel1.setBounds(50, 1, 350, 25);
        bel3.setBounds(1, 50, 150, 25);
        panel.add(bel1);
        panel.add(bel3);

        JTextField text1= new JTextField();
        text1.setBounds(150,50,150,25);
        panel.add(text1);

        JButton but1 = new JButton("Delete!");
        JButton but2 = new JButton("Show all");
        but1.setBounds(300,50,120,25);
        but2.setBounds(300,75,120,25);

        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection conn = new Conn_SQL().conn_to_mysql();
                Do_SQL sql_result = new Do_SQL();
                sql_result.delete_by_number(conn, text1.getText());
                JOptionPane.showMessageDialog(panel, "Delete "+text1.getText()+" is ok", "Finished",JOptionPane.WARNING_MESSAGE);
            }
        });
        panel.add(but1);

        but2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Result result = new Result();
                Connection conn = new Conn_SQL().conn_to_mysql();
                Do_SQL sql_result = new Do_SQL();
                result.show(sql_result.list_all(conn));
            }
        });
        panel.add(but2);
    }
}