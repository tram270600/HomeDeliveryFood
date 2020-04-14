import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class RestaurantPanel extends JPanel implements ActionListener{
	private BufferedImage backGroundMenu;
	static JButton btnmessage, btnsetting, btnaddMenu, btnaddEvent;
	private JLabel name, openinghour, address, menu, event;
	private JTextArea tmenu, tevent;
	private JScrollPane textScroller;
	PopupFactory pf;
//	Popup p;
	Popup po;
	JLabel popUpTitle;
	JPanel popUpPanel;
	JButton btnAddToMenu;
	private JComboBox category, noption, nchoice; 
	private JTextArea toption, tchoice;
	
	private String noptions[] = {"1","2","3","4","5"}, nchoices[]=  {"1","2","3","4","5"};
	private String categorys[] = {"Barbecue", "Chicken", "Drinks and Bevarages", "Dessert", "Hot-pot",  "Milktea", "Noodle/Soup", "Seafood", "Snacks", "Vegetable","Vegetarian food"};
	private JLabel nameFood, price, description, option, choice, categoryl;
	private JTextField tnameFood, tprice, tdescription;

	public RestaurantPanel(String name, String address) {
		this.name = new JLabel(name);
		this.address = new JLabel(address);
		RestaurantPanelComponent();
	}
	public void RestaurantPanelComponent() {
		int y = 10;
		setLayout(null);
	
		tmenu = new JTextArea();
		tmenu.setFont(new Font("Arial", Font.PLAIN, 15)); 
//	    tmenu.setSize(200, 100); 
//	    tmenu.setLocation(300, 285); 
	    tmenu.setLineWrap(true); 
	      
		textScroller = new JScrollPane(tmenu);
	    textScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textScroller.setLocation(85, 370);
		textScroller.setSize(550,190);
	    
	    name.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
	    name.setSize(500, 50); 
	    name.setLocation(100,20); 
	    add(name);
		
	    address.setFont(new Font("Arial", Font.PLAIN, 20)); 
	    address.setSize(500, 40); 
	    address.setLocation(100, 70); 
	    add(address);
	    
	    menu = new JLabel("Menu");
	    menu.setFont(new Font("Goudy Stout", Font.ITALIC, 30)); 
	    menu.setSize(300, 20); 
	    menu.setLocation(100, 330); 
	    add(menu);

	    
		btnmessage = new JButton("Message");
		btnsetting = new JButton("Setting");
		btnaddMenu = new JButton("Menu");
		btnaddEvent = new JButton("Event");

		btnmessage.setBounds(1100, y, 50, 50);
		btnsetting.setBounds(1040, y, 50, 50);
		btnaddMenu.setBounds(980, y, 50, 50);
		btnaddEvent.setBounds(920, y, 50, 50);
		
		btnmessage.addActionListener(this);
		btnsetting.addActionListener(this);
		btnaddMenu.addActionListener(this);
		btnaddEvent.addActionListener(this);
		
		this.add(btnaddEvent);
		this.add(btnaddMenu);
		this.add(btnsetting);
		this.add(btnmessage);
		this.add(textScroller);
		
	}

	public void menuComponent() {
		nameFood = new JLabel("Food's name");
		nameFood.setFont(new Font("Arial", Font.PLAIN, 15));
		nameFood.setSize(200, 20);
		nameFood.setLocation(900, 100);
		add(nameFood);
		
		tnameFood = new JTextField();
		tnameFood.setFont(new Font("Arial", Font.PLAIN, 15));
		tnameFood.setSize(150, 20);
		tnameFood.setLocation(1000, 100);
		add(tnameFood);
		
		price = new JLabel("Price");
		price.setFont(new Font("Arial", Font.PLAIN, 15));
		price.setSize(200, 20);
		price.setLocation(900, 130);
		add(price);
		
		tprice = new JTextField();
		tprice.setFont(new Font("Arial", Font.PLAIN, 15));
		tprice.setSize(150, 20);
		tprice.setLocation(1000, 130);
		add(tprice);
		
		description = new JLabel("Description");
		description.setFont(new Font("Arial", Font.PLAIN, 15));
		description.setSize(200, 20);
		description.setLocation(900, 190);
		add(description);
		
		tdescription = new JTextField();
		tdescription.setFont(new Font("Arial", Font.PLAIN, 15));
		tdescription.setSize(150, 20);
		tdescription.setLocation(1000, 190);
		add(tdescription);
		
		categoryl = new JLabel("Category");
		categoryl.setFont(new Font("Arial", Font.PLAIN, 15));
		categoryl.setSize(250, 20);
		categoryl.setLocation(900, 160);
		add(categoryl);
		
		category = new JComboBox(categorys);
		category.setFont(new Font("Arial", Font.PLAIN, 15));
		category.setSize(100, 20);
		category.setLocation(1000, 160);
		add(category);
		
		option = new JLabel("Option");
		option.setFont(new Font("Arial", Font.PLAIN, 15));
		option.setSize(250, 20);
		option.setLocation(900, 220);
		add(option);
		
		noption = new JComboBox(noptions);
		noption.setFont(new Font("Arial", Font.PLAIN, 15));
		noption.setSize(40, 20);
		noption.setLocation(950, 220);
		add(noption);
		
		toption = new JTextArea();
		toption.setFont(new Font("Arial", Font.PLAIN, 15));
		toption.setSize(160, 50);
		toption.setLocation(1000, 220);
		toption.setLineWrap(true);
		add(toption);
		
		choice = new JLabel("Choice");
		choice.setFont(new Font("Arial", Font.PLAIN, 15));
		choice.setSize(250, 20);
		choice.setLocation(900, 280);
		add(choice);
		
		nchoice = new JComboBox(nchoices);
		nchoice.setFont(new Font("Arial", Font.PLAIN, 15));
		nchoice.setSize(40, 20);
		nchoice.setLocation(950, 280);
		add(nchoice);
		
		tchoice = new JTextArea();
		tchoice.setFont(new Font("Arial", Font.PLAIN, 15));
		tchoice.setSize(160, 50);
		tchoice.setLocation(1000, 280);
		tchoice.setLineWrap(true);
		add(tchoice);
	
		btnAddToMenu = new JButton("Add");
		btnAddToMenu.setBounds(1090, 340, 70, 20);
		btnAddToMenu.addActionListener(this);
		add(btnAddToMenu);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnmessage) {System.out.println("1");}
		if(e.getSource()==btnsetting) {System.out.println("2");}
		if(e.getSource()==btnaddMenu) {System.out.println("Add menu");
		menuComponent();
		repaint();
/*		JLabel popUpTitle = new JLabel("Updating the menu");
		Popup p;
		PopupFactory pf = new PopupFactory();
		JPanel popUpPanel = new JPanel();
		popUpPanel.add(popUpTitle);
		p = pf.getPopup(MainFrame.getMainFrame(), popUpPanel, 180, 100);*/

		}
		if(e.getSource()==btnaddEvent) {System.out.println("4");
		}
		if(e.getSource()==btnAddToMenu) {System.out.println("ADDDDDD");closeMenuPanel(); repaint();}
	}
		
	private void closeMenuPanel() {
		this.remove(btnAddToMenu);
		this.remove(categoryl);
		remove(category);
		remove(option);
		remove(toption);
		remove(noption);
		remove(choice);
		remove(tchoice);
		remove(nchoice);
		remove(nameFood);
		remove(tnameFood);
		remove(price);
		remove(tprice);
		remove(description);
		remove(tdescription);
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {backGroundMenu = ImageIO.read(new File("ImageSource\\RestaurantPanel.png"));
		   g.drawImage(backGroundMenu,0 ,0, null);} 
	  catch (IOException e) {e.printStackTrace();}
	}

}
