package Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Window.*;

public class Window_Index{
    public static void main(String[] args){
        JFrame window = new JFrame("Student_Index");
        window.setSize(350,150);
        JPanel panel = new JPanel();
        place(panel,window);
        window.add(panel);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void place(JPanel panel,JFrame window){

        JLabel bel1 = new JLabel("welcome to the system of student organization");
        panel.add(bel1);

        JButton but1 = new JButton("Search");
        JButton but2 = new JButton("Add");
        JButton but3 = new JButton("Delete");
        JButton but4 = new JButton("Change");
        but1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window_Search a = new Window_Search();
                a.search_index();
            }
        });
        but2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window_add a = new Window_add();
                a.add_index();
            }
        });
        but3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window_delete a = new Window_delete();
                a.delete_index();
            }
        });
        but4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Window_change a = new Window_change();
                a.change_index();
            }
        });
        panel.add(but1);
        panel.add(but2);
        panel.add(but3);
        panel.add(but4);
    }
}
class Result{
    public void show(Object[][] data){
        JFrame container;
        JTable jTable;
            String [] columnName = {
                    "name",
                    "age",
                    "sex",
                    "class",
                    "grade",
                    "number"
            };
            jTable=new JTable(data,columnName);
            JScrollPane jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(jTable);
            
            container = new JFrame("The result of Search");
            container.setSize(800,600);
            container.setLayout(new BorderLayout());
            container.add(jScrollPane,BorderLayout.CENTER);
            container.setVisible(true);
        }
}