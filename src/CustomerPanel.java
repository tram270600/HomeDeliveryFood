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

public class CustomerPanel extends JPanel implements ActionListener {
//public class Customer extends JPanel implements ActionListener {
	static JButton btnSettings, btnGeneral, btnMailbox, 
				   btnBill, btnHistory, btnBack,
				   btnEdit, btnHelp, btnTerms,
				   btnRate, btnPrivacy,
				   btnContact, btnReward, btnLogout,
				   btnStatus, btnPlace, btnActivity,
				   btnPhone, btnModify, btnReport,
				   btnAbout, btnChangePassword, btnDelete;
	JFrame //frame, 
	settingFrame, helpFrame,
		   activityFrame, passwordFrame,
		   mailFrame, editFrame;
	JTextField textArea, currentText, newText,
			   nameText, addressText, phoneText,
		       confirmText;
	private JLabel password, errorMessage,
				   title, phoneLabel, addressLabel,
				   reward,address, phone, name;

	public Customer() {
		CustomerComponent();
	}
	
	public static int getCusNo() {
		return cusNo;
	}
	
	public static String getCusPhone() {
		return cusPhone;
	}
	
	public static String getCusAddress() {
		return cusAddress;
	}

	public void CustomerComponent() {
/*		frame = new JFrame("Customer");
		frame.setBounds(120, 70, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);*/
		setLayout(null);

		//frame.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		Icon iconActivity = new ImageIcon("D:\\btnActivity.png");
		Icon iconMail = new ImageIcon("D:\\btnMail.png");
		Icon iconHelp = new ImageIcon("D:\\btnHelp.png");
		Icon iconSettings = new ImageIcon("D:\\btnCusSetting.png");
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\CustomerPanel.png"));
		lblNewLabel_4.setBounds(0, 0, 1200, 575);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel account = new JPanel();
		account.setBounds(5, 160, 530, 150);
		account.setLayout(null);
		account.setVisible(true);


		title = new JLabel("Profile");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(500, 80);
		title.setLocation(525, 25);


		JLabel phoneLabel = new JLabel("Phone number");
		phoneLabel.setFont(new Font("Cooper Black", Font.BOLD, 17));
		phoneLabel.setSize(150, 50);
		phoneLabel.setLocation(20, 175);
		frame.add(phoneLabel);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Cooper Black", Font.BOLD, 17));
		addressLabel.setSize(120, 50);
		addressLabel.setLocation(20, 215);
		frame.add(addressLabel);

		reward = new JLabel("rewards");
		reward.setFont(new Font("Arial", Font.PLAIN, 20));
		reward.setSize(200, 80);
		reward.setLocation(35, 240);


		cusName.setFont(new Font("Cooper Black", Font.BOLD, 20));
		cusName.setSize(500, 50);
		cusName.setLocation(10, 80);

		email.setFont(new Font("Cooper Black", Font.BOLD, 15));
		email.setSize(500, 40);
		email.setLocation(10, 110);		


		btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 70, 25);
		btnBack.addActionListener(this);

		btnSettings = new JButton(iconSettings);
		btnSettings.setBounds(1085, 10, 50, 50);
		btnSettings.addActionListener(this);

		btnHelp = new JButton(iconHelp);
		btnHelp.setBounds(1020, 10, 50, 50);
		btnHelp.addActionListener(this);

		btnMailbox = new JButton(iconMail);
		btnMailbox.setBounds(955, 10, 50, 50);
		btnMailbox.addActionListener(this);

		btnActivity = new JButton(iconActivity);
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

		displayProfile();
		add(title);
		add(reward);
		add(cusName);
		add(email);

		add(btnBack);
		add(btnSettings);
		add(btnEdit);
		add(btnActivity);

		add(btnMailbox);

		add(btnHelp);
		add(btnRate);

		add(btnReward);
		add(btnLogout);
		add(btnModify);


		//frame.getContentPane().
		add(account);
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
	
	public static void activity() {
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
		btnHistory.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	OrderHistory o = new OrderHistory();
		    	o.orderScreen();
		    	activityFrame.dispose();
//		    	RestaurantTable rt = new RestaurantTable();
//		    	rt.orderScreen();
//		    	
//		    	FoodTable f = new FoodTable();
//		    	f.orderScreen();
		    	
//		    	MenuImage m;
//				try {
//					m = new MenuImage();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//		    	MenuImage.orderScreen();
		    	
		    }});
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
		
		currentText = new JPasswordField();
		currentText.setBounds(160, 10, 300, 20);
		passwordFrame.add(currentText);
		
		JLabel newPassword = new JLabel("New Password");
		newPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		newPassword.setBounds(10, 40, 100, 15);
		passwordFrame.add(newPassword);	
		
		newText = new JPasswordField();
		newText.setBounds(160, 40, 300, 20);
		passwordFrame.add(newText);
		
		JLabel confirm = new JLabel("Confirm Password");
		confirm.setFont(new Font("Arial", Font.PLAIN, 15));
		confirm.setBounds(10, 70, 135, 15);
		passwordFrame.add(confirm);	
		
		confirmText = new JPasswordField();
		confirmText.setBounds(160, 70, 300, 20);
		passwordFrame.add(confirmText);
		
		errorMessage = new JLabel();
		errorMessage.setFont(new Font("Arial", Font.BOLD, 15));
		errorMessage.setSize(250, 50);
		errorMessage.setLocation(140, 100);
		passwordFrame.add(errorMessage);
		
		btnChangePassword = new JButton("Change");
		btnChangePassword.setBounds(140,140, 90, 25);
		btnChangePassword.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	//passwordFrame.setVisible(false);
		    	try {	
					changePassword();
					JOptionPane.showMessageDialog(null, "Saved");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }});
		passwordFrame.add(btnChangePassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(260,140, 90, 25);
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	passwordFrame.dispose();
		    }});
		passwordFrame.add(btnBack);
	}
	
	public void displayProfile(){
		Connection connection = null;
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query1 = "SELECT * FROM Customer WHERE CusNo = (SELECT C.CusNo"
																+ " FROM Customer C, Users U"
																+ " WHERE U.Username = '" + SignInPanel.getUsername()
																+ "' AND U.UserID = C.UserID)";
			System.out.println(query1);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
		
			while (rs.next()) {
				int id = rs.getInt("CusNo");	
				String nameText = rs.getString("CusName");	
				String phoneText = rs.getString("CusPhone");
				String addressText = rs.getString("CusAddress");
				
				
				cusNo = id;
				cusAddress = addressText;
				cusPhone = phoneText;
				System.out.println(getCusNo());
				name = new JLabel(nameText);
				name.setFont(new Font("Cooper Black", Font.BOLD, 20));
				name.setSize(500, 50);
				name.setLocation(10, 80);
				frame.add(name);
				 
				phone = new JLabel(phoneText);
				phone.setFont(new Font("Arial", Font.PLAIN, 20));
				phone.setSize(200, 80);
				phone.setLocation(400, 160);
				frame.add(phone);
				
				address = new JLabel(addressText);
				address.setFont(new Font("Arial", Font.PLAIN, 20));
				address.setSize(200, 80);
				address.setLocation(400, 200);	
				frame.add(address);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		}
	
	public void changePassword() throws Exception {
		char[] oldPassword = currentText.getPassword();
		char[] newPassword = newText.getPassword();
		char[] confirmPassword = confirmText.getPassword();
		
    	String old = new String(oldPassword);
    	String neww = new String(newPassword);
    	String confirm = new String(confirmPassword);
    	
    	if ((old.length() == 0) || (neww.length() == 0) || (confirm.length() == 0))
    		errorMessage.setText("Please, fulfill the information");
    	if ((old.length() == 0) && (neww.length() == 0) )
		errorMessage.setText("Please, fulfill the information");
    	if ((old.length() == 0) && (confirm.length() == 0) )
    	errorMessage.setText("Please, fulfill the information");
    	if ((neww.length() == 0) && (confirm.length() == 0) )
        	errorMessage.setText("Please, fulfill the information");
		if ((old.length() != 0) && (neww.length() != 0) && (confirm.length() != 0)) {
			char[] currentpassword = currentText.getPassword();
			String cPassword = "";
			for (int i = 0; i < currentpassword.length; i++) {
				cPassword += currentpassword[i];
			}
			
			char[] newpassword = newText.getPassword();
			String nPassword = "";
			for (int i = 0; i < newpassword.length; i++) {
				nPassword += newpassword[i];
			}
			char[] confirmpassword = newText.getPassword();
			String cfPassword = "";
			for (int i = 0; i < confirmpassword.length; i++) {
				cfPassword += confirmpassword[i];
			}
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
				connection = DriverManager.getConnection(connectionURL, "sa","hai01256445678");
				System.out.println("Success");
				if ((JavaConnect2Sql.searchInfo(SignInPanel.getUsername(), cPassword) == true) 
						&&  nPassword.equals(cfPassword) == true) {
					System.out.println(SignInPanel.getUsername());
					PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("UPDATE Users set Password= ? where Username='" + SignInPanel.getUsername()+"'");
					st.setString(1, cfPassword);
                    st.executeUpdate();
                    System.out.println("Saved");
				} else {
					System.out.println("Failed");
				}
			} catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
		}
		
			
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
		
		JLabel name = new JLabel("name");
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
		    	try {
					editProfile();
					JOptionPane.showMessageDialog(null, "Saved");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		    });
		JButton btnOK = new JButton("OK");
		btnOK.setBounds(315, 200, 150, 25);
		editFrame.add(btnOK);
		btnOK.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	editFrame.dispose();
		    }
		    });
	}
	
	public void editProfile() throws Exception {
		String phoneNo = phoneText.getText();
		String addr = addressText.getText();
		String cusName = nameText.getText();
		 	

		if ((phoneNo.length() != 0) && (addr.length() != 0) && (cusName.length() != 0)) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
				connection = DriverManager.getConnection(connectionURL, "sa","hai01256445678");

					System.out.println(SignInPanel.getUsername());
					PreparedStatement st1 = (PreparedStatement) connection
	                        .prepareStatement("UPDATE Customer set CusName= ? where CusNo= (SELECT C.CusNo"
	                        																+" FROM Customer C, Users U"
	                        																+" WHERE U.Username ='"  + SignInPanel.getUsername() + "'"
	                        																+" AND U.UserID = C.UserID)");
	                        	
					st1.setString(1, cusName);
                    st1.executeUpdate();
                    
                    PreparedStatement st2 = (PreparedStatement) connection
	                        .prepareStatement("UPDATE Customer set CusPhone= ? where CusNo= (SELECT C.CusNo"
	                        																+" FROM Customer C, Users U"
	                        																+" WHERE U.Username ='"  + SignInPanel.getUsername() + "'"
	                        																+" AND C.UserID = U.UserID)");
                	st2.setString(1, phoneNo);
                    st2.executeUpdate();
                    
                    PreparedStatement st3 = (PreparedStatement) connection
	                        .prepareStatement("UPDATE Customer set CusAddress= ? where CusNo= (SELECT C.CusNo"
	                        																+" FROM Customer C, Users U"
	                        																+" WHERE U.Username ='"  + SignInPanel.getUsername() + "'"
	                        																+" AND C.UserID = U.UserID)");
                    st3.setString(1, addr);
                    st3.executeUpdate();                
                    System.out.println("Saved");
				  
				}
			 catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
		} 
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
