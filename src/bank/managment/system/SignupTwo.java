package bank.managment.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

	    JTextField panTextField, aadharTextField, cityTextField, pinTextField;
	 	JButton next;
	 	JRadioButton syes, sno, eyes, eno;
	 	JComboBox religion, category, income, education, occupation;
	 	String formno;
 	
    SignupTwo(String formno) {
	    this.formno=formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 2");
		
		JLabel additionalDetails=new JLabel("Page 2 : Additional Details ");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(280, 40, 400, 40);
		add(additionalDetails);
		
		JLabel reliGion=new JLabel("Religion :");
		reliGion.setFont(new Font("Raleway", Font.BOLD, 20));
		reliGion.setBounds(100, 140, 100, 30);
		add(reliGion);
		
		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christen"};
		religion=new JComboBox(valReligion);
		religion.setBounds(300, 140, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);
		
		JLabel cateGory=new JLabel("Category :");
		cateGory.setFont(new Font("Raleway", Font.BOLD, 20));
		cateGory.setBounds(100, 190, 200, 30);
		add(cateGory);
		
		String valCategory[] = {"General", "OBC", "SC", "ST", "Others"};
		category=new JComboBox(valCategory);
		category.setBounds(300, 190, 400, 30);
		category.setBackground(Color.WHITE);
		add(category);
		
		JLabel inCome=new JLabel("Income :");
		inCome.setFont(new Font("Raleway", Font.BOLD, 20));
		inCome.setBounds(100, 240, 200, 30);
		add(inCome);
		
		String incomeCategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
		income=new JComboBox(incomeCategory);
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
		
		JLabel educational=new JLabel("Educational");
		educational.setFont(new Font("Raleway", Font.BOLD, 20));
		educational.setBounds(100, 290, 200, 30);
		add(educational);
	
		JLabel qualification=new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 315, 200, 30);
		add(qualification);
		
		String educationalValues[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
		education=new JComboBox(educationalValues);
		education.setBounds(300, 315, 400, 30);
		education.setBackground(Color.WHITE);
		add(education);
	
		JLabel occupational=new JLabel("Occupation :");
		occupational.setFont(new Font("Raleway", Font.BOLD, 20));
		occupational.setBounds(100, 390, 200, 30);
		add(occupational);
		
		String occupationValues[] = {"Salaried", "Self-Employed", "Bussiness", "Student", "Others"};
		occupation=new JComboBox(occupationValues);
		occupation.setBounds(300, 390, 400, 30);
		occupation.setBackground(Color.WHITE);
		add(occupation);
		
		JLabel pan=new JLabel("PAN Number :");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
		
		panTextField=new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);
		
		JLabel aadhar=new JLabel("Aadhar Number :");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadharTextField=new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);
		
		JLabel state=new JLabel("Senior Citizen :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);
		
		syes=new JRadioButton("Yes");
		syes.setBounds(300, 540, 100, 30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno=new JRadioButton("No");
		sno.setBounds(450, 540, 100, 30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorCitizen=new ButtonGroup();
		seniorCitizen.add(syes);
		seniorCitizen.add(sno);
	
		JLabel pincode=new JLabel("Existing Account :");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);
		
		eyes=new JRadioButton("Yes");
		eyes.setBounds(300, 590, 100, 30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno=new JRadioButton("No");
		eno.setBounds(450, 590, 100, 30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup existingAccount=new ButtonGroup();
		existingAccount.add(eyes);
		existingAccount.add(eno);
		
		JButton next=new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 640, 80, 30);
		next.addActionListener(this);
		add(next);
		
	    getContentPane().setBackground(Color.WHITE);
		
		setSize(850, 800);
		setLocation(350, 0);
		setVisible(true);

	}
        
    public void actionPerformed(ActionEvent ae) {
    	String sreligion=(String)religion.getSelectedItem();
    	String scategory=(String)category.getSelectedItem();
    	String sincome=(String)income.getSelectedItem();
    	String seduction=(String)education.getSelectedItem();
    	String soccupation=(String)occupation.getSelectedItem();
   
    	String seniorcitizen=null;
    	if(syes.isSelected()) {
    		seniorcitizen="Yes";
    	}
    	else if(sno.isSelected()) {
    		seniorcitizen="No";
    	}
    	
    	String existingaccount=null;
    	if(eyes.isSelected()) {
    		existingaccount="Yes";
    	}
    	else if(eno.isSelected()) {
    		existingaccount="No";
    	}
    	
     	String pan=panTextField.getText();
     	String aadhar=aadharTextField.getText();
     	
     	try {
     			Conn c=new Conn();
     			String query="insert into signupTwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seduction+"', '"+soccupation+"', '"+seniorcitizen+"', '"+existingaccount+"', '"+pan+"', '"+aadhar+"')";
     		    c.s.executeUpdate(query);
     		    
     		    setVisible(false);
     		    new SignupThree(formno).setVisible(true);
     	}catch(Exception e) {
     		System.out.println(e);
     	}
    }
    
	
	public static void main(String[] args) {
		new SignupTwo("");

	}


}
