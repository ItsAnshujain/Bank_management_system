package bank.managment.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{

	 	JButton submit, cancel;
	 	JRadioButton r1, r2, r3, r4;
	 	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	 	String formno;
 	
        SignupThree(String formno) {
	    this.formno=formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 3");
		
		JLabel l1=new JLabel("Page 3 : Account Details ");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(280, 20, 400, 40);
		add(l1);
		
		JLabel type=new JLabel("Account Type :");
		type.setFont(new Font("Raleway", Font.BOLD, 20));
		type.setBounds(100, 80, 200, 30);
		add(type);
		
		r1=new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 16));
		r1.setBackground(Color.WHITE);
		r1.setBounds(100, 120, 250, 20);
		add(r1);
		
		r2=new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 16));
		r2.setBackground(Color.WHITE);
		r2.setBounds(350, 120, 250, 20);
		add(r2);
		
		r3=new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 16));
		r3.setBackground(Color.WHITE);
		r3.setBounds(100, 160, 250, 20);
		add(r3);
		
		r4=new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 16));
		r4.setBackground(Color.WHITE);
		r4.setBounds(350, 160, 250, 20);
		add(r4);
		
		ButtonGroup groupaccount=new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card=new JLabel("Card Number :");
		card.setFont(new Font("Raleway", Font.BOLD, 20));
		card.setBounds(100, 220, 200, 30);
		add(card);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-2418");
		number.setFont(new Font("Raleway", Font.BOLD, 20));
		number.setBounds(330, 220, 300, 30);
		add(number);
		
		JLabel cardDetail=new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		cardDetail.setBounds(100, 250, 300, 20);
		add(cardDetail);
		
		JLabel pin=new JLabel("PIN :");
		pin.setFont(new Font("Raleway", Font.BOLD, 20));
		pin.setBounds(100, 280, 200, 30);
		add(pin);
		
		JLabel pinDetail=new JLabel("Your 4 Digit Password");
		pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		pinDetail.setBounds(100, 310, 300, 20);
		add(pinDetail);
		
		JLabel pnumber=new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
		pnumber.setBounds(330, 280, 300, 30);
		add(pnumber);
		
		JLabel services=new JLabel("Services Required :");
		services.setFont(new Font("Raleway", Font.BOLD, 20));
		services.setBounds(100, 350, 200, 30);
		add(services);
		
		c1=new JCheckBox("ATM Card");
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBackground(Color.WHITE);
		c1.setBounds(100, 390, 200, 30);
		add(c1);
		
		c2=new JCheckBox("Internet Banking");
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBackground(Color.WHITE);
		c2.setBounds(350, 390, 200, 30);
		add(c2);
		
		c3=new JCheckBox("Mobile Banking");
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBackground(Color.WHITE);
		c3.setBounds(100, 440, 200, 30);
		add(c3);
		
		c4=new JCheckBox("EMAIL & SMS Alerts");
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBackground(Color.WHITE);
		c4.setBounds(350, 440, 200, 30);
		add(c4);
		
		c5=new JCheckBox("Cheque Book");
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBackground(Color.WHITE);
		c5.setBounds(100, 490, 200, 30);
		add(c5);
		
		c6=new JCheckBox("E-Statement");
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBackground(Color.WHITE);
		c6.setBounds(350, 490, 200, 30);
		add(c6);
		
		c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBackground(Color.WHITE);
		c7.setBounds(100, 540, 600, 30);
		add(c7);
		
		submit=new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(250, 590, 100, 30);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(420, 590, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
	    getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 720);
		setLocation(350, 0);
		setVisible(true);

	}
        
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==submit) {
    		
    		String accountType=null;
    		if(r1.isSelected()) {
    			accountType="Saving Account";
    		}
    		else if(r2.isSelected()) {
    			accountType="Fixed Deposit Account";
    		}
    		else if(r3.isSelected()) {
    			accountType="Current Account";
    		}
    		else if(r4.isSelected()) {
    			accountType="Reccuring Deposit Account";
    		}
    		Random random=new Random();
    		String cardNumber=""+Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
    		String pinNumber=""+Math.abs((random.nextLong()%9000L)+ 1000L);
    		
    		String facility="";
    		if(c1.isSelected()) {
    			facility=facility+"ATM Card";
    		}
    		else if(c2.isSelected()) {
    			facility=facility+"Internet Banking";
    		} 
    		else if(c3.isSelected()) {
    			facility=facility+"Mobile Banking";
    		} 
    		else if(c4.isSelected()) {
    			facility=facility+"EMAIL & SMS Alerts";
    		} 
    		else if(c5.isSelected()) {
    			facility=facility+"Cheque Book";
    		} 
    		else if(c6.isSelected()) {
    			facility=facility+"E-Statement";
    		}
    		
    		try {
    			if(accountType.equals("")) {
         			JOptionPane.showMessageDialog(null, "Account Type is required");
         		}
    			else {
     			Conn c=new Conn();
     			String query1="insert into signupThree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
     			String query2="insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
     		    c.s.executeUpdate(query1);
     		    c.s.executeUpdate(query2);
     		    
     		    JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber + "\nPin: "+pinNumber); 
     		    
     		    setVisible(false);
     		    new Deposit(pinNumber).setVisible(true);
    			}
         	}catch(Exception e) {
         		System.out.println(e);
         	}
    	}
    	else if(ae.getSource()==cancel) {
    		setVisible(false);
    		new Login().setVisible(true);
    	}	
    }
    
	public static void main(String[] args) {
		new SignupThree("");

	}


}
