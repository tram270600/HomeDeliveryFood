package CustomerInterface;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Customer extends JPanel implements ActionListener {
	static JButton btnSettings, btnGeneral, btnMailbox, 
				   btnBill, btnHistory, btnBack,
				   btnEdit, btnHelp, btnTerms,
				   btnRate, btnPrivacy,
				   btnContact, btnReward, btnLogout,
				   btnStatus, btnPlace, btnActivity,
				   btnPhone, btnModify, btnReport,
				   btnAbout, btnChangePassword, btnDelete;
	JFrame frame, settingFrame, helpFrame,
		   activityFrame, passwordFrame,
		   mailFrame, editFrame;
	JTextField textArea, currentText, newText,
			   nameText, addressText, phoneText,
		       confirmText;
	private JLabel cusName, phoneNumber, email, password,
				   title, general, accountInfo, contact,
				   reward,address, phone;

	public Customer(String cusName, String email) {
		this.cusName = new JLabel(cusName);
		this.email = new JLabel(email);
		CustomerComponent();
	}
	
	public void CustomerComponent() {
		frame = new JFrame("Customer");
		frame.setBounds(120, 70, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//frame.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

		JPanel account = new JPanel();
		account.setBounds(5, 160, 530, 150);
		account.setLayout(null);
		account.setVisible(true);
		account.setBorder(BorderFactory.createTitledBorder("Account"));	

		
		title = new JLabel("Profile");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(500, 80);
		title.setLocation(525, 25);
		
		
		phone = new JLabel("Phone number");
		phone.setFont(new Font("Arial", Font.PLAIN, 20));
		phone.setSize(200, 80);
		phone.setLocation(35, 160);
		
		reward = new JLabel("rewards");
		reward.setFont(new Font("Arial", Font.PLAIN, 20));
		reward.setSize(200, 80);
		reward.setLocation(35, 240);
			
		address = new JLabel("address");
		address.setFont(new Font("Arial", Font.PLAIN, 20));
		address.setSize(200, 80);
		address.setLocation(35, 200);
		
		cusName.setFont(new Font("Cooper Black", Font.BOLD, 20));
		cusName.setSize(500, 50);
		cusName.setLocation(10, 80);

		email.setFont(new Font("Cooper Black", Font.BOLD, 15));
		email.setSize(500, 40);
		email.setLocation(10, 110);		
		
		
		btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 70, 25);
		btnBack.addActionListener(this);
		
		btnSettings = new JButton("Settings");
		btnSettings.setBounds(1085, 10, 50, 50);
		btnSettings.addActionListener(this);
		
		btnHelp = new JButton("Help");
		btnHelp.setBounds(1020, 10, 50, 50);
		btnHelp.addActionListener(this);
		
		btnMailbox = new JButton("Mailbox");
		btnMailbox.setBounds(955, 10, 50, 50);
		btnMailbox.addActionListener(this);
		
		btnActivity = new JButton("Activity");
		btnActivity.setBounds(890, 10, 50, 50);
		btnActivity.addActionListener(this);
		
		btnEdit = new JButton("Edit profile");
		btnEdit.setBounds(995, 90, 140, 25);
		btnEdit.addActionListener(this);
		
		btnModify = new JButton("Password Modify");
		btnModify.setBounds(995, 125, 140, 25);
		btnModify.addActionListener(this);
		
		btnRate = new JButton("Rate");
		btnRate.setBounds(1035, 160, 100, 25);
		
		btnReward = new JButton("Reward");
		btnReward.setBounds(420, 270, 100, 25);
		
				
		btnLogout = new JButton("Log out");
		btnLogout.setBounds(1035, 195, 100, 25);
		
		frame.add(title);
		frame.add(phone);
		frame.add(reward);
		
		frame.add(address);
		frame.add(cusName);
		frame.add(email);
		
		frame.add(btnBack);
		frame.add(btnSettings);
		frame.add(btnEdit);
		frame.add(btnActivity);
		
		frame.add(btnMailbox);
		
		frame.add(btnHelp);
		frame.add(btnRate);
		
		frame.add(btnReward);
		frame.add(btnLogout);
		frame.add(btnModify);
		
		
		frame.getContentPane().add(account);
	}
	
	public void settings() {	
		settingFrame = new JFrame("Settings");
		settingFrame.setBounds(500, 200, 500, 300);
		settingFrame.getContentPane().setLayout(null);
		settingFrame.setVisible(true);
		settingFrame.setResizable(false);
		
		btnPrivacy = new JButton("Privacy");
		btnPrivacy.setBounds(190, 70, 120, 50);
		settingFrame.add(btnPrivacy);
		
		JButton btnLanguage = new JButton("Language");
		btnLanguage.setBounds(190, 150, 120, 50);
		settingFrame.add(btnLanguage);
	}
	
	public void help() {
		helpFrame = new JFrame("Help Center");
		helpFrame.setBounds(500, 200, 500, 300);
		helpFrame.getContentPane().setLayout(null);
		helpFrame.setVisible(true);
		helpFrame.setResizable(false);
		
		btnAbout = new JButton("About Us");
		btnAbout.setBounds(10, 90, 200, 25);
		helpFrame.add(btnAbout);
		btnAbout.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	JFrame about = new JFrame();
		    	about.setBounds(500, 200, 500, 300);
		    	about.getContentPane().setLayout(null);
		    	about.setVisible(true);
		    	about.setResizable(false);
		    	
		    	 JTextArea textArea = new JTextArea(
		                 "If there is anything the nonconformist hates worse " +
		                 "than a conformist, it's another nonconformist who " +
		                 "doesn't conform to the prevailing standard of nonconformity.", 
		                 6, 
		                 20);
		         textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		         textArea.setBounds(10, 10, 480, 280);
		         textArea.setLineWrap(true);
		         textArea.setWrapStyleWord(true);
		         textArea.setOpaque(false);
		         textArea.setEditable(false);
		         
		         about.add(textArea);
		    }
		    });
		
		btnReport = new JButton("Report Problems");
		btnReport.setBounds(10, 130, 200, 25);
		helpFrame.add(btnReport);
		
		btnTerms = new JButton("Terms & Services");
		btnTerms.setBounds(10, 170, 200, 25);
		btnTerms.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	JFrame terms = new JFrame();
		    	terms.setBounds(500, 200, 500, 300);
		    	terms.getContentPane().setLayout(null);
		    	terms.setVisible(true);
		    	terms.setResizable(false);
		    	
		    	JTextArea textArea = new JTextArea(
		                 "If you reside outside of the Socialist Republic of Vietnam, " +
		                 "the terms of this agreement govern the relationship between" +
		                 "you and our Corporation and its affiliates regarding your use" +
		                 "of our app, and related servivecs, including, without limitation", 
		                 6, 
		                 20);
		         textArea.setFont(new Font("Serif", Font.ITALIC, 16));
		         textArea.setBounds(10, 10, 480, 280);
		         textArea.setLineWrap(true);
		         textArea.setWrapStyleWord(true);
		         textArea.setOpaque(false);
		         textArea.setEditable(false);
		         
		         terms.add(textArea);
		    }
		    });
		helpFrame.add(btnTerms);
		
		JLabel helpLabel = new JLabel("How can we help you?");
		helpLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		helpLabel.setBounds(160, 10, 200, 15);
		helpFrame.add(helpLabel);
		
	    textArea = new JTextField();
		textArea.setBounds(80, 40, 300, 30);
		helpFrame.add(textArea);
	}
	
	public void activity() {
		activityFrame = new JFrame("Activity");
		activityFrame.setBounds(500, 200, 500, 300);
		activityFrame.getContentPane().setLayout(null);
		activityFrame.setVisible(true);
		activityFrame.setResizable(false);
		
		btnPlace = new JButton("Saved places");
		btnPlace.setBounds(180, 140, 130, 25);
		activityFrame.add(btnPlace);
		
		btnHistory = new JButton("Order history");
		btnHistory.setBounds(180, 40, 130, 25);
		activityFrame.add(btnHistory);
		
		btnStatus = new JButton("Delivery status");
		btnStatus.setBounds(180, 90, 130, 25);
		activityFrame.add(btnStatus);
	}
	
	public void password() {
		passwordFrame = new JFrame("Password Modify");
		passwordFrame.setBounds(500, 200, 500, 200);
		passwordFrame.getContentPane().setLayout(null);
		passwordFrame.setVisible(true);
		passwordFrame.setResizable(false);

		
		JLabel currentPassword = new JLabel("Current Password");
		currentPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		currentPassword.setBounds(10, 10, 130, 15);
		passwordFrame.add(currentPassword);
		
		currentText = new JTextField();
		currentText.setBounds(160, 10, 300, 20);
		passwordFrame.add(currentText);
		
		JLabel newPassword = new JLabel("New Password");
		newPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		newPassword.setBounds(10, 40, 100, 15);
		passwordFrame.add(newPassword);	
		
		newText = new JTextField();
		newText.setBounds(160, 40, 300, 20);
		passwordFrame.add(newText);
		
		JLabel confirm = new JLabel("Confirm Password");
		confirm.setFont(new Font("Arial", Font.PLAIN, 15));
		confirm.setBounds(10, 70, 135, 15);
		passwordFrame.add(confirm);	
		
		confirmText = new JTextField();
		confirmText.setBounds(160, 70, 300, 20);
		passwordFrame.add(confirmText);
		
		btnChangePassword = new JButton("Change");
		btnChangePassword.setBounds(205,140, 90, 25);
		passwordFrame.add(btnChangePassword);
	}
	public void mailbox() {
		mailFrame = new JFrame("Mail");
		mailFrame.setBounds(500, 200, 500, 300);
		mailFrame.getContentPane().setLayout(null);
		mailFrame.setVisible(true);

		
		JLabel inbox = new JLabel("Inbox");
		inbox.setFont(new Font("Arial", Font.PLAIN, 15));
		inbox.setBounds(225, 10, 100, 15);
		mailFrame.add(inbox);	
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(400,10,70,20);
		mailFrame.add(btnDelete);	
	}
	public void edit() {
		editFrame = new JFrame("Edit Information");
		editFrame.setBounds(500, 200, 500, 300);
		editFrame.getContentPane().setLayout(null);
		editFrame.setVisible(true);
		
		JLabel phone = new JLabel("phone number");
		phone.setFont(new Font("Arial", Font.PLAIN, 15));
		phone.setBounds(10, 10, 100, 15);
		editFrame.add(phone);
		
		phoneText = new JTextField();
		phoneText.setBounds(160, 10, 300, 20);
		editFrame.add(phoneText); 
		
		JLabel address = new JLabel("address");
		address.setFont(new Font("Arial", Font.PLAIN, 15));
		address.setBounds(10, 40, 100, 15);
		editFrame.add(address);
		
		addressText = new JTextField();
		addressText.setBounds(160, 40, 300, 20);
		editFrame.add(addressText); 
		
		JLabel name = new JLabel("username");
		name.setFont(new Font("Arial", Font.PLAIN, 15));
		name.setBounds(10, 70, 100, 15);
		editFrame.add(name);
		
		nameText = new JTextField();
		nameText.setBounds(160, 70, 300, 20);
		editFrame.add(nameText); 
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(160, 200, 150, 25);
		editFrame.add(btnChange);
		btnChange.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	
		    }
		    });
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//String text = textArea.getText();
		
		if (e.getSource() == btnBack) {
			frame.dispose();
		}
		if (e.getSource() == btnSettings) {			
			settings();
		}
		if (e.getSource() == btnHelp) {			
			help();
		}
		
		if (e.getSource() == btnActivity) {			
			activity();
		}
		if (e.getSource() == btnModify) {			
			password();
		} 
		if (e.getSource() == btnMailbox) {			
			mailbox();
		}
		if (e.getSource() == btnEdit) {			
			edit();
		}
	}

}

