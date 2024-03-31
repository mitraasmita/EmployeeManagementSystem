//unique sequence number
package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.text.*;


class JTextFieldLimit extends PlainDocument 
{
   private int limit;
   JTextFieldLimit(int limit) 
   {
      super();
      this.limit = limit;
   }
   JTextFieldLimit(int limit, boolean upper)
   {
      super();
      this.limit = limit;
   }
   public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException 
   {
      if (str == null)
         return;
      if ((getLength() + str.length()) <= limit)
      {
         super.insertString(offset, str, attr);
      }
   }
}


public class Add_Employee extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,department,lblempid;
    JFrame f;
    JTextField t3,t4,t5,t6,t7,t8,t9;
    JButton b1,b2;
    JComboBox cbdepart;
    JDateChooser dcdob;
    Random ran = new Random();
    int number= ran.nextInt(9999);
    
    Add_Employee()
    {
        f= new JFrame("Add Employee");
        //f.setBackground(Color.WHITE);
        f.setLayout(null);
        
           
        l1=new JLabel("Add New Emplyee Details");
        l1.setBounds(280,30,500,50);
        l1.setFont(new Font("Airal",Font.BOLD,30));
        l1.setForeground(Color.BLACK);
        f.add(l1);
        
        l2=new JLabel("Employee ID");
        l2.setBounds(50,150,150,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l2.setForeground(Color.black);
        f.add(l2);
        
        lblempid=new JLabel(""+number);
        lblempid.setBounds(220,150,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        f.add(lblempid);
        
        l3=new JLabel("Name");
        l3.setBounds(50,200,100,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l3.setForeground(Color.black);
        f.add(l3);
        
        t3=new JTextField();
        t3.setBounds(220,200,150,30);
        f.add(t3);
        
        l4=new JLabel("Age");
        l4.setBounds(50,250,100,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l4.setForeground(Color.black);
        f.add(l4);
        
        t4=new JTextField();
        t4.setBounds(220,250,150,30);
        f.add(t4);
        
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
        
        t8=new JTextField(10);
        t8.setDocument(new JTextFieldLimit(10));
        t8.setBounds(620,200,150,30);
        f.add(t8);
        
        l9=new JLabel("D.O.B.");
        l9.setBounds(500,250,100,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        l9.setForeground(Color.black);
        f.add(l9);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(620,250,150,30);
        f.add(dcdob);
        
//        t9=new JTextField();
//        t9.setBounds(620,250,150,30);
//        f.add(t9);

        
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
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(270,450,150,40);
        f.add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.RED);
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
        String emp_id=lblempid.getText();
        String name=t3.getText();
        String age=t4.getText();
        String email=t5.getText();
        String desig=t6.getText();
        String address=t7.getText();
        String phone=t8.getText();
        String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String department=(String) cbdepart.getSelectedItem();        
        
        if(ae.getSource()==b1)
        {
            try
            {
            ConnectionClass obj = new ConnectionClass();
            String q = "insert into employees values('"+emp_id+"','"+name+"','"+age+"','"+email+"','"+desig+"','"+address+"','"+phone+"','"+dob+"','"+department+"')";
          
            obj.stm.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
            f.setVisible(false);
            new HomePage().setVisible(true);
            }
            catch(Exception ex)
                    {
                       System.out.println("The error is "+ex);
                    }
        }
        if(ae.getSource()==b2)
        {
             f.setVisible(false);
             new HomePage().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new Add_Employee();
    }
}
