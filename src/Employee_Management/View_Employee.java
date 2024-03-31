
package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class View_Employee extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    
    View_Employee()
    {
        f=new JFrame("View Employee");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel("View Employee");
        l1.setVisible(true);
        l1.setBounds(280,30,500,50);
        l1.setForeground(Color.BLACK);
        Font f1=new Font("Arial",Font.BOLD,30);
        l1.setFont(f1);
        f.add(l1);
        
        l2 = new JLabel("View Employee");
        l2.setVisible(true);
        l2.setBounds(100,180,250,30);
        l2.setForeground(Color.BLACK);
        Font f2=new Font("Arial",Font.BOLD,20);
        l2.setFont(f2);
        f.add(l2);
        
        t1 = new JTextField();
        t1.setBounds(290,180,220,30);
        f.add(t1);
        
        b1 = new JButton("Search");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,270,100,30);
        f.add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(350,270,100,30);
        f.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(300,65);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==b1)
       {
           f.setVisible(false);
           //new View_Employee_Data(t1.getText());
           System.out.println("Successful");
       }
       if (ae.getSource()==b2)
       {
           f.setVisible(false);
           new HomePage();
       }
    }
    public static void main(String args[])
    {
        new View_Employee();
    }
}
