package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateEmployees extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,lblempid,lblname,lblage,lbldob,department;
    JComboBox cbdepart;
    JFrame f;
    JTextField t5,t6,t7,t8;
    JButton b1,b2;
    String emp_id;
    
    UpdateEmployees(String emp_id)
    {
        f= new JFrame("Update Employees");
        //f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        this.emp_id=emp_id;
        
        l1=new JLabel("Update Emplyee Details");
        l1.setBounds(280,30,500,50);
        l1.setFont(new Font("Airal",Font.BOLD,30));
        l1.setForeground(Color.BLACK);
        f.add(l1);
        
        l2=new JLabel("Employee ID");
        l2.setBounds(50,150,150,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l2.setForeground(Color.black);
        f.add(l2);
        
        lblempid=new JLabel();
        lblempid.setBounds(220,150,150,30);
        f.add(lblempid);
       
        l3=new JLabel("Name");
        l3.setBounds(50,200,100,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setForeground(Color.black);
        f.add(l3);
        
        lblname=new JLabel();
        lblname.setBounds(220,200,150,30);
        f.add(lblname);
        
        l4=new JLabel("Age");
        l4.setBounds(50,250,100,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l4.setForeground(Color.black);
        f.add(l4);
        
        lblage=new JLabel();
        lblage.setBounds(220,250,150,30);
        f.add(lblage);
        
        l5=new JLabel("Email Id");
        l5.setBounds(50,300,100,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l5.setForeground(Color.black);
        f.add(l5);
        
        t5=new JTextField();
        t5.setBounds(220,300,150,30);
        f.add(t5);
        
        l6=new JLabel("Designation");
        l6.setBounds(50,350,100,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        l6.setForeground(Color.black);
        f.add(l6);
        
        t6=new JTextField();
        t6.setBounds(220,350,150,30);
        f.add(t6);
        
        l7=new JLabel("Address");
        l7.setBounds(500,150,100,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        l7.setForeground(Color.black);
        f.add(l7);
        
        t7=new JTextField();
        t7.setBounds(620,150,150,30);
        f.add(t7);
        
        l8=new JLabel("Phone No.");
        l8.setBounds(500,200,100,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        l8.setForeground(Color.black);
        f.add(l8);
        
        t8=new JTextField();
        t8.setBounds(620,200,150,30);
        f.add(t8);
        
        l9=new JLabel("D.O.B.");
        l9.setBounds(500,250,100,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        l9.setForeground(Color.black);
        f.add(l9);
        
        lbldob=new JLabel();
        lbldob.setBounds(620,250,150,30);
        f.add(lbldob);
        
        department=new JLabel("Department");
        department.setBounds(500,300,150,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        department.setForeground(Color.black);
        f.add(department);
        
        String positions[] = {"Creative","Finance","HR","Sales","IT","R&D"};
        cbdepart=new JComboBox(positions);
        cbdepart.setBackground(Color.WHITE);
        cbdepart.setBounds(620,300,200,30);
        f.add(cbdepart);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String query="Select * from employees where emp_id = '"+emp_id+"'";
            ResultSet rs = obj.stm.executeQuery(query);
            while(rs.next())
            {
                lblempid.setText(rs.getString("emp_id"));
                lblname.setText(rs.getString("name"));
                lbldob.setText(rs.getString("dob"));
                lblage.setText(rs.getString("age"));
                t5.setText(rs.getString("email"));
                t6.setText(rs.getString("desig"));
                t7.setText(rs.getString("address"));
                t8.setText(rs.getString("phone"));
                String department = rs.getString("department");
                cbdepart.setSelectedItem(department);

                //cbdepart.setText(rs.getString("department"));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        b1=new JButton("Update");
        //b1.setBackground(Color.BLUE);
        //b1.setForeground(Color.WHITE);
        b1.setBounds(270,450,150,40);
        f.add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(490,450,150,40);
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
            String email = t5.getText();
            String desig = t6.getText();
            String address = t7.getText();
            String phone = t8.getText();
            String department=(String) cbdepart.getSelectedItem(); 
            
            try
            {
               ConnectionClass obj= new ConnectionClass();
               String query="update employees set email = '"+email+"',desig = '"+desig+"',address = '"+address+"', phone = '"+phone+"',department = '"+department+"' where emp_id = '"+emp_id+"'";
               obj.stm.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Updated Successfully");
               f.setVisible(false);
               new ViewEmployees().setVisible(true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            f.setVisible(false);
            new ViewEmployees().setVisible(true);
          
        }
    }
    public static void main(String args[])
    {
        new UpdateEmployees("");
    }
}
