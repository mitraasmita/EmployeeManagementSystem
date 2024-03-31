
package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Introduction extends JFrame implements ActionListener
{
    JLabel heading;
    JButton click,close;
    JFrame f;
    
    Introduction()
    {
        f= new JFrame("Introduction");
       //f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        heading = new JLabel("Employee Management System Portal ");
        heading.setBounds(80,90,800,45);
        heading.setFont(new Font("Arial",Font.BOLD,40));
        f.add(heading);  
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0,0,900,600);
        f.add(image);
                
        
        click = new JButton("Click to Continue");
        click.setBounds(230,300,200,70);
        //click.setBackground(Color.PINK);
        //click.setForeground(Color.WHITE);
        image.add(click);
        click.addActionListener(this);
        
        close = new JButton("Close");
        close.setBounds(490,300,200,70);
        close.setBackground(Color.RED);
        close.setForeground(Color.WHITE);
        image.add(close);
        close.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(250,65);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==click)
        {
            f.setVisible(false);
            new LoginPage();
        }
        if(ae.getSource()==close)
        {
           System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new Introduction();
    }
}
