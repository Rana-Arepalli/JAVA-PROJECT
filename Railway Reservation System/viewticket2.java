package exp2;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class viewticket2 extends JFrame implements ActionListener
{
    JLabel J_PID, J_NAME, J_PHONE, J_AGE, J_GENDER, J_SNO, J_TNO, label1;
    JTextField T_PID, T_NAME, T_PHONE, T_AGE, T_GENDER, T_SNO, T_TNO;
    JButton btn_search;
    JLabel l1, l2;
    Font f1=new Font("Arial",Font.BOLD,20);
    
    public viewticket2()
    {
        ImageIcon icon=new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\amtrak-train-1920x1200-031.jpg");
        JLabel label=new JLabel(icon);
        label.setBounds(0,0,1000,1000);
        
        label1= new JLabel("VIEW TICKET");
        label1.setBounds(450,50,200,40);
        label1.setForeground(Color.BLACK);
        label1.setFont(f1);
        
        J_PID= new JLabel("PID");
        J_PID.setBounds(250,150,100,40);
        J_PID.setFont(f1);
        J_PID.setForeground(Color.BLACK);
        T_PID= new JTextField();
        T_PID.setBounds(400,150,200,40);
        T_PID.setFont(f1);
        btn_search= new JButton("VIEW");
        btn_search.setBounds(400,550,200,40);
        btn_search.addActionListener(this);
        
        setTitle("VIEW TICKET");
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(10,10,1000,1000);
        
        J_NAME= new JLabel("P_NAME");
        J_NAME.setBounds(250,200,100,40);
        J_NAME.setFont(f1);
        J_NAME.setForeground(Color.BLACK);
        T_NAME= new JTextField();
        T_NAME.setBounds(400,200,200,40);
        T_NAME.setFont(f1);
        
        J_PHONE= new JLabel("PHONE");
        J_PHONE.setBounds(250,250,100,40);
        J_PHONE.setFont(f1);
        J_PHONE.setForeground(Color.BLACK);
        T_PHONE= new JTextField();
        T_PHONE.setBounds(400,250,200,40);
        T_PHONE.setFont(f1);
        
        J_AGE= new JLabel("AGE");
        J_AGE.setBounds(250,300,100,40);
        J_AGE.setFont(f1);
        J_AGE.setForeground(Color.BLACK);
        T_AGE= new JTextField();
        T_AGE.setBounds(400,300,200,40);
        T_AGE.setFont(f1);
        
        J_GENDER= new JLabel("GENDER");
        J_GENDER.setBounds(250,350,100,40);
        J_GENDER.setFont(f1);
        J_GENDER.setForeground(Color.BLACK);
        T_GENDER= new JTextField();
        T_GENDER.setBounds(400,350,200,40);
        T_GENDER.setFont(f1);
        
        J_SNO= new JLabel("SNO");
        J_SNO.setBounds(250,400,100,40);
        J_SNO.setFont(f1);
        J_SNO.setForeground(Color.BLACK);
        T_SNO= new JTextField();
        T_SNO.setBounds(400,400,200,40);
        T_SNO.setFont(f1);
        
        J_TNO= new JLabel("TNO");
        J_TNO.setBounds(250,450,100,40);
        J_TNO.setFont(f1);
        J_TNO.setForeground(Color.BLACK);
        T_TNO= new JTextField();
        T_TNO.setBounds(400,450,200,40);
        T_TNO.setFont(f1);
        
        l1= new JLabel("WELCOME");
        l1.setBounds(250,600,200,40);
        l1.setFont(f1);
        l1.setForeground(Color.BLACK);
        
        l2= new JLabel("P_NAME");
        l2.setBounds(400,600,100,40);
        l2.setFont(f1);
        l2.setForeground(Color.BLACK);
        
        setLayout(null);
        
        add(btn_search);
        add(J_PID);
        add(T_PID);
        add(J_NAME);
        add(T_NAME);
        add(J_PHONE);
        add(T_PHONE);
        add(J_AGE);
        add(T_AGE);
        add(J_GENDER);
        add(T_GENDER);
        add(J_SNO);
        add(T_SNO);
        add(J_TNO);
        add(T_TNO);
        add(label1);
        add(l1);
        add(l2);
        add(label);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Function f= new Function();
        ResultSet rs= null;
        String pname= "pname";
        String phone= "phone";
        String age= "age";
        String gender= "gender";
        String sno= "sno";
        String tno= "t_no";
        
        rs=f.find(T_PID.getText());
        
        try
        {
            if(rs.next())
            {
                T_NAME.setText(rs.getString(pname));
                T_PHONE.setText(rs.getString(phone));
                T_AGE.setText(rs.getString(age));
                T_GENDER.setText(rs.getString(gender));
                T_SNO.setText(rs.getString(sno));
                T_TNO.setText(rs.getString(tno));
                l2.setText(rs.getString(pname));
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID PID");
            }
        }
        
        catch(Exception ae)
        {
            JOptionPane.showMessageDialog(null, ae.getMessage());
        }
        
    }
    
   public class Function
   {
       Connection con= null;
       ResultSet rs= null;
       PreparedStatement ps= null;
       
       Function()
       {
           System.out.println("Default Constructor Executed");
       }
       public ResultSet find(String s)
       {
           try
           {
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","kunal123");
           ps=con.prepareStatement("select book_information1.pid,t_no,pname,phone,age,gender,sno from passenger_info1 inner join book_information1 on passenger_info1.pid=book_information1.pid where book_information1.pid=?");
           ps.setString(1,s);
           rs=ps.executeQuery();
           }
           catch(Exception e)
           {
               System.out.println("problem with connection");
           }
           return rs;
       }
   }
}
