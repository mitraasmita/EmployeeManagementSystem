package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Employee_Data extends JFrame implements ActionListner
{
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    String emp_id,name,age,email,desig,address,phone,dob;
    JButton b1,b2;
    
    View_Employee_Data(String emp_id)
    {
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String s="select * from employees where emp_id='"+emp_id+"'";
            ResultSet rs=obj.stm.executeQuery(s);
            
            while(rs.next())
            {
                name=rs.getString("name");
                age=rs.getString("age");
                desig=rs.getString("desig");
                address=rs.getString("address");
                phone=rs.getString("phone");
                dob=rs.getString("dob");
                email=rs.getString("email");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        f=new JFrame( )
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
    }
    public static void main(String args[])
    {
        new View_Employee_Data();
    }
}
