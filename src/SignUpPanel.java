import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



	public class SignUpPanel extends JPanel implements ActionListener {
		private BufferedImage backGroundMenu;
		static JButton btnRes, btnCus, btnShip;
		public RegisterPanel registerPanel;
		public SignUpPanel(){
			btnRes = new JButton(new ImageIcon("ImageSource\\btnRestaurant.png"));
		    btnCus = new JButton(new ImageIcon("ImageSource\\btnCustomer.png"));
//		    btnCus = new JButton();
		    btnShip = new JButton(new ImageIcon("ImageSource\\btnShipper.png"));
		     setLayout(null);
		     btnRes.setVisible(true);
		     btnCus.setVisible(true);

		     btnRes.setBounds(465,462,260,90);  
		     btnCus.setBounds(850,458,260,90);
		     btnShip.setBounds(90,458,260,90);
		     
		    btnRes.addActionListener(this);
		    btnShip.addActionListener(this);
		    btnCus.addActionListener(this);
			 
		    
		     
		     this.add(btnRes);
		     this.add(btnCus);
		     this.add(btnShip);
		}
			

		public void paint(Graphics g) { 
			  try {backGroundMenu = ImageIO.read(new File("ImageSource\\chooseyourrole.png"));
				   g.drawImage(backGroundMenu,0 ,0, null);} 
			  catch (IOException e) {e.printStackTrace();}}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 
			if(e.getSource() == btnRes) {
				registerPanel = new RegisterPanel(2);
				MainFrame.callSetPanel(registerPanel);
				
				}
			if(e.getSource() == btnShip) {
				registerPanel = new RegisterPanel(1);
				MainFrame.callSetPanel(registerPanel);
				}
			if(e.getSource() == btnCus) {
				registerPanel = new RegisterPanel(3);
				MainFrame.callSetPanel(registerPanel);
				}
	}
}
