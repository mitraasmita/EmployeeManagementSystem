
package Employee_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,heading;
    Font f,f1,f2;
    JPanel p;
    
    HomePage()
    {
        super("Employee Home Page");
        
        setLocation(250,65);
        setSize(900,600);
        //setBounds(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        f=new Font("serif",Font.BOLD,20);
        f2=new Font("serif",Font.BOLD,35);
        f1=new Font("serif",Font.BOLD,18);
        
        JMenuBar m1=new JMenuBar();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        JMenu men1 = new JMenu("Profile");
        JMenuItem ment11 = new JMenuItem("Add Profile");
        JMenuItem ment12 = new JMenuItem("View Profile");
        
        JMenu men2 = new JMenu("Manage");
        JMenuItem ment21 = new JMenuItem("Update Details");
        
//        JMenu men3 = new JMenu("Attendance");
//        JMenuItem ment31 = new JMenuItem("Take Attendance");
//        JMenuItem ment32 = new JMenuItem("View Attendance");
        
//        JMenu men4 = new JMenu("Leave");
//        JMenuItem ment41 = new JMenuItem("Apply Leave");
//        JMenuItem ment42 = new JMenuItem("View Leave");
        
//        JMenu men5 = new JMenu("Salary");
//        JMenuItem ment51 = new JMenuItem("Add Salary");
//        JMenuItem ment52 = new JMenuItem("Generate Salary Slip");
        
        JMenu men6 = new JMenu("Remove");
        JMenuItem ment61 = new JMenuItem("Remove Employee");
        
        JMenu men7 = new JMenu("Exit");
        JMenuItem ment71 = new JMenuItem("Logout");
        
        men1.add(ment11);
        men1.add(ment12);
        
        men2.add(ment21);
        
//        men3.add(ment31);
//        men3.add(ment32);
//        
//        men4.add(ment41);
//        men4.add(ment42);
//        
//        men5.add(ment51);
//        men5.add(ment52);
        
        men6.add(ment61);
        
        men7.add(ment71);
        
        
        
        m1.add(men1);
        m1.add(men2);
//        m1.add(men3);
//        m1.add(men4);
//        m1.add(men5);
        m1.add(men6);
        m1.add(men7);
        
        men1.setFont(f);
        men2.setFont(f);
//        men3.setFont(f);
//        men4.setFont(f);
//        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
        
        //m1.setBackground(Color.BLACK);
        
//        men1.setForeground(Color.GRAY);
//        men2.setForeground(Color.GRAY);
////        men3.setForeground(Color.GRAY);
////        men4.setForeground(Color.GRAY);
////        men5.setForeground(Color.GRAY);
//        men6.setForeground(Color.GRAY);
        men7.setForeground(Color.RED);
        
//        ment11.setBackground(Color.BLACK);
//        ment12.setBackground(Color.BLACK);
//        ment21.setBackground(Color.BLACK);
////        ment31.setBackground(Color.BLACK);
////        ment32.setBackground(Color.BLACK);
////        ment41.setBackground(Color.BLACK);
////        ment42.setBackground(Color.BLACK);
////        ment51.setBackground(Color.BLACK);
////        ment52.setBackground(Color.BLACK);
//        ment61.setBackground(Color.BLACK);
//        ment71.setBackground(Color.BLACK);
        
        
//        ment11.setForeground(Color.YELLOW);
//        ment12.setForeground(Color.YELLOW);
//        ment21.setForeground(Color.YELLOW);
////        ment31.setForeground(Color.YELLOW);
////        ment32.setForeground(Color.YELLOW);
////        ment41.setForeground(Color.YELLOW);
////        ment42.setForeground(Color.YELLOW);
////        ment51.setForeground(Color.YELLOW);
////        ment52.setForeground(Color.YELLOW);
//        ment61.setForeground(Color.YELLOW);
//        ment71.setForeground(Color.YELLOW);
        
        setJMenuBar(m1);
        //add(l1);
        
        ment11.addActionListener(this);
        ment12.addActionListener(this);
        ment21.addActionListener(this);
//        ment31.addActionListener(this);
//        ment41.addActionListener(this);
//        ment42.addActionListener(this);
//        ment51.addActionListener(this);
//        ment52.addActionListener(this);
        ment61.addActionListener(this);
        ment71.addActionListener(this);
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        heading=new JLabel("Welcome to ABC Company");
        heading.setBounds(280,30,500,50);
        heading.setFont(new Font("Airal",Font.BOLD,30));
        heading.setForeground(Color.BLACK);
        heading.setForeground(Color.BLACK);
        topPanel.add(heading);
        add(topPanel, BorderLayout.NORTH);
        //heading.setHorizontalAlignment(SwingConstants.);
        //add(heading);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String st=ae.getActionCommand();
        if(st.equals("Add Profile"))
        {
            setVisible(false);
            new Add_Employee();
        }
        else if(st.equals("View Profile"))
        {
            setVisible(false);
            new ViewEmployees();
        }
        else if(st.equals("Update Details"))
        {
            setVisible(false);
            new ViewEmployees();
        }
//        else if(st.equals("Take Attendance"))
//        {
//            //new Take_Attendance().setVisible(true);
//            System.out.println("Succesful");
//        }
//        else if(st.equals("View Attendance"))
//        {
//            //new View_Attendance().setVisible(true);
//            System.out.println("Succesful");
//        }
//        else if(st.equals("Apply Leave"))
//        {
//           // new Apply_Leave().setVisible(true);
//            System.out.println("Succesful");
//        }
//        else if(st.equals("View Leave"))
//        {
//            //new View_Leave().setVisible(true);
//            System.out.println("Succesful");
//        }
//        else if(st.equals("Add salary"))
//        {
//            //new Add_Salary().setVisible(true);
//            System.out.println("Succesful");
//        }
//        else if(st.equals("Generate Salary Slip"))
//        {
//            //new Salary_Slip().setVisible(true);
//            System.out.println("Succesful");
//        }
        else if(st.equals("Logout"))
        {
            setVisible(false);
            new Introduction();
        }
        else if(st.equals("Remove Employee"))
        {
            setVisible(false);
            new RemoveEmployee();
            
        }
    }
    public static void main(String args[])
    {
        new HomePage().setVisible(true);
    }
}
