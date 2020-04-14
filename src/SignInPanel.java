import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignInPanel extends JPanel implements ActionListener {
	RestaurantPanel res;
	ShipperPanel shipper;
	CustomerPanel customer;
	
	private BufferedImage backGroundMenu;
	private JLabel username;
	private JTextField tusername;
	private JButton btnlogin;
	
	private JLabel password, mess;
	public JLabel getMess() {
		return mess;
	}

	public void setMess(JLabel mess) {
		this.mess = mess;
	}
	private JPasswordField passwordhide;
	public SignInPanel(){
		setLayout(null);
		username = new JLabel("Username"); 
		username.setFont(new Font("Arial", Font.PLAIN, 20)); 
		username.setSize(100, 20); 
		username.setLocation(380, 250); 
	    add(username);
	 
	    tusername = new JTextField(); 
	    tusername.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    tusername.setSize(190, 20); 
	    tusername.setLocation(480, 250); 		
	    add(tusername);
	    
	    password = new JLabel("Password"); 
	    password.setFont(new Font("Arial", Font.PLAIN, 20)); 
	    password.setSize(100, 20); 
	    password.setLocation(380, 300); 
	    add(password);
	    
	    passwordhide = new JPasswordField();
	    passwordhide.setSize(190, 20); 
	    passwordhide.setLocation(480, 300); 
	    passwordhide.setEchoChar('*');
	    add(passwordhide);
	    
	    btnlogin = new JButton("Log In"); 
	    btnlogin.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    btnlogin.setSize(100, 20); 
	    btnlogin.setLocation(570, 350); 
	    btnlogin.addActionListener(this); 
	       add(btnlogin); 
	       
	    mess = new JLabel(""); 
	    mess.setFont(new Font("Arial", Font.BOLD, 15)); 
	    mess.setSize(500, 25); 
	    mess.setLocation(380, 400); 
	    add(mess); 
			
}
/*		public void paint(Graphics g) { 
			  try {backGroundMenu = ImageIO.read(new File("ImageSource\\chooseyourrole.png"));
				   g.drawImage(backGroundMenu,0 ,0, null);} 
			  catch (IOException e) {e.printStackTrace();}}
*/
		
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {backGroundMenu = ImageIO.read(new File("ImageSource\\LogIn.png"));
		   g.drawImage(backGroundMenu,0 ,0, null);} 
	  catch (IOException e) {e.printStackTrace();}
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btnlogin) { 
				char[] input = passwordhide.getPassword();
				String pass = new String(input);
				String user = tusername.getText();
				if((pass.length()==0)||(user.equals(""))) mess.setText("Please, enter the username or password");
				if((pass.length()==0)&&(user.equals(""))) mess.setText("Please, enter the username and password");
				if((pass.length()!=0)&&(!user.equals(""))) {
				
				mess.setText("Wait for checking...");

				char[] password = passwordhide.getPassword();
				String passWord = "";
				for (int i = 0; i < password.length; i++) {
					passWord += password[i];
				}
				System.out.println(passWord);

				try {
					System.out.println("Doing searching");
//					JavaConnect2SQL.searchInfo(tusername.getText(), passWord);
///*
 					if (JavaConnect2SQL.searchInfo(tusername.getText(), passWord) == true)
						mess.setText("Login Success");
					else
						mess.setText("Wrong username or password, try again");//*/
				} catch (Exception e1) {
					System.out.println("Cannot search");
					e1.printStackTrace();
				}
			createAccountPanel();}
		}
			
			
	}
		public void createAccountPanel() {
			System.out.println("Creating");
			System.out.println(JavaConnect2SQL.getInfoType());
			if(JavaConnect2SQL.getInfoType().equals("Restaurant")) {
				res = new RestaurantPanel(JavaConnect2SQL.infoName, JavaConnect2SQL.infoAddress);
				MainFrame.callSetPanel(res);
			}
			if(JavaConnect2SQL.getInfoType().equals("Customer")) {
				customer = new CustomerPanel();
				MainFrame.callSetPanel(customer);
			}
			if(JavaConnect2SQL.getInfoType().equals("Shipper")) {
				shipper = new ShipperPanel();
				MainFrame.callSetPanel(shipper);
			}
		}
}
