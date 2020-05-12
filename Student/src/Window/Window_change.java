package Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SQL.*;
import java.sql.*;

public class Window_change{
    public void change_index(){
        JFrame window = new JFrame("Student_change(Only support to change by number)");
        window.setSize(600,300);
        JPanel panel = new JPanel();
        place(panel,window);
        window.add(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void place(JPanel panel,JFrame window){
        panel.setLayout(null);

        JLabel bel = new JLabel("Change System");
        JLabel bel0 = new JLabel("Student Number(use to lock the data):");
        JLabel bel1 = new JLabel("new Student Name:");
        JLabel bel2 = new JLabel("new Student Sex:");
        JLabel bel3 = new JLabel("new Student Age:");
        JLabel bel4 = new JLabel("new Student Class:");
        JLabel bel5 = new JLabel("new Student Grade:");
        JLabel bel6 = new JLabel("new Student Number:");
        bel.setBounds(150, 1, 350, 25);
        bel0.setBounds(1, 25, 250, 25);
        bel1.setBounds(1, 50, 250, 25);
        bel2.setBounds(1, 75, 250, 25);
        bel3.setBounds(1, 100, 250, 25);
        bel4.setBounds(1, 125, 250, 25);
        bel5.setBounds(1, 150, 250, 25);
        bel6.setBounds(1, 175, 250, 25);
        panel.add(bel);
        panel.add(bel0);
        panel.add(bel1);
        panel.add(bel2);
        panel.add(bel3);
        panel.add(bel4);
        panel.add(bel5);
        panel.add(bel6);

        JTextField text0= new JTextField();
        JTextField text1= new JTextField();
        JTextField text2= new JTextField();
        JTextField text3= new JTextField();
        JTextField text4= new JTextField();
        JTextField text5= new JTextField();
        JTextField text6= new JTextField();
        text0.setBounds(250,25,150,25);
        text1.setBounds(250,50,150,25);
        text2.setBounds(250,75,150,25);
        text3.setBounds(250,100,150,25);
        text4.setBounds(250,125,150,25);
        text5.setBounds(250,150,150,25);
        text6.setBounds(250,175,150,25);
        panel.add(text0);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);

        JButton but1 = new JButton("change!");
        JButton but2 = new JButton("Show all");
        but1.setBounds(400,175,120,25);
        but2.setBounds(400,200,120,25);

        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String num_lock = text0.getText();
                String name = text1.getText();
                String sex = text2.getText();
                String age = text3.getText();
                String class1 = text4.getText();
                String grade = text5.getText();
                String number = text6.getText();
                Connection conn = new Conn_SQL().conn_to_mysql();
                Do_SQL sql_result = new Do_SQL();
                sql_result.change_by_num(conn,name,sex,num_lock,number,age,class1,grade);
                String mes = String.format("The data Number:%s is now toName:%s age:%s sex:%s class:%s grade:%s number:%s is",num_lock,name,age,sex,class1,grade,number);
                JOptionPane.showMessageDialog(panel, mes, "Finished",JOptionPane.WARNING_MESSAGE);
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