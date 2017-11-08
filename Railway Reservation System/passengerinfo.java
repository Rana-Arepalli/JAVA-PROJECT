package exp2;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class passengerinfo extends JFrame implements ActionListener
{
        Container c;
	Font f1=new Font("Arial",Font.BOLD,20);
	JLabel l1=new JLabel("P_ID");
	JLabel l2=new JLabel("P_NAME");
        JLabel l3=new JLabel("PHONE");
        JLabel l4=new JLabel("AGE");
        JLabel l5=new JLabel("GENDER");
        JLabel l6=new JLabel("S_No.");
	JLabel label1=new JLabel("PASSENGER INFORMATION FORM");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
        JTextField t3=new JTextField();
        JTextField t4=new JTextField();
        JTextField t5=new JTextField();
        JTextField t6=new JTextField();
        JButton b1=new JButton("SUBMIT");
       
	
	public passengerinfo()
	{
		ImageIcon icon=new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\Train-Diesel-Engines-HD-Lovely-Wallpaper.jpg");
		c=this.getContentPane();
		c.setLayout(null);
		
		JLabel label=new JLabel(icon);
		label.setBounds(0,0,1000,1000);
		l1.setFont(f1);
		l2.setFont(f1);
                l3.setFont(f1);
                l4.setFont(f1);
                l5.setFont(f1);
                l6.setFont(f1);
		label1.setFont(f1);
		
                t1.setFont(f1);
		t2.setFont(f1);
                t3.setFont(f1);
                t4.setFont(f1);
                t5.setFont(f1);
                t6.setFont(f1);
                
                b1.setFont(f1);
               
		
		l1.setBackground(Color.RED);
		l1.setForeground(Color.BLACK);
		l2.setBackground(Color.RED);
		l2.setForeground(Color.BLACK);
		label1.setBackground(Color.RED);
		label1.setForeground(Color.RED);
                l3.setBackground(Color.RED);
		l3.setForeground(Color.YELLOW);
                l4.setBackground(Color.RED);
		l4.setForeground(Color.YELLOW);
                l5.setBackground(Color.RED);
		l5.setForeground(Color.BLACK);
                l6.setBackground(Color.RED);
		l6.setForeground(Color.YELLOW);
                
		l1.setBounds(250,150,100,40);
		l2.setBounds(250,250,100,40);
                l3.setBounds(250,350,100,40);
                l4.setBounds(250,450,100,40);
                l5.setBounds(250,550,100,40);
                l6.setBounds(250,650,100,40);
		label1.setBounds(350,0,600,200);
		
                t1.setBounds(400,150,200,40);
		t2.setBounds(400,250,200,40);
                t3.setBounds(400,350,200,40);
                t4.setBounds(400,450,200,40);
                t5.setBounds(400,550,200,40);
                t6.setBounds(400,650,200,40);
                
                b1.setBounds(700,450,200,40);
                
		
		c.add(label1);
		c.add(l1);
		c.add(l2);
                c.add(l3);
                c.add(l4);
                c.add(l5);
                c.add(l6);
		c.add(t1);
		c.add(t2);
                c.add(t3);
                c.add(t4);
                c.add(t5);
                c.add(t6);
                c.add(b1);
                
		c.add(label);	
		
                b1.addActionListener(this);
                
                setVisible(true);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                setBounds(10,10,1000,1000);
	}
        
        public void actionPerformed(ActionEvent ae)
        {
            if(b1==ae.getSource())
            {
                try
        			{
               
                			Class.forName("com.mysql.jdbc.Driver");
                			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railway","root","kunal123")) 
					{

						String pid= t1.getText();
        	        			String pname=t2.getText();
                                                String phone=t3.getText();
                                                String age=t4.getText();
                                                String gender=t5.getText();
                                                String sno=t6.getText();
						

						if((pid.isEmpty())||pname.isEmpty()||phone.isEmpty()||age.isEmpty()||gender.isEmpty()||sno.isEmpty())
						{
							JOptionPane.showMessageDialog(null,"Empty Fields Detected");
						}
		
						else
						{				
						
                					PreparedStatement stmt=con.prepareStatement("insert into passenger_info1(pid, pname, phone, age, gender, sno)"+" values (?,?,?,?,?,?)");
 			
							stmt.setString(1,pid);
                                                        stmt.setString(2,pname);
                                                        stmt.setString(3,phone);
                                                        stmt.setString(4,age);
                                                        stmt.setString(5,gender);
                                                        stmt.setString(6,sno);
							
                
							stmt.executeUpdate();

							JOptionPane.showMessageDialog(null,"Details Registered Successfully");
		
						}

																	
					}

				}


                
        			catch(ClassNotFoundException | SQLException e)
        			{
            				e.printStackTrace();
        			}
            }
           
        }
    
}

