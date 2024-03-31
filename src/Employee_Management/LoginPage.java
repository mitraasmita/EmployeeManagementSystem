package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import java.util.Locale;

public class LoginPage extends JFrame implements ActionListener
{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    LoginPage()
    {
        f=new JFrame("Login");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1=new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        l2=new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);

        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setBounds(40,140,120,30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,140,120,30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(400,40,150,150);
        f.add(image);

        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(600,280);
        f.setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=t1.getText();
                String pass=t2.getText();
                String q="select * from logindata where username='"+name+"' and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                    new HomePage().setVisible(true);
                    //System.out.println("Login Successful");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered wrong username and password");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2)
        {
            this.f.setVisible(false);
            new Introduction();
        }
    }
    public static void main(String[] args)
    {
        new LoginPage();
    }
}
