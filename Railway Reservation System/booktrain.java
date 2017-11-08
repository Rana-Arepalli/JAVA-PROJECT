package exp2;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class booktrain extends JFrame implements ActionListener
{
        Container c;
	Font f1=new Font("Arial",Font.BOLD,20);
	JLabel l1=new JLabel("P_ID");
	
	JLabel label1=new JLabel("BOOKING");
	JTextField t1=new JTextField();
        JButton b1=new JButton("BOOK"); 
	
	public booktrain()
	{
		setTitle("BOOKING");
                ImageIcon icon=new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\amtrak-train-1920x1200-031.jpg");
		c=this.getContentPane();
		c.setLayout(null);
		//c.setBackground(Color.YELLOW);
		JLabel label=new JLabel(icon);
		label.setBounds(0,0,1000,1000);
		l1.setFont(f1);
		
		label1.setFont(f1);
		
                t1.setFont(f1);
		
                
                b1.setFont(f1);
		
		l1.setBackground(Color.RED);
		l1.setForeground(Color.BLACK);
		
		label1.setBackground(Color.RED);
		label1.setForeground(Color.BLACK);
               
                
		l1.setBounds(250,150,100,40);
		
		label1.setBounds(450,0,600,200);
		
                t1.setBounds(400,150,200,40);
		
                
                b1.setBounds(400,450,200,40);
		
		c.add(label1);
		c.add(l1);
		c.add(t1);
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
        	        			
						

						if((pid.isEmpty()))
						{
							JOptionPane.showMessageDialog(null,"Empty Fields Detected");
						}
		
						else
						{				
						
                					PreparedStatement stmt=con.prepareStatement("insert into book_information1(pid)"+" values (?)");
 			
							stmt.setString(1,pid);
                                                       
							
                
							stmt.executeUpdate();

							JOptionPane.showMessageDialog(null,"BOOKED SUCCESSFULLY");
		
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
