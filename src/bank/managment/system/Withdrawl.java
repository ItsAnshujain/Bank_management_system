package bank.managment.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener{
	    JTextField amount;
	    JButton withdraw, back; 
        String pinnumber;
        
	    Withdrawl(String pinnumber) {
	    	
        this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(730, 730, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 730, 730);
		add(image);
		
		JLabel text=new JLabel("Enter the amount you want to withdraw");
		text.setFont(new Font("System", Font.BOLD, 14));
		text.setForeground(Color.WHITE);
		text.setBounds(140, 240, 400, 20);
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 20));
		amount.setBounds(140, 280, 270, 25);
		add(amount);
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(280, 392, 130, 25);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back=new JButton("Back");
		back.setBounds(280, 420, 130, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(730, 730);
		setLocation(300, 0);
		setVisible(true);
	    }
       
        public void actionPerformed(ActionEvent ae) {
        	if(ae.getSource()==withdraw) {
        		String number=amount.getText();
        		Date date=new Date();
        		if(number.equals("")) {
        			JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
        		}
        		else {
        			try {
        			Conn conn=new Conn();
        			String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
        		    conn.s.executeUpdate(query);
        		    JOptionPane.showMessageDialog(null, "Rs." + number + " Withdraw Successfully");
        		     
        		    setVisible(false);
            		new Transaction(pinnumber).setVisible(true);
        			
        			}catch(Exception e) {
        				System.out.println(e);
        			}
        			
        		}
        	}
        	else if(ae.getSource()==back) {
        		setVisible(false);
        		new Transaction(pinnumber).setVisible(true);
        		
        	}
        	
        }
	
		public static void main(String[] args) {
			new Withdrawl("");
		
		}


}
