import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;

public class ShipperPanel extends JPanel implements ActionListener {
	private JLabel name;
	private JLabel phone, genderLabel, dobLabel, addressLabel;
	private JFrame frame, passwordframe;
	private JButton btnRating,btnOrder,btnHistory;
	private JPanel Profile;
	private JLabel errorMessage;
	private JPasswordField passwordField,passwordField_1,passwordField_2;


		

	public ShipperPanel(String name, String phone) {
		this.name = new JLabel(name);
		this.phone = new JLabel(phone);
		ShipperPanelComponent();
	}

	
	public void ShipperPanelComponent() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//password frame
		passwordframe = new JFrame();
		passwordframe.setBounds(200, 300, 500, 300);
		passwordframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		passwordframe.getContentPane().setLayout(null);
		passwordframe.setVisible(false);
		
		//add components into password frame
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 66, 214, 22);
		passwordframe.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(178, 101, 214, 22);
		passwordframe.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(178, 136, 214, 22);
		passwordframe.getContentPane().add(passwordField_2);
		
		JLabel current = new JLabel("Current Password");
		current.setBounds(38, 69, 128, 16);
		passwordframe.getContentPane().add(current);
		
		errorMessage = new JLabel();
		errorMessage.setBounds(188, 166, 56, 16);
		passwordframe.getContentPane().add(errorMessage);
		
		JLabel newpass = new JLabel("New Password");
		newpass.setBounds(48, 104, 96, 16);
		passwordframe.getContentPane().add(newpass);
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(165, 185, 97, 25);
		passwordframe.getContentPane().add(btnDone);
		
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setVisible(false);
		layeredPane.setBounds(119, 92, 893, 427);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
	
		//add components to HIstory panel
		JPanel TransactionHistory = new JPanel();
		layeredPane.add(TransactionHistory);
		TransactionHistory.setLayout(null);
		TransactionHistory.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("History");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(269, 13, 137, 97);
		TransactionHistory.add(lblNewLabel);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(12, 86, 881, 328);
		TransactionHistory.add(textArea_1);
		
		//add components to Order panel
		JPanel Order = new JPanel();
		layeredPane.add(Order);
		Order.setVisible(false);
		Order.setLayout(null);
		
		JLabel reAdd = new JLabel("Receiving Address");
		reAdd.setBounds(22, 0, 322, 563);
		reAdd.setHorizontalAlignment(SwingConstants.CENTER);
		reAdd.setVerticalAlignment(SwingConstants.TOP);
		reAdd.setFont(new Font("Castellar", Font.PLAIN, 18));
		Order.add(reAdd);
		
		JLabel deliAdd = new JLabel("Delivery Address");
		deliAdd.setBounds(437, 0, 303, 553);
		deliAdd.setVerticalAlignment(SwingConstants.TOP);
		deliAdd.setHorizontalAlignment(SwingConstants.CENTER);
		deliAdd.setFont(new Font("Castellar", Font.PLAIN, 18));
		Order.add(deliAdd);
		
		JTextArea ReAddress = new JTextArea();
		ReAddress.setBounds(12, 38, 332, 515);
		Order.add(ReAddress);
		
		JTextArea DeAddress = new JTextArea();
		DeAddress.setBounds(437, 38, 332, 515);
		Order.add(DeAddress);
		
		//add components to rating panel
		JPanel Rating = new JPanel();
		layeredPane.add(Rating, "name_1060048078321400");
		Rating.setLayout(null);
		Rating.setVisible(false);
		
		
		JCheckBox vbad = new JCheckBox("Very Bad");
		vbad.setBounds(78, 49, 95, 21);
		Rating.add(vbad);
		
		
		JCheckBox bad = new JCheckBox("Bad");
		bad.setBounds(78, 78, 95, 21);
		Rating.add(bad);
		
		
		JCheckBox normal = new JCheckBox("Normal");
		normal.setBounds(78, 109, 95, 21);
		Rating.add(normal);
		
		
		JCheckBox good = new JCheckBox("Good");
		good.setBounds(78, 138, 95, 21);
		Rating.add(good);
		
		
		JCheckBox vgood = new JCheckBox("Very Good");
		vgood.setBounds(78, 170, 95, 21);
		Rating.add(vgood);
		
	
		vgood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vbad.setSelected(false);
				bad.setSelected(false);
				normal.setSelected(false);
				good.setSelected(false);
				vgood.setSelected(true);
			}
		});
		
		bad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vbad.setSelected(false);
				bad.setSelected(true);
				normal.setSelected(false);
				good.setSelected(false);
				vgood.setSelected(false);
			}
		});
		
		vbad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vbad.setSelected(true);
				bad.setSelected(false);
				normal.setSelected(false);
				good.setSelected(false);
				vgood.setSelected(false);
			}
		});
		
		good.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vbad.setSelected(false);
				bad.setSelected(false);
				normal.setSelected(false);
				good.setSelected(true);
				vgood.setSelected(false);
				
			}
		});
		
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vbad.setSelected(false);
				bad.setSelected(false);
				normal.setSelected(true);
				good.setSelected(false);
				vgood.setSelected(false);
			}
		});
		
		JEditorPane comment = new JEditorPane();
		comment.setFont(new Font("SansSerif", Font.PLAIN, 14));
		comment.setText("Comments");
		comment.setBounds(405, 49, 473, 142);
		Rating.add(comment);
		
		
		//add components to Profile panel
		Profile = new JPanel();
		layeredPane.add(Profile, "name_952108973165600");
		Profile.setLayout(null);
		Profile.setVisible(false);
		
		name.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
	    name.setSize(500, 50); 
	    name.setLocation(100,20); 
	    Profile.add(name);
	    
	    phone.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
	    phone.setSize(500, 50); 
	    phone.setLocation(100,60); 
	    Profile.add(phone);
	    
		
		JLabel lblNewLabel_1 = new JLabel("Profile");
		lblNewLabel_1.setBounds(122, 37, 87, 16);
		Profile.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 79, 292, 457);
		Profile.add(textArea);
		
		JButton btnEditProfile = new JButton("EditProfile");
		btnEditProfile.setBounds(410, 120, 140, 25);
		Profile.add(btnEditProfile);
		
		JButton btnChangePassword = new JButton("ChangePassword");
		btnChangePassword.setBounds(410, 78, 140, 25);
		Profile.add(btnChangePassword);
		
		JToggleButton btnStatus = new JToggleButton("Available");
		btnStatus.setToolTipText("");
		btnStatus.setBounds(615, 79, 137, 67);
		Profile.add(btnStatus);
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnStatus.isSelected()) {
				btnStatus.setText("Busy");
			}
				else
				btnStatus.setText("Available");
			}
		});
		
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordframe.setVisible(true);
			}
		});
		
		
		
		JButton btnHistory = new JButton();
		btnHistory.setIcon(new ImageIcon("D:\\ImageSource\\btntransactionHistory.png"));
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				Order.setVisible(false);
				TransactionHistory.setVisible(true);
				Rating.setVisible(false);
				Profile.setVisible(false);
			}
		});
		btnHistory.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnHistory.setBounds(934, 0, 50, 50);
		frame.getContentPane().add(btnHistory);
		
		
		JButton btnOrder = new JButton();
		btnOrder.setIcon(new ImageIcon("D:\\ImageSource\\btnShipOrder.png"));
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				Order.setVisible(true);
				TransactionHistory.setVisible(false);
				Rating.setVisible(false);
				Profile.setVisible(false);
			}
		});
		btnOrder.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnOrder.setBounds(749, 0, 50, 50);
		frame.getContentPane().add(btnOrder);
		
		JButton btnRating = new JButton("Rating ");
		btnRating.setIcon(new ImageIcon("D:\\ImageSource\\btnRating.png"));
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.setVisible(true);
				Order.setVisible(false);
				TransactionHistory.setVisible(false);
				Rating.setVisible(true);
				Profile.setVisible(false);
				
			}
		});
		btnRating.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnRating.setBounds(872, 0, 50, 50);
		frame.getContentPane().add(btnRating);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setIcon(new ImageIcon("D:\\ImageSource\\btnProfile.png"));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				layeredPane.setVisible(true);
				Order.setVisible(false);
				TransactionHistory.setVisible(false);
				Rating.setVisible(false);
				Profile.setVisible(true);
			}
		});
		btnProfile.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnProfile.setBounds(812, 0, 50, 50);
		frame.getContentPane().add(btnProfile);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\ImageSource\\ShipperPanel.png"));
		lblNewLabel_2.setBounds(0, 0, 1182, 553);
		frame.getContentPane().add(lblNewLabel_2);
	}
	public void changePassword(String name) throws Exception {
		char[] oldPassword = passwordField.getPassword();
		char[] newPassword = passwordField_1.getPassword();
		char[] confirmPassword = passwordField_2.getPassword();
    	String old = new String(oldPassword);
    	String neww = new String(newPassword);
    	String confirm = new String(confirmPassword);
    	String userName = name;
    	if ((old.length() == 0))
    		errorMessage.setText("Please, enter the current password");
		if ((old.length() == 0) && (neww.length() == 0))
			errorMessage.setText("Please, enter the current and new password");
		if ((confirm.length() == 0))
			errorMessage.setText("Please, confirm the new password");
		if ((old.length() != 0) && (neww.length() != 0) && (confirm.length() != 0)) {
			char[] currentpassword = passwordField.getPassword();
			String cPassword = "";
			for (int i = 0; i < currentpassword.length; i++) {
				cPassword += currentpassword[i];
			}
			char[] newpassword = passwordField_1.getPassword();
			String nPassword = "";
			for (int i = 0; i < newpassword.length; i++) {
				nPassword += newpassword[i];
			}
			char[] confirmpassword = passwordField_1.getPassword();
			String cfPassword = "";
			for (int i = 0; i < confirmpassword.length; i++) {
				cfPassword += confirmpassword[i];
			}
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connectionURL = "jdbc:sqlserver://DESKTOP-1TFES8J:1433;databaseName=MidTerm;integratedSecurity=true";
				Connection connection = DriverManager.getConnection(connectionURL, "sa","leanhkhoa1602");
				System.out.println("Success");
				if ((JavaConnect2SQL.searchInfo(name, cPassword) == true) &&  nPassword.equals(cfPassword) == true) {
					PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("UPDATE Shipper set Password= ? where Username='" + SignInPanel.getUsername()+"'");
					st.setString(1, cfPassword);
                    st.executeUpdate();
				}
			} catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
		}
	}
	public void displayShipper(){
		Connection connection = null;
	    add(name);
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-1TFES8J:1433;databaseName=MidTerm;integratedSecurity=true";
			connection = DriverManager.getConnection(connectionURL, "sa", "leanhkhoa1602");
			String query1 = "SELECT * FROM Shipper WHERE ShipNo = (SELECT S.ShipNo"
															+ " FROM Shipper S, Users U"
															+ " WHERE U.Username = '" + SignInPanel.getUsername()
															+ "' AND U.UserID = S.UserID)";
			System.out.println(query1);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
		
			while (rs.next()) {
				String id = rs.getString("ShipNo");	
				String gender = rs.getString("ShipGender");
				String dob = rs.getString("ShipDoB");
				String address = rs.getString("ShipAddress");
				
				genderLabel = new JLabel(gender);
				genderLabel.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
				genderLabel.setSize(500, 50); 
				genderLabel.setLocation(100,80); 
			    Profile.add(name);
			    
			    dobLabel = new JLabel(dob);
			    dobLabel.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
			    dobLabel.setSize(500, 50); 
			    dobLabel.setLocation(100,110); 
			    Profile.add(dobLabel);
			    
			    addressLabel = new JLabel(address);
			    addressLabel.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
			    addressLabel.setSize(500, 50); 
			    addressLabel.setLocation(100,140); 
			    Profile.add(addressLabel);	
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
