package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame{
	 	JButton back;
        String pinnumber;
        
        MiniStatement(String pinnumber) {
        	
        this.pinnumber=pinnumber;
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 140, 400, 200);
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150, 20, 100, 20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20, 400, 300, 20);
		add(balance);
		
		Conn c=new Conn();
		try {
			
			ResultSet rs=c.s.executeQuery("select * from login where pinNumber = '"+pinnumber+"'");
			while(rs.next()){
				card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));	
			}  
		}catch(Exception e) {
    		System.out.print(e);
    	}
		
		try {
			Conn conn=new Conn();
			int bal=0;
			ResultSet rs=conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			while(rs.next()){
				mini.setText(mini.getText() + "<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");	
				
				if(rs.getString("type").equals("Deposit")) {
					bal+=Integer.parseInt(rs.getString("amount"));       					
				}
				else {
					bal-=Integer.parseInt(rs.getString("amount"));      
				}	
			} 
			balance.setText("Your current account balance is Rs "+ bal);
		}catch(Exception e) {
    		System.out.print(e);
    	}
		
		setSize(400, 600);
		setLocation(20, 20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	    }
       
//        public void actionPerformed(ActionEvent ae) {
//        	setVisible(false);
//    		new Transaction(pinnumber).setVisible(true);
//        }
	
		public static void main(String[] args) {
			new MiniStatement("");
		}
}
