import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LogInPanel extends JPanel implements ActionListener {
	private BufferedImage backGroundMenu;
	static JButton btnSignIn, btnSignUp;
	SignUpPanel signUp = new SignUpPanel();
	public SignInPanel getSignIn() {
		return signIn;
	}
	public void setSignIn(SignInPanel signIn) {
		this.signIn = signIn;
	}

	static SignInPanel signIn = new SignInPanel();
	public LogInPanel(){
		
		btnSignIn = new JButton(new ImageIcon("ImageSource\\signin.png"));
	    btnSignUp = new JButton(new ImageIcon("ImageSource\\signup.png"));
	     setLayout(null);
	     btnSignIn.setBounds(450,200,228,114);  
	     btnSignUp.setBounds(450,350, 228, 114);
	     
	    btnSignUp.addActionListener(this);
	    btnSignIn.addActionListener(this);
		 
	     btnSignIn.setVisible(true);
	     btnSignUp.setVisible(true);
	     
	     this.add(btnSignUp);
	     this.add(btnSignIn);
    }
	public void paint(Graphics g) { 
		  try {backGroundMenu = ImageIO.read(new File("ImageSource\\LogInPanel.png"));
			   g.drawImage(backGroundMenu,0 ,0, null);} 
		  catch (IOException e) {e.printStackTrace();}}
	
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getSource() == btnSignIn) {
			System.out.println("Sign In");
			MainFrame.callSetPanel(signIn);
			
			}
		if(e.getSource() == btnSignUp) {
			System.out.println("Sign up");
			MainFrame.callSetPanel(signUp);
			}
		
		
}
}
