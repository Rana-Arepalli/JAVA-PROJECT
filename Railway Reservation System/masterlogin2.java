package exp2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class loginframe extends JFrame implements ActionListener 
{
	Container c;
	Font f1=new Font("Arial",Font.BOLD,20);
	JLabel l1=new JLabel("Username");
	JLabel l2=new JLabel("Password");
	JLabel label1=new JLabel("LOGIN FORM");
	JTextField t1=new JTextField();
	JPasswordField pass=new JPasswordField();
	JButton b1=new JButton("LOGIN");
	JButton b2=new JButton("CREATE");
	JButton b3=new JButton("DELETE");
	JButton b4=new JButton("CH_PASS");
	loginframe()
	{
		ImageIcon icon=new ImageIcon("E:\\Images\\Saved Pictures\\Train-Diesel-Engines-HD-Lovely-Wallpaper.jpg");
		c=this.getContentPane();
		c.setLayout(null);
		//c.setBackground(Color.YELLOW);
		JLabel label=new JLabel(icon);
		label.setBounds(0,0,1000,1000);
		l1.setFont(f1);
		l2.setFont(f1);
		label1.setFont(f1);
		t1.setFont(f1);
		pass.setFont(f1);
		b1.setFont(f1);
		b2.setFont(f1);
		b3.setFont(f1);
		b4.setFont(f1);
		l1.setBackground(Color.RED);
		l1.setForeground(Color.RED);
		l2.setBackground(Color.RED);
		l2.setForeground(Color.RED);
		label1.setBackground(Color.RED);
		label1.setForeground(Color.RED);
		l1.setBounds(250,150,100,40);
		l2.setBounds(250,250,100,40);
		label1.setBounds(450,0,200,200);
		t1.setBounds(400,150,200,40);
		pass.setBounds(400,250,200,40);
		b1.setBounds(150,400,150,40);
		b2.setBounds(350,400,150,40);
		b3.setBounds(550,400,150,40);
		b4.setBounds(750,400,150,40);
		c.add(label1);
		c.add(l1);
		c.add(l2);
		c.add(t1);
		c.add(pass);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(label);	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

		

		public void actionPerformed(ActionEvent ae) 
		{

			if(b1==ae.getSource())
			{

	                    	if(t1.getText().length()==0)
				JOptionPane.showMessageDialog(null,"Empty Fields Detected");
			
				else if(pass.getPassword().length==0)
				JOptionPane.showMessageDialog(null,"Empty Fields Detected");

				else
				{
					String uid= t1.getText();
                			char[] pid= pass.getPassword();			
					String p=String.copyValueOf(pid);

					if(validate_login(uid,p))
					new RailwayApp1();
					else
					JOptionPane.showMessageDialog(null,"Login Unsuccessful");

				}
			}

			else if(b2==ae.getSource())
			{
			
				try
        			{
               
                			Class.forName("com.mysql.jdbc.Driver");
                			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","kunal123")) 
					{

						String uid= t1.getText();
        	        			char[] pid= pass.getPassword();
						String p=null;
						p=String.copyValueOf(pid);

						if((uid.isEmpty())||(p.isEmpty()))
						{
							JOptionPane.showMessageDialog(null,"Empty Fields Detected");
						}
		
						else
						{				
						
                					PreparedStatement stmt=con.prepareStatement("insert into login(user_id, password)"+" values (?,?)");
 			
							stmt.setString(1,uid);
							stmt.setString(2,p);
                
							stmt.executeUpdate();

							JOptionPane.showMessageDialog(null,"Account Created Successfully");
		
						}

																	
					}

				}


                
        			catch(ClassNotFoundException | SQLException e)
        			{
            				e.printStackTrace();
        			}
			
			}

			else if(b3==ae.getSource())
			{
				try
        			{
               
               				 Class.forName("com.mysql.jdbc.Driver");
                           		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","kunal123"); 
					
						String uid= t1.getText();
                				char[] pid= pass.getPassword();
						String p=null;
						p=String.copyValueOf(pid);
                                               

						if((uid.isEmpty())||(p.isEmpty()))
						{
							JOptionPane.showMessageDialog(null,"Empty Fields Detected");
						}
                                                
                                               

						else
						{
                					PreparedStatement stmt=con.prepareStatement("delete from login where user_id=? and password=?");
               
                					stmt.setString(1,uid);
							stmt.setString(2,p);
                					stmt.executeUpdate();

							JOptionPane.showMessageDialog(null,"Account Deleted Successfully");
		
						}
              			  }
		
        			catch(ClassNotFoundException | SQLException e)
        			{
            				e.printStackTrace();
        			}
			}

			else
			{
				try
        			{
               
                			Class.forName("com.mysql.jdbc.Driver");
                			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","kunal123"); 
		
					char[] pid= pass.getPassword();
					String p=null;
					p=String.copyValueOf(pid);

					if((t1.getText().isEmpty())||(p.isEmpty()))
						{
							JOptionPane.showMessageDialog(null,"Empty Fields Detected");
						}

					else
					{
				                PreparedStatement stmt=con.prepareStatement("update login set password='"+p+"' where user_id='"+t1.getText()+"'");
 		
		
	                			stmt.executeUpdate();

			      			JOptionPane.showMessageDialog(null,"Password Changed Successfully");
		
					}

				}

		
		
        			catch(ClassNotFoundException | SQLException e)
        			{
            				e.printStackTrace();
        			}
			}
	
			
		}

		private boolean validate_login(String username, String password)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_form","root","kunal123");
				PreparedStatement stmt=con.prepareStatement("select * from login where user_id=? and password=?");
				stmt.setString(1,username);
				stmt.setString(2,password);
				ResultSet rs=stmt.executeQuery();
				if(rs.next())
				return true;
				else
				return false;
			}

			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}

		}
}
public class masterlogin2
{
	public static void main(String args[])
	{
		loginframe f=new loginframe();
		f.setVisible(true);
		f.setTitle("Login Form");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setBounds(100,100,1000,600);
	}
}

    

