package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
	 	JButton back;
        String pinnumber;
        
        BalanceEnquiry(String pinnumber) {
        this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(730, 730, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 730, 730);
		add(image);
		
		
		back=new JButton("Back");
		back.setBounds(280, 420, 140, 25);
		back.addActionListener(this);
		image.add(back);
		
		
		Conn c=new Conn();
		int balance=0;
		try {
			ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			while(rs.next()){
				if(rs.getString("type").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));       					
				}
				else {
					balance-=Integer.parseInt(rs.getString("amount"));      
				}	
			}  
		}catch(Exception e) {
    		System.out.print(e);
    	}
			
		JLabel text=new JLabel("Your current account balance is Rs "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(140, 240, 400, 30);
		image.add(text);
		
		setSize(730, 730);
		setUndecorated(true);
		setLocation(300, 0);
		setVisible(true);
	    }
       
        public void actionPerformed(ActionEvent ae) {
        	setVisible(false);
    		new Transaction(pinnumber).setVisible(true);
        }
	
		public static void main(String[] args) {
			new BalanceEnquiry("");
		}
}
