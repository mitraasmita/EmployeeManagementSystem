package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener
{
   JFrame f;
   JLabel lblempid,lblname,name,lblphone,phone,lblemail,email,desig,lbldesig,address,lbladdress;
   Choice cempid;
   JButton b1,b2;
   
    RemoveEmployee()
   {
       
       f= new JFrame("Remove Employees");
        //f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        lblempid = new JLabel("Enter Employee ID to Delete");
        lblempid.setBounds(60,50,300,30);
        lblempid.setFont(new Font("Airal",Font.PLAIN,20));
        f.add(lblempid);
        
        cempid = new Choice();
        cempid.setBounds(400,53,150,30);
        f.add(cempid);
        
        try
        {
           ConnectionClass obj=new ConnectionClass();
            String query="Select * from employees";
            ResultSet rs = obj.stm.executeQuery(query); 
            while(rs.next())
            {
                cempid.add(rs.getString("emp_id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
        name = new JLabel("Name");
        name.setBounds(60,150,150,30);
        name.setFont(new Font("Airal",Font.PLAIN,15));
        f.add(name);
        
        lblname = new JLabel();
        lblname.setBounds(220,150,150,30);
        f.add(lblname);
        
        phone = new JLabel("Phone");
        phone.setBounds(60,190,150,30);
        phone.setFont(new Font("Airal",Font.PLAIN,15));
        f.add(phone);
        
        lblphone = new JLabel();
        lblphone.setBounds(220,190,150,30);
        f.add(lblphone);
        
        email = new JLabel("Email Id");
        email.setBounds(60,230,150,30);
        email.setFont(new Font("Airal",Font.PLAIN,15));
        f.add(email);
        
        lblemail = new JLabel();
        lblemail.setBounds(220,230,200,30);
        f.add(lblemail);
        
        desig = new JLabel("Designation");
        desig.setBounds(60,270,150,30);
        desig.setFont(new Font("Airal",Font.PLAIN,15));
        f.add(desig);
        
        lbldesig = new JLabel();
        lbldesig.setBounds(220,270,150,30);
        f.add(lbldesig);
        
        address = new JLabel("Address");
        address.setBounds(60,310,150,30);
        address.setFont(new Font("Airal",Font.PLAIN,15));
        f.add(address);
        
        lbladdress = new JLabel();
        lbladdress.setBounds(220,310,150,30);
        f.add(lbladdress);
        
        try
        {
           ConnectionClass obj=new ConnectionClass();
            String query="Select * from employees where emp_id ='"+cempid.getSelectedItem()+"'";
            ResultSet rs = obj.stm.executeQuery(query); 
            while(rs.next())
            {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
                lbldesig.setText(rs.getString("desig"));
                lbladdress.setText(rs.getString("address"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String query="Select * from employees where emp_id ='"+cempid.getSelectedItem()+"'";
                    ResultSet rs = obj.stm.executeQuery(query); 
                    while(rs.next())
                    {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                        lbldesig.setText(rs.getString("desig"));
                        lbladdress.setText(rs.getString("address"));
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                } 
            }
        });
        
        b1=new JButton("Delete");
        b1.setBounds(270,410,150,30);
        f.add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(490,410,150,30);
        f.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(250,65);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   
    public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==b1)
       {
           try
           {
               ConnectionClass obj=new ConnectionClass();
               String query = "delete from employees where emp_id = '"+cempid.getSelectedItem()+"'";
               obj.stm.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Deleted Successfully");
               f.setVisible(false);
               new HomePage().setVisible(true);
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }
       }
       else
       {
           f.setVisible(false);
           new HomePage().setVisible(true);
       }
   }
   public static void main(String args[])
   {
       new RemoveEmployee();
   }
}
