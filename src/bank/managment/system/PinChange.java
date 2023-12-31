package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
	 	JButton change, back;
	 	JPasswordField pin, repin;
        String pinnumber;
        PinChange(String pinnumber) {
        this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("image/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(730, 730, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 730, 730);
		add(image);
		
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setForeground(Color.WHITE);
		text.setBounds(200, 240, 500, 30);
		image.add(text);
		
		JLabel pintext=new JLabel("New PIN:");
		pintext.setFont(new Font("System", Font.BOLD, 16));
		pintext.setForeground(Color.WHITE);
		pintext.setBounds(130, 280, 180, 25);
		image.add(pintext);
		
		pin =new JPasswordField();
		pin.setFont(new Font("System", Font.BOLD, 25));
		pin.setBounds(260, 280, 160, 25);
		image.add(pin);
		
		JLabel repintext=new JLabel("Re-enter PIN:");
		repintext.setFont(new Font("System", Font.BOLD, 16));
		repintext.setForeground(Color.WHITE);
		repintext.setBounds(130, 310, 180, 25);
		image.add(repintext);
		
		repin =new JPasswordField();
		repin.setFont(new Font("System", Font.BOLD, 25));
		repin.setBounds(260, 310, 160, 25);
		image.add(repin);
		
		change=new JButton("Change");
		change.setBounds(280, 392, 140, 25);
		change.addActionListener(this);
		image.add(change);
		
		back=new JButton("Back");
		back.setBounds(280, 420, 140, 25);
		back.addActionListener(this);
		image.add(back);
		
		setSize(730, 730);
		setUndecorated(true);
		setLocation(300, 0);
		setVisible(true);
	    }
       
        public void actionPerformed(ActionEvent ae) {
        	if(ae.getSource()==change) {
        		try {
        			String npin=pin.getText();
        			String rpin=repin.getText();
        			if(!npin.equals(rpin)) {
        				JOptionPane.showMessageDialog(null, "Entered PIN does not match");
        				return;
        			}
        			if(npin.equals("")) {
        				JOptionPane.showMessageDialog(null, "Please enter new PIN");
        				return;
        			}
        			if(rpin.equals("")) {
        				JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
        				return;
        			}
        			
        			Conn conn=new Conn();
        			String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
        			String query2="update login set pinNumber='"+rpin+"' where pinNumber='"+pinnumber+"'";
        			String query3="update signupThree set pinNumber='"+rpin+"' where pinNumber='"+pinnumber+"'";
        			
        			conn.s.executeUpdate(query1);
        			conn.s.executeUpdate(query2);
        			conn.s.executeUpdate(query3);
        			
        			JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
        			setVisible(false);
            		new Transaction(pinnumber).setVisible(true);
        		}catch(Exception e) {
        			System.out.println(e);
        		}
        	}
        	else {
        		setVisible(false);
        		new Transaction(pinnumber).setVisible(true);
        	}
        	
        }
	
		public static void main(String[] args) {
			new PinChange("");
		
		}


}
