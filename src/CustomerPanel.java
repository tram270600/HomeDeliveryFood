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
	private JDialog jDialog1, jDialog2;
	private static JDialog jDialogSaved, stajDialog;
	private int rewardPoints;
	static JTable jTableStatus, jTableSave;

	public CustomerPanel() {
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
		btnPlace.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	activityFrame.dispose();
		    	savedPlace();
		    	showSavedPlace();
			jDialogSaved.setVisible(true);
		    }});
		activityFrame.add(btnPlace);
		
		btnHistory = new JButton("Order history");
		btnHistory.setBounds(180, 40, 130, 25);
		btnHistory.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		    	OrderHistory o = new OrderHistory();
		    	o.orderScreen();
		    	activityFrame.dispose();	    	
		    }});
		activityFrame.add(btnHistory);
		
		btnStatus = new JButton("Delivery status");
		btnStatus.setBounds(180, 90, 130, 25);
		btnStatus.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	activityFrame.dispose();
		    	deliStatus();
		    	showStatus();
			stajDialog.setVisible(true);
		    }});
		activityFrame.add(btnStatus);
	}
	
	public void password() {
		jDialog2 = new javax.swing.JDialog();
		jDialog2.setLocation(500, 200);
		
        	JLabel jLabel1 = new javax.swing.JLabel("Current Password");
        	JLabel jLabel2 = new javax.swing.JLabel("New Password");
        	JLabel jLabel3 = new javax.swing.JLabel("Confirm Password");
        
        	currentText = new JPasswordField();
        	newText = new JPasswordField();
        	confirmText = new JPasswordField();
        
        	JButton jButton1 = new javax.swing.JButton("Change");
        	jButton1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	char[] oldPassword = currentText.getPassword();
			char[] newPassword = newText.getPassword();
			char[] confirmPassword = confirmText.getPassword();
				
		    	String old = new String(oldPassword);
		    	String neww = new String(newPassword);
		    	String confirm = new String(confirmPassword);
		        
		    	System.out.println("Old is" + old);
		    	System.out.println("neww is" + neww);
		    	System.out.println("confirm is" + confirm);
		    	
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
				char[] confirmpassword = confirmText.getPassword();
				String cfPassword = "";
				for (int i = 0; i < confirmpassword.length; i++) {
					cfPassword += confirmpassword[i];
					}
				System.out.println(nPassword);
				System.out.println(cfPassword);
					try {
						try {
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
						connection = DriverManager.getConnection(connectionURL, "sa","hai01256445678");
						System.out.println("Success");
						try {
							if ((JavaConnect2Sql.searchInfo(SignInPanel.getUsername(), cPassword) == true) &&  nPassword.equals(cfPassword) == true) {
								System.out.println(nPassword.equals(cfPassword));
								System.out.println("n" +nPassword);
								System.out.println("cf" +cfPassword);
								PreparedStatement st = (PreparedStatement) connection
							            .prepareStatement("UPDATE Users set Password= ? where Username='" 
							            		         + SignInPanel.getUsername()+"'");
								st.setString(1, cfPassword);
							    st.executeUpdate();
							    JOptionPane.showMessageDialog(null, "Saved");
							} else {
								JOptionPane.showMessageDialog(null, "Please try again");
							}
						} catch (HeadlessException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} catch (SQLException sqlException) {
		                sqlException.printStackTrace();
		            }
		    	} else
		    		JOptionPane.showMessageDialog(null, "Please fill in the blank");
		    }
		    });
        JButton jButton2 = new JButton("Ok");
        jButton2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	jDialog2.setVisible(false);
		    }
		    });
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentText)
                            .addComponent(newText)
                            .addComponent(confirmText, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jDialog2.pack();
        jDialog2.setModal(true);
        jDialog2.setVisible(true);
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
	jDialog1 = new javax.swing.JDialog();
	jDialog1.setLocation(500, 200);
		
        JLabel jLabel1 = new javax.swing.JLabel("Phone");
        JLabel jLabel2 = new javax.swing.JLabel("Address");
        JLabel jLabel3 = new javax.swing.JLabel("Name");
        
        phoneText = new javax.swing.JTextField();
        addressText = new javax.swing.JTextField();
        nameText = new javax.swing.JTextField();
        
        JButton jButton1 = new javax.swing.JButton("Change");
        jButton1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	if ((phoneText.getText() != "") || (addressText.getText() != "") || (nameText.getText() != ""))
					JOptionPane.showMessageDialog(null, "Please fulfill the information");
		    	else {
		    	try {
					editProfile();
					JOptionPane.showMessageDialog(null, "Saved");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		    }
		    }
		    });
        JButton jButton2 = new JButton("Ok");
        jButton2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {	
		    	jDialog1.setVisible(false);
		    }
		    });
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneText)
                            .addComponent(addressText)
                            .addComponent(nameText, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jDialog1.pack();
        jDialog1.setModal(true);
        jDialog1.setVisible(true);
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
	public static void deliStatus() {
	stajDialog = new javax.swing.JDialog();
	stajDialog.setLocation(400, 200);
		
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTableStatus = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();

        jTableStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ServerID", "OrderID", "ResNo", "CusNo", "ShipNo", "Order Price", "Order Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableStatus);
        if (jTableStatus.getColumnModel().getColumnCount() > 0) {
        	jTableStatus.getColumnModel().getColumn(0).setResizable(false);
        	jTableStatus.getColumnModel().getColumn(1).setResizable(false);
        	jTableStatus.getColumnModel().getColumn(2).setResizable(false);
        	jTableStatus.getColumnModel().getColumn(3).setResizable(false);
        	jTableStatus.getColumnModel().getColumn(4).setResizable(false);
        	jTableStatus.getColumnModel().getColumn(5).setResizable(false);
        	jTableStatus.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	stajDialog.setVisible(false);
            	activity();
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(stajDialog.getContentPane());
        stajDialog.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );


        stajDialog.pack();
        stajDialog.setModal(true);
	}
	
	public static void savedPlace() {
	jDialogSaved = new javax.swing.JDialog();
	jDialogSaved.setLocation(450, 200);
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jTableSave = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();

        jTableSave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Restaurant Name", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableSave);
        if (jTableSave.getColumnModel().getColumnCount() > 0) {
        	jTableSave.getColumnModel().getColumn(0).setResizable(false);
        	jTableSave.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jDialog.setVisible(false);
            	activity();
            }
        });
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialogSaved.getContentPane());
        jDialogSaved.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );


        jDialogSaved.pack();
        jDialogSaved.setModal(true);
	}
	
	public static void showSavedPlace() {
		DefaultTableModel model = (DefaultTableModel) jTableSave.getModel();
		Object[] row = new Object[2];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query = "select R.ResName, Ra.Address " + 
							"from Orders O1 Join Orders O2 " + 
							"ON O1.ResNo = O2.ResNo AND O1.CusNo = O2.CusNo AND O1.CusNo = (SELECT C.CusNo " + 
																							" FROM Customer C, Users U" + 
																							" WHERE U.Username = '" + SignInPanel.getUsername() + 
																							"' AND U.UserID = C.UserID)" + 
							"Join Restaurant R " + 
							"ON O1.ResNo = R.ResNo " + 
							"Join ResAddress Ra " + 
							"On Ra.ResNo = R.ResNo " + 
							"group by R.ResName, Ra.Address " + 
							"having count(*) > 2";
			System.out.println(query);		
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				row[0] = rs.getString("ResName");	
				row[1] = rs.getString("Address");
				model.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void showStatus() {
		
		DefaultTableModel model = (DefaultTableModel) jTableStatus.getModel();
		Object[] row = new Object[7];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query = "SELECT * FROM Orders WHERE OrderStatus = 'On Delivery' AND CusNo = (SELECT C.CusNo"
																								+ " FROM Customer C, Users U"
																								+ " WHERE U.Username = '" + SignInPanel.getUsername()
																								+ "' AND U.UserID = C.UserID)";
			System.out.println(query);		
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				row[0] = rs.getString("ServerID");	
				row[1] = rs.getString("OrderID");
				row[2] = rs.getString("ResNo");	
				row[3] = rs.getInt("CusNo");
				row[4] = rs.getInt("ShipNo");	
				row[5] = rs.getString("OrderPrice");
				row[6] = rs.getString("OrderStatus");	
				model.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
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
			try {
				password();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
		if (e.getSource() == btnMailbox) {			
			mailbox();
		}
		if (e.getSource() == btnEdit) {	

			edit();
		}
	}

}
