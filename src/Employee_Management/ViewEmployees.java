
package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployees extends JFrame implements ActionListener
{
    JTable table;
    JLabel searchlbl;
    Choice cemployeeid;
    
   JButton search,print,update,back;
    
    ViewEmployees()
    {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       searchlbl= new JLabel("Search by Employee ID");
       searchlbl.setBounds(20,20,150,20);
       add(searchlbl);
       
       cemployeeid = new Choice();
       cemployeeid.setBounds(180,20,150,20);
       add(cemployeeid);
       
        try
       {
           ConnectionClass obj = new ConnectionClass();
           ResultSet rs=obj.stm.executeQuery("Select * from employees");
           while(rs.next())
           {
               cemployeeid.add(rs.getString("emp_id"));
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       
       
       table=new JTable();
       try
       {
           ConnectionClass obj = new ConnectionClass();
           ResultSet rs=obj.stm.executeQuery("Select * from employees");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       
       JScrollPane jsp = new JScrollPane(table);
       jsp.setBounds(0,100,900,600);
       add(jsp);
       
       search= new JButton("Search");
       search.setBounds(20,70,80,20);
       search.addActionListener(this);
       add(search);
       
       print= new JButton("Print");
       print.setBounds(120,70,80,20);
       print.addActionListener(this);
       add(print);
       
       update= new JButton("Update");
       update.setBounds(220,70,80,20);
       update.addActionListener(this);
       add(update);
       
      back= new JButton("Back");
      back.setBounds(320,70,80,20);
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
        setSize(900,600);
       setLocation(250,65);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== search)
        {
            String query = "select * from employees where emp_id='"+cemployeeid.getSelectedItem()+"'";
            try
            {
                ConnectionClass obj = new ConnectionClass();
                ResultSet rs = obj.stm.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==print)
        {
            try
            {
               table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateEmployees(cemployeeid.getSelectedItem());
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            HomePage m = new HomePage();
            m.setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new ViewEmployees();
    }
}
