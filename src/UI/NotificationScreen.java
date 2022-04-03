package UI;

import Controller.Controller;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

public class NotificationScreen extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private JPanel      display;
    private DefaultTableModel model;
    private ArrayList<String> due;
    private UI.NotificationScreen thisForm;
    private int count=0;
    private Integer num;

    public NotificationScreen(){
        num = new Integer(0);
        thisForm = this;
        this.due= due;
        display = new JPanel();
        model= new DefaultTableModel();
        table = new JTable(model);
        JLabel header = new JLabel("Managers Update on Employee");
        header.setFont(new Font("Serif", Font.BOLD, 20 ));
        display.add(header);
        Controller con= new Controller();
        due = con.getNotif();
        for (String s:due){
            num++;
            display.add(new JLabel(s));
        }
        display.add(new JLabel("The number of employees with rent due within the next 24hrs is: "+ num.toString()));
        display.setLayout(new GridLayout(0,1));

        /*scrollPane = new JScrollPane(table);
        add(scrollPane);
        display= new JPanel();
        */
        add(display);

        thisForm.setSize(500,200);
        setVisible(true);



    }


}
