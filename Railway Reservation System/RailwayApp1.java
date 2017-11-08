package exp2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class RailwayApp1 implements ActionListener
{
  	private JFrame f=new JFrame("Modules");
  	Container c;
	Font f1=new Font("Arial",Font.BOLD,20);
	JLabel l1=new JLabel("Welcome to Master Railways");
	JButton b1=new JButton("T_CHART");
	JButton b2=new JButton("P_INFO");
	JButton b3=new JButton("BOOK");
	JButton b4=new JButton("CANCEL");
	JButton b5=new JButton("DISPLAY");
 
 public RailwayApp1()
  {
                ImageIcon icon=new ImageIcon("C:\\Users\\DELL\\Pictures\\Saved Pictures\\Train-Diesel-Engines-HD-Lovely-Wallpaper.jpg");
    		JLabel label=new JLabel(icon);
                f.setBounds(0,0,1000,1000);
    		f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		c=f.getContentPane();
		//c.setBackground(Color.GREEN);
		c.setLayout(null);
		
		label.setBounds(0,0,1000,1000);
                l1.setBounds(350,50,400,100);
		l1.setFont(f1);
		b1.setBounds(100,300,100,50);
		b2.setBounds(250,300,100,50);
		b3.setBounds(400,300,100,50);
		b4.setBounds(550,300,100,50);
		b5.setBounds(700,300,100,50);
		c.add(l1);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
                c.add(label);
                b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
                b5.addActionListener(this);
    
  }
  public void actionPerformed(ActionEvent ae) 
		{

			if(b1==ae.getSource())
			{

	                    TrainChart t1=new TrainChart();
			}
                        
                        else if(b2==ae.getSource())
                        {
                            new passengerinfo();
                        }
                        
                        else if(b3==ae.getSource())
                        {
                            new booktrain();
                        }
                        
                        else if(b4==ae.getSource())
                        {
                            new cancelbooking();
                        }
                        
                        else if(b5==ae.getSource())
                        {
                            new viewticket2();
                        }
                }
}