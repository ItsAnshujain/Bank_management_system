package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
	    JButton rupee100, rupee200, rupee1000, rupee2000, rupee5000, rupee10000, back;
        String pinnumber;
        FastCash(String pinnumber) {
        this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(730, 730, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 730, 730);
		add(image);
		
		JLabel text=new JLabel("SELECT WITHDRAW AMOUNT");
		text.setBounds(160, 240, 510, 30);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		
		rupee100=new JButton("Rs. 100");
		rupee100.setBounds(135, 337, 130, 25);
		rupee100.addActionListener(this);
		image.add(rupee100);
		
		rupee200=new JButton("Rs. 200");
		rupee200.setBounds(280, 337, 130, 25);
		rupee200.addActionListener(this);
		image.add(rupee200);
		
		rupee1000=new JButton("Rs. 1000");
		rupee1000.setBounds(135, 364, 130, 25);
		rupee1000.addActionListener(this);
		image.add(rupee1000);
		
		rupee2000=new JButton("Rs. 2000");
		rupee2000.setBounds(280, 364, 130, 25);
		rupee2000.addActionListener(this);
		image.add(rupee2000);
		
		rupee5000=new JButton("Rs. 5000");
		rupee5000.setBounds(135, 392, 130, 25);
		rupee5000.addActionListener(this);
		image.add(rupee5000);
		
		rupee10000=new JButton("Rs. 10000");
		rupee10000.setBounds(280, 392, 130, 25);
		rupee10000.addActionListener(this);
		image.add(rupee10000);
		
		back=new JButton("Back");
		back.setBounds(280, 420, 130, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(730, 730);
		setLocation(300, 0);
		setUndecorated(true);
		setVisible(true);
	    }
       
        public void actionPerformed(ActionEvent ae) {
        	if(ae.getSource()==back) {
        		setVisible(false);
        		new Transaction(pinnumber).setVisible(true);
        	}
        	else {
        		String amount=((JButton)ae.getSource()).getText().substring(4);
        		Conn c=new Conn();
        		try {
        			ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
        			int balance=0;
        			while(rs.next()){
        				if(rs.getString("type").equals("Deposit")) {
        					balance+=Integer.parseInt(rs.getString("amount"));       					
        				}
        				else {
        					balance-=Integer.parseInt(rs.getString("amount"));      
        				}	
        			}  
        			if(ae.getSource()!=back && balance<Integer.parseInt(amount)) {
        				JOptionPane.showMessageDialog(null, "Insufficient Balance");
        				return;
        			}
        			
        			Date date=new Date();
        			String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"') ";
        			c.s.executeUpdate(query);
        		 
        			JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
        		
        			setVisible(false);
            		new Transaction(pinnumber).setVisible(true);
        		}catch(Exception e) {
        			System.out.print(e);
        		}
        	}
        		
        }
	
		public static void main(String[] args) {
			new FastCash("");
		
		}


}
