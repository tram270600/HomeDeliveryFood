import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class RestaurantPanel extends JPanel implements ActionListener, ItemListener{
	public static boolean newOrder = false;
	
	private BufferedImage backGroundMenu;
	static JButton btnmessage, btnsetting, btnaddMenu, btnaddEvent;
	private JLabel name, openinghour, address, menu, event, ingredient, material, tout; //tout announce the update result
	private JTextArea tmenu, tevent, tingredient, tmaterial;
	private JScrollPane menutextScroller, eventtextScroller, ingredienttextScroller, materialtextScroller;
	PopupFactory pf;
//	Popup p;
	Popup po;
	JLabel popUpTitle;
	JPanel popUpPanel;

	//COMPONENT OF MENU
	JButton btnAddToMenu;
	private JPanel ingreInfo, materialInfo;
	private JLayeredPane layeredIngrePanel, layeredMaterialPanel;
	private JComboBox category, noption, nchoice; 
	private JTextArea toption, tchoice;
	private String noptions[] = {"1","2","3","4","5"}, nchoices[]=  {"1","2","3","4","5"};
	private String categorys[] = {"Barbecue", "Chicken", "Drinks and Bevarages", "Dessert", "Hot-pot",  "Milktea", "Noodle/Soup", "Seafood", "Snacks","Tea","Vegetable","Vegetarian food"};
	private JLabel nameFood, price, description, option, choice, categoryl, ingredientM;
	private JTextField tnameFood, tprice, tdescription, tingredient1, tingredient2;
	private JToggleButton btnUpdateIngre, btnUpdateMaterial;
	
	public final static String defaultS = "*****";
	public static String menuText = defaultS, oldDish;
	public static String ingreText = defaultS, oldIngre;
	public static String eventText = defaultS, oldEvent;
	public static String materialText = defaultS, oldMaterial;
	
	//COMPONENT OF EVENT
	private JLabel eventName, eventContent, eventCondition, eventParticipant, eStartDate, eEndDate, startDate, endDate;
	private JTextField teventName, teventContent, teventCondition, teventParticipant;
	 private JComboBox sdate,smonth, syear, edate, emonth, eyear; 
	 private JButton btnApplyEvent;
	 private String startdates[] 
		        = { "1", "2", "3", "4", "5", 
		            "6", "7", "8", "9", "10", 
		            "11", "12", "13", "14", "15", 
		            "16", "17", "18", "19", "20", 
		            "21", "22", "23", "24", "25", 
		            "26", "27", "28", "29", "30", 
	        "31" }; 
	private String startmonths[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}; 
	private String startyears[] 
	    = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020","2021","2022"}; 
	private String enddates[] 
	        = { "1", "2", "3", "4", "5", 
	            "6", "7", "8", "9", "10", 
	            "11", "12", "13", "14", "15", 
	            "16", "17", "18", "19", "20", 
	            "21", "22", "23", "24", "25", 
	            "26", "27", "28", "29", "30", 
	            "31" }; 
	private String endmonths[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}; 
	private String endyears[] = { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020","2021","2022"}; 
	
	//COMPONENT OF SETTING
	private JToggleButton switchmenu, switchevent, switchMaterial, switchIngredient, btnEditInfo, btnEditMenu; 
	private JLabel eventDisplay, menuDisplay, ingredientDisplay, materialDisplay;
	private JButton btnLogOut;
	
	//COMPONENT OF EDIT INFO
	private JLayeredPane layeredPanel, layeredMenuPanel;
	private JPanel editInfo, editMenu;
	
	//COMPONENT OF BILL 
	private JPanel billInfo;
	private JLayeredPane layeredBillPanel;
	static DefaultTableModel tableOrderModel = new DefaultTableModel();
	static DefaultTableModel tableFromAppModel = new DefaultTableModel();
	private JTable tableOrder;

	private static JTable tableFromApp;
	
	//COMPONENT OF VIEW MENU
	private String header[] = {"ID", "Name"};
	static DefaultTableModel tableModel = new DefaultTableModel();
	private JTable tableDish;
	static TableCellListener tcl;
	
	private static String ResNo; 
	private static int rbillID;
	
	static //ANNOUCEMENT
	JFrame announceFrame;
	

	public RestaurantPanel(String name, String address, String ResNo) {
		this.name = new JLabel(name);
		this.address = new JLabel(address);
		this.ResNo = ResNo;
		RestaurantPanelComponent();
	}
	public void RestaurantPanelComponent() {
		int y = 10;
		setLayout(null);
		menu = new JLabel("Menu");
		menu.setFont(new Font("Goudy Stout", Font.ITALIC, 20));
		menu.setSize(300, 20);
		menu.setLocation(150, 360);
		
		tmenu = new JTextArea();
		tmenu.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    tmenu.setLineWrap(true); 
	      
		menutextScroller = new JScrollPane(tmenu);
	    menutextScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		menutextScroller.setLocation(85, 380);
		menutextScroller.setSize(250,180);
	    
		event = new JLabel("Event");
		event.setFont(new Font("Goudy Stout", Font.ITALIC, 20));
		event.setSize(300, 20);
		event.setLocation(960, 340);
		
		tevent = new JTextArea();
		tevent.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    tevent.setLineWrap(true); 
	      
		eventtextScroller = new JScrollPane(tevent);
	    eventtextScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		eventtextScroller.setLocation(950, 360);
		eventtextScroller.setSize(160,200);
		
		ingredient = new JLabel("Food Storage");
		ingredient.setFont(new Font("Goudy Stout", Font.ITALIC, 20));
		ingredient.setSize(300, 20);
		ingredient.setLocation(350, 415);
		
		tingredient = new JTextArea();
		tingredient.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    tingredient.setLineWrap(true); 
	      
	    ingredienttextScroller = new JScrollPane(tingredient);
	    ingredienttextScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    ingredienttextScroller.setLocation(400, 440);
	    ingredienttextScroller.setSize(190,100);
	    
	    material = new JLabel("Material");
	    material.setFont(new Font("Goudy Stout", Font.ITALIC, 20));
	    material.setSize(300, 20);
	    material.setLocation(680, 415);
		
		tmaterial = new JTextArea();
		tmaterial.setFont(new Font("Arial", Font.PLAIN, 15)); 
	    tmaterial.setLineWrap(true); 
	      
	    materialtextScroller = new JScrollPane(tmaterial);
	    materialtextScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    materialtextScroller.setLocation(680, 440);
	    materialtextScroller.setSize(190,100);
	    
	    name.setFont(new Font("Cooper Black", Font.BOLD, 50)); 
	    name.setSize(500, 50); 
	    name.setLocation(100,20);
	    add(name);
		
	    address.setFont(new Font("Arial", Font.PLAIN, 20)); 
	    address.setSize(500, 40); 
	    address.setLocation(100, 70); 
	    add(address);
	    
		btnmessage = new JButton(new ImageIcon("ImageSource\\btnInRes\\btnaddBill.png"));
		btnsetting = new JButton(new ImageIcon("ImageSource\\btnInRes\\btnSetting.png"));
		btnaddMenu = new JButton(new ImageIcon("ImageSource\\btnInRes\\btnaddMenu.png"));
		btnaddEvent = new JButton(new ImageIcon("ImageSource\\btnInRes\\btnaddEvent.png"));

		btnmessage.setBounds(1080, y, 50, 50);
		btnsetting.setBounds(1020, y, 50, 50);
		btnaddMenu.setBounds(960, y, 50, 50);
		btnaddEvent.setBounds(900, y, 50, 50);
		
		btnmessage.addActionListener(this);
		btnsetting.addActionListener(this);
		btnaddMenu.addActionListener(this);
		btnaddEvent.addActionListener(this);
		
		tout = new JLabel("");
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setSize(500, 25);
		tout.setLocation(950, 70);
		add(tout);
		
		this.add(btnaddEvent);
		this.add(btnaddMenu);
		this.add(btnsetting);
		this.add(btnmessage);

		menuComponent();
		eventComponent();
		settingComponent();
		editInfoComponent();
		editMenuComponent();
		billComponent();
		
		announceFrame = new JFrame("Announcement");
		announceFrame.setBounds(225, 285, 300, 200);
		announceFrame.getContentPane().setLayout(null);
		announceFrame.setVisible(false);
		announceFrame.setResizable(false);
//		announceNewBill();
//		JOptionPane.showMessageDialog(this, "Restaurant have new bill");
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
//		add(option);
		
		noption = new JComboBox(noptions);
		noption.setFont(new Font("Arial", Font.PLAIN, 15));
		noption.setSize(40, 20);
		noption.setLocation(950, 220);
//		add(noption);
		
		toption = new JTextArea();
		toption.setFont(new Font("Arial", Font.PLAIN, 15));
		toption.setSize(160, 50);
		toption.setLocation(1000, 220);
		toption.setLineWrap(true);
//		add(toption);
		
		choice = new JLabel("Choice");
		choice.setFont(new Font("Arial", Font.PLAIN, 15));
		choice.setSize(250, 20);
		choice.setLocation(900, 280);
//		add(choice);
		
		nchoice = new JComboBox(nchoices);
		nchoice.setFont(new Font("Arial", Font.PLAIN, 15));
		nchoice.setSize(40, 20);
		nchoice.setLocation(950, 280);
//		add(nchoice);
		
		tchoice = new JTextArea();
		tchoice.setFont(new Font("Arial", Font.PLAIN, 15));
		tchoice.setSize(160, 50);
		tchoice.setLocation(1000, 280);
		tchoice.setLineWrap(true);
//		add(tchoice);
		
		ingredientM = new JLabel("Ingredient");
		ingredientM.setFont(new Font("Arial", Font.PLAIN, 15));
		ingredientM.setSize(200, 20);
		ingredientM.setLocation(900, 220);
		add(ingredientM);
		
		tingredient1 = new JTextField();
		tingredient1.setFont(new Font("Arial", Font.PLAIN, 15));
		tingredient1.setSize(150, 20);
		tingredient1.setLocation(1000, 220);
		add(tingredient1);
		
		tingredient2 = new JTextField();
		tingredient2.setFont(new Font("Arial", Font.PLAIN, 15));
		tingredient2.setSize(150, 20);
		tingredient2.setLocation(1000, 250);
		add(tingredient2);
	
		btnAddToMenu = new JButton("Add");
		btnAddToMenu.setBounds(1090, 340, 70, 20);
		btnAddToMenu.addActionListener(this);
		add(btnAddToMenu);
		
		 btnUpdateIngre = new JToggleButton("Update Ingredient"); 
	     btnUpdateIngre.setFont(new Font("Arial", Font.PLAIN, 15)); 
	     btnUpdateIngre.setSize(210, 20); 
	     btnUpdateIngre.setLocation(920, 280); 
	     btnUpdateIngre.addItemListener(this);  
	     add(btnUpdateIngre); 
	     
	     btnUpdateMaterial = new JToggleButton("Update Material"); 
	     btnUpdateMaterial.setFont(new Font("Arial", Font.PLAIN, 15)); 
	     btnUpdateMaterial.setSize(210, 20); 
	     btnUpdateMaterial.setLocation(920, 310); 
	     btnUpdateMaterial.addItemListener(this);  
	     add(btnUpdateMaterial); 
//----------------------------------------------------------------------		
		layeredIngrePanel = new JLayeredPane();
		layeredIngrePanel.setBounds(300, 100, 600, 200);
		add(layeredIngrePanel);
		layeredIngrePanel.setLayout(new CardLayout(0, 0));
		
		ingreInfo = new JPanel();
		layeredIngrePanel.add(ingreInfo);
		ingreInfo.setBackground(new Color(255, 255, 255, 200 )); //color white with the level of transparency 55 (0: invisible, 255: solid)
		ingreInfo.setLayout(null);
		
		JLabel ingreName = new JLabel("Ingredient's Name");
		ingreName.setBounds(10, 50, 150, 50);
		ingreName.setFont(new Font("Serif", Font.ITALIC, 18));
		ingreInfo.add(ingreName);

		JLabel ingreAmount = new JLabel("Storage Amount");
		ingreAmount.setBounds(10, 80, 300, 50);
		ingreAmount.setFont(new Font("Serif", Font.ITALIC, 18));
		ingreInfo.add(ingreAmount);
		
		JLabel ingrePrice = new JLabel("Ingredient's Price");
		ingrePrice.setBounds(10, 110, 300, 50);
		ingrePrice.setFont(new Font("Serif", Font.ITALIC, 18));
		ingreInfo.add(ingrePrice);
		
		JLabel title = new JLabel("Reserve Ingredient List");
		title.setBounds(175, 10, 300, 50);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		ingreInfo.add(title);
		
		JTextField tingreName = new JTextField();
		tingreName.setBounds(200, 70, 380, 20);
		ingreInfo.add(tingreName);
		
		JTextField tingreAmount = new JTextField();
		tingreAmount.setBounds(200, 100, 380, 20);
		ingreInfo.add(tingreAmount);
		
		JTextField tingrePrice = new JTextField();
		tingrePrice .setBounds(200, 130, 380, 20);
		ingreInfo.add(tingrePrice);
		
		JButton btnApply = new JButton("Update");
		btnApply.setBounds(250,170,100,20);
		ingreInfo.add(btnApply);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Update Ingredient");
				btnUpdateIngre.setSelected(false);
				try {
					JavaConnect2SQL.updateInfoToSQL("Ingredient",dataIngre(tingreName.getText(),
							tingreAmount.getText(),tingrePrice.getText()));
					System.out.println("Add Ingredient: Success");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Add Ingredient: Fail");
					e1.printStackTrace();
				};
			}});
//---------------------------------------------------------------------
		layeredMaterialPanel = new JLayeredPane();
		layeredMaterialPanel.setBounds(300, 300, 600, 200);
		add(layeredMaterialPanel);
		layeredMaterialPanel.setLayout(new CardLayout(0, 0));
		
		materialInfo = new JPanel();
		layeredMaterialPanel.add(materialInfo);
		materialInfo.setBackground(new Color(255, 255, 255, 200 )); //color white with the level of transparency 55 (0: invisible, 255: solid)
		materialInfo.setLayout(null);
		
		JLabel materialName = new JLabel("Ingredient's Name");
		materialName.setBounds(10, 50, 150, 50);
		materialName.setFont(new Font("Serif", Font.ITALIC, 18));
		materialInfo.add(materialName);

		JLabel materialAmount = new JLabel("Amount Expected");
		materialAmount.setBounds(10, 80, 300, 50);
		materialAmount.setFont(new Font("Serif", Font.ITALIC, 18));
		materialInfo.add(materialAmount);
		
		JLabel title1 = new JLabel("Need To Buy Ingredient List");
		title1.setBounds(165, 10, 350, 50);
		title1.setFont(new Font("Serif", Font.BOLD, 25));
		materialInfo.add(title1);
		
		JTextField tmaterialName = new JTextField();
		tmaterialName.setBounds(200, 70, 380, 20);
		materialInfo.add(tmaterialName);
		
		JTextField tmaterialAmount = new JTextField();
		tmaterialAmount.setBounds(200, 100, 380, 20);
		materialInfo.add(tmaterialAmount);
		
		JButton btnApply1 = new JButton("Update");
		btnApply1.setBounds(250,160,100,20);
		materialInfo.add(btnApply1);
		btnApply1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Update");
				btnUpdateMaterial.setSelected(false);
				try {
					JavaConnect2SQL.updateInfoToSQL("MaterialRequired",dataMaterial(tmaterialName.getText(),
							tmaterialAmount.getText()));
					System.out.println("Add Material: Success");
					tout.setText("Add Material: Success");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Add Material: Fail");
					tout.setText("Add Material: Fail");
					e1.printStackTrace();
			}}});
		closeMenuPanel();
	}
	public void eventComponent() {
		startDate = new JLabel("Start date");
		startDate.setFont(new Font("Arial", Font.PLAIN, 15));
		startDate.setSize(200, 20);
		startDate.setLocation(900, 220);
		add(startDate);
		
		endDate = new JLabel("End date");
		endDate.setFont(new Font("Arial", Font.PLAIN, 15));
		endDate.setSize(200, 20);
		endDate.setLocation(900, 250);
		add(endDate);
		
		sdate = new JComboBox(startdates);
		sdate.setFont(new Font("Arial", Font.PLAIN, 15));
		sdate.setSize(40, 20);
		sdate.setLocation(1000, 220);
		add(sdate);

		smonth = new JComboBox(startmonths);
		smonth.setFont(new Font("Arial", Font.PLAIN, 15));
		smonth.setSize(50, 20);
		smonth.setLocation(1050, 220);
		add(smonth);

		syear = new JComboBox(startyears);
		syear.setFont(new Font("Arial", Font.PLAIN, 15));
		syear.setSize(60, 20);
		syear.setLocation(1110, 220);
		add(syear);
	      
		edate = new JComboBox(enddates);
		edate.setFont(new Font("Arial", Font.PLAIN, 15));
		edate.setSize(40, 20);
		edate.setLocation(1000, 250);
		add(edate);

		emonth = new JComboBox(endmonths);
		emonth.setFont(new Font("Arial", Font.PLAIN, 15));
		emonth.setSize(50, 20);
		emonth.setLocation(1050, 250);
		add(emonth);
		
		eyear = new JComboBox(endyears);
		eyear.setFont(new Font("Arial", Font.PLAIN, 15));
		eyear.setSize(60, 20);
		eyear.setLocation(1110, 250);
		add(eyear);
		
		eventName = new JLabel("Event's Name");
		eventName.setFont(new Font("Arial", Font.PLAIN, 15));
		eventName.setSize(200, 20);
		eventName.setLocation(900, 100);
		add(eventName);
		
		teventName = new JTextField();
		teventName.setFont(new Font("Arial", Font.PLAIN, 15));
		teventName.setSize(150, 20);
		teventName.setLocation(1000, 100);
		add(teventName);
		
		eventContent = new JLabel("Content");
		eventContent.setFont(new Font("Arial", Font.PLAIN, 15));
		eventContent.setSize(200, 20);
		eventContent.setLocation(900, 130);
		add(eventContent);
		
		teventContent = new JTextField();
		teventContent.setFont(new Font("Arial", Font.PLAIN, 15));
		teventContent.setSize(150, 20);
		teventContent.setLocation(1000, 130);
		add(teventContent);
		
		eventParticipant = new JLabel("Participant");
		eventParticipant.setFont(new Font("Arial", Font.PLAIN, 15));
		eventParticipant.setSize(200, 20);
		eventParticipant.setLocation(900, 190);
		add(eventParticipant);
		
		teventParticipant = new JTextField();
		teventParticipant.setFont(new Font("Arial", Font.PLAIN, 15));
		teventParticipant.setSize(150, 20);
		teventParticipant.setLocation(1000, 190);
		add(teventParticipant);
		
		eventCondition = new JLabel("Condition");
		eventCondition.setFont(new Font("Arial", Font.PLAIN, 15));
		eventCondition.setSize(100, 20);
		eventCondition.setLocation(900, 160);
		add(eventCondition);

		teventCondition = new JTextField();
		teventCondition.setFont(new Font("Arial", Font.PLAIN, 15));
		teventCondition.setSize(150, 20);
		teventCondition.setLocation(1000, 160);
		add(teventCondition);

		btnApplyEvent = new JButton("Apply Event");
		btnApplyEvent.setBounds(1000, 300, 120, 20);
		btnApplyEvent.addActionListener(this);
		add(btnApplyEvent);
		closeEventPanel();
	}
	public void settingComponent() {
		menuDisplay = new JLabel("Menu Display");
		menuDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
		menuDisplay.setSize(100, 20);
		menuDisplay.setLocation(920, 160);
		add(menuDisplay);
		
		eventDisplay = new JLabel("Event Display");
		eventDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
		eventDisplay.setSize(100, 20);
		eventDisplay.setLocation(920, 190);
		add(eventDisplay);
		
		ingredientDisplay = new JLabel("Ingredient Display");
		ingredientDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
		ingredientDisplay.setSize(150, 20);
		ingredientDisplay.setLocation(920, 220);
		add(ingredientDisplay);
		
		materialDisplay = new JLabel("Material Display");
		materialDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
		materialDisplay.setSize(150, 20);
		materialDisplay.setLocation(920, 250);
		add(materialDisplay);
	
	switchmenu = new JToggleButton("OFF"); 
	switchmenu.setFont(new Font("Arial", Font.ITALIC, 10));
	switchmenu.setBounds(1070,160,60, 20);
	add(switchmenu);   
	switchmenu.addItemListener(this);  
	
	switchevent = new JToggleButton("OFF"); 
	switchevent.setFont(new Font("Arial", Font.ITALIC, 10));
	switchevent.setBounds(1070,190,60, 20);
	add(switchevent);   
	switchevent.addItemListener(this);  
	
	switchIngredient = new JToggleButton("OFF"); 
	switchIngredient.setFont(new Font("Arial", Font.ITALIC, 10));
	switchIngredient.setBounds(1070,220,60, 20);
	add(switchIngredient);   
	switchIngredient.addItemListener(this);  
	
	switchMaterial = new JToggleButton("OFF"); 
	switchMaterial.setFont(new Font("Arial", Font.ITALIC, 10));
	switchMaterial.setBounds(1070,250,60, 20);
	add(switchMaterial);   
	switchMaterial.addItemListener(this);  
	
	 btnEditInfo = new JToggleButton("Edit Info"); 
     btnEditInfo.setFont(new Font("Arial", Font.PLAIN, 15)); 
     btnEditInfo.setSize(210, 20); 
     btnEditInfo.setLocation(920, 100); 
     btnEditInfo.addItemListener(this);  
     add(btnEditInfo); 
     
     btnEditMenu = new JToggleButton("Edit Menu"); 
     btnEditMenu.setFont(new Font("Arial", Font.PLAIN, 15)); 
     btnEditMenu.setSize(210, 20); 
     btnEditMenu.setLocation(920, 130); 
     btnEditMenu.addItemListener(this);  
     add(btnEditMenu); 
     
     btnLogOut = new JButton("Log out"); 
     btnLogOut.setFont(new Font("Arial", Font.PLAIN, 10)); 
     btnLogOut.setSize(100, 20); 
     btnLogOut.setLocation(1030, 280); 
     btnLogOut.addActionListener(this); 
     add(btnLogOut); 
	closeSettingPanel();
	}
	public void editInfoComponent() {
		layeredPanel = new JLayeredPane();
		layeredPanel.setBounds(300, 100, 600, 400);
		add(layeredPanel);
		layeredPanel.setLayout(new CardLayout(0, 0));
		
		editInfo = new JPanel();
		layeredPanel.add(editInfo);
		//editInfo.setVisible(false);
		editInfo.setBackground(new Color(255, 255, 255, 200 )); //color white with the level of transparency 55 (0: invisible, 255: solid)
		editInfo.setLayout(null);

		JLabel resName = new JLabel("New Name");
		resName.setBounds(10, 50, 100, 50);
		resName.setFont(new Font("Serif", Font.ITALIC, 18));
		editInfo.add(resName);

		JLabel resPhone = new JLabel("New Phone number");
		resPhone.setBounds(10, 80, 300, 50);
		resPhone.setFont(new Font("Serif", Font.ITALIC, 18));
		editInfo.add(resPhone);
		
		JLabel resAddress = new JLabel("Other branch");
		resAddress.setBounds(10, 110, 300, 50);
		resAddress.setFont(new Font("Serif", Font.ITALIC, 18));
		editInfo.add(resAddress);
		
		JLabel title = new JLabel("Restaurant's Information");
		title.setBounds(175, 10, 300, 50);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		editInfo.add(title);
		
		JTextField tResName = new JTextField();
		tResName.setBounds(200, 70, 380, 20);
		editInfo.add(tResName);
		
		JTextField tResPhone = new JTextField();
		tResPhone.setBounds(200, 100, 380, 20);
		editInfo.add(tResPhone);
		
		JTextField tResAddress = new JTextField();
		tResAddress .setBounds(200, 130, 380, 20);
		editInfo.add(tResAddress);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(270,360,80,20);
		editInfo.add(btnApply);
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Apply");
				editInfo.setVisible(false);
				btnEditInfo.setSelected(false);
			}});
		closeEditInfoPanel();
	}
	
	public void MenuTable() throws Exception {
		System.out.println("In MenuTable");
		tableDish = new JTable();

		String colsName[] = { "DishID", "DishName", "Category", "Description", "Price", "Ingredient1", "Ingredient2","ApplyDate", "EventID" };
		tableModel.setColumnIdentifiers(colsName);
		tableDish.setModel(tableModel);
		tableDish.setRowHeight(30);
		JScrollPane scroll = new JScrollPane(tableDish);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setLocation(0, 50);
		scroll.setSize(600, 180);
		editMenu.add(scroll);
		
		if(tableDish.getSelectedColumn()!=-1) {
			System.out.println("Row selected: "+tableDish.getSelectedColumn());
			System.out.println(tableModel.getValueAt(tableDish.getSelectedRow(),tableDish.getSelectedColumn()));
		}
	}
	
	public boolean isCellEditTable(int row, int col) {
		switch(col) {
		case 3:
		case 4: 
		case 8:
			return true;
		default:
			return false;
		}
	}
	public void editMenuComponent() {
		layeredMenuPanel = new JLayeredPane();
		layeredMenuPanel.setBounds(300, 100, 600, 400);
		add(layeredMenuPanel);
		layeredMenuPanel.setLayout(new CardLayout(0, 0));
		
		editMenu = new JPanel();
		layeredMenuPanel.add(editMenu);
		editMenu.setVisible(false);
		editMenu.setBackground(new Color(255, 246, 230, 255)); 
		editMenu.setLayout(null);
		
		JLabel title = new JLabel("MENU");
		title.setBounds(250, 2, 300, 50);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		editMenu.add(title);
		
		JLabel res = new JLabel(""); 
	    res.setFont(new Font("Arial", Font.PLAIN, 16)); 
	    res.setSize(600, 25); 
	    res.setLocation(50, 250); 
	    editMenu.add(res); 
	    
		try {
			MenuTable();
			System.out.println("Call MenuTable: yes");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Call MenuTable: no");
			e1.printStackTrace();
		}
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(220,360,80,20);
		editMenu.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Update");
				// btnEditMenu.setSelected(false);
				if ((isCellEditTable(tcl.getRow(), tcl.getColumn()) == true)&&(tcl.getNewValue()!=null)) {
					System.out.println(isCellEditTable(tcl.getRow(),  tcl.getColumn()));
					tableDish.getEditingColumn();
					tableDish.getEditingRow();

					System.out.println("Edit Column at: " + tcl.getColumn());
					System.out.println("Edit Row at: " + tcl.getRow());
					
					tableDish.getValueAt(tcl.getRow(), 0);
					System.out.println(tableDish.getValueAt(tcl.getRow(), 0));
				
					System.out.println("Old value: "+tcl.getOldValue()+"to New Value: "+tcl.getNewValue());

					try {
						if (tcl.getColumn() == 4) {
							JavaConnect2SQL.updateResInfo("Menu", "Price", (String) tcl.getNewValue(), "DishID",
									(String) tableDish.getValueAt(tcl.getRow(), 0));
							res.setText("Update Successfully - "+tcl.getNewValue());}
						else if (tcl.getColumn() == 3) {
							String newValue = "'" + tcl.getNewValue() + "'";
							JavaConnect2SQL.updateResInfo("Menu", "Description", newValue, "DishID",
									(String) tableDish.getValueAt(tcl.getRow(), 0));
							res.setText("Update Successfully - "+tcl.getNewValue());
						}
						else if (tcl.getColumn() == 8) {
							String newValue = "'" + tcl.getNewValue() + "'";
							JavaConnect2SQL.updateResInfo("Menu", "EventID", newValue, "DishID",
									(String) tableDish.getValueAt(tcl.getRow(), 0));
							res.setText("Update Successfully - "+tcl.getNewValue());
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					{System.out.println("Only description, price and event can be changed"); res.setText("Update Fail, only Description and Price can be changed");}
			}
		});
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(300,360,80,20);
		editMenu.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove");
				if(tableDish.getSelectedRow()!=-1) {
					System.out.println("Dish ID to remove: "+ (String)tableDish.getValueAt(tableDish.getSelectedRow(), 0));
					System.out.println("Row to delete: "+tableDish.getSelectedRow());
					
					try {
						JavaConnect2SQL.deleteResInfo("Menu", "DishID", (String)tableDish.getValueAt(tableDish.getSelectedRow(), 0));
						tableModel.removeRow(tableDish.getSelectedRow());
						res.setText("Remove Dish - "+(String)tableDish.getValueAt(tableDish.getSelectedRow(), 0));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//btnEditMenu.setSelected(false);
			}});
		closeEditMenuPanel();
		}
	public void billComponent() {
		layeredBillPanel = new JLayeredPane();
		layeredBillPanel.setBounds(300, 100, 600, 400);
		add(layeredBillPanel);
		layeredBillPanel.setLayout(new CardLayout(0, 0));
		
		billInfo = new JPanel();
		layeredBillPanel.add(billInfo);
		billInfo.setBackground(new Color(255, 255, 255, 200)); // color white with the level of transparency 55 (0:
																// invisible, 255: solid)
		billInfo.setLayout(null);
		
		JLabel title = new JLabel("Dish Order Form");
		title.setBounds(220, 10, 200, 50);
		title.setFont(new Font("Serif", Font.BOLD, 25));
		billInfo.add(title);
		
		JLabel deliveryInfo = new JLabel("Delivery Information");
		deliveryInfo.setBounds(10, 40, 200, 50);
		deliveryInfo.setFont(new Font("Serif", Font.ITALIC, 15));
		billInfo.add(deliveryInfo);
		
		JLabel dishInfo = new JLabel("Dish Information");
		dishInfo.setBounds(10, 160, 200, 50);
		dishInfo.setFont(new Font("Serif", Font.ITALIC, 15));
		billInfo.add(dishInfo);
		
		JLabel cusName = new JLabel("Customer's Name");
		cusName.setBounds(10, 70, 200, 50);
		cusName.setFont(new Font("Serif", Font.ITALIC, 18));
		billInfo.add(cusName);
		
		JTextField tcusName = new JTextField();
		tcusName.setBounds(200, 90, 380, 20);
		billInfo.add(tcusName);
		
		JLabel cusPhone = new JLabel("Customer's Phone");
		cusPhone.setBounds(10, 100, 200, 50);
		cusPhone.setFont(new Font("Serif", Font.ITALIC, 18));
		billInfo.add(cusPhone);
		
		JTextField tcusPhone = new JTextField();
		tcusPhone.setBounds(200, 120, 380, 20);
		billInfo.add(tcusPhone);
		
		JLabel cusAddress = new JLabel("Customer's Address");
		cusAddress.setBounds(10, 130, 200, 50);
		cusAddress.setFont(new Font("Serif", Font.ITALIC, 18));
		billInfo.add(cusAddress);
		
		JTextField tcusAddress = new JTextField();
		tcusAddress.setBounds(200, 150, 380, 20);
		billInfo.add(tcusAddress);
		
		JTextField tdishName  = new JTextField();
		tdishName.setBounds(120, 210, 150, 20);
		billInfo.add(tdishName);
		
		JTextField tamount  = new JTextField();
		tamount.setBounds(350, 210, 100, 20);
		billInfo.add(tamount);
		
		JLabel dishName = new JLabel("Dish's Name:");
		dishName.setBounds(10, 190, 200, 50);
		dishName.setFont(new Font("Serif", Font.ITALIC, 18));
		billInfo.add(dishName);
		
		JLabel dishAmount = new JLabel("Amount:");
		dishAmount.setBounds(280, 190, 200, 50);
		dishAmount.setFont(new Font("Serif", Font.ITALIC, 18));
		billInfo.add(dishAmount);
		
		JLabel dishPrice = new JLabel("TOTAL");
		dishPrice.setBounds(400, 330, 200, 50);
		dishPrice.setFont(new Font("Serif", Font.ITALIC, 18));
		billInfo.add(dishPrice);
		
		JTextField ttotalPrice  = new JTextField();
		ttotalPrice.setBounds(470, 345, 100, 20);
		billInfo.add(ttotalPrice);
		
		tableOrder = new JTable();
		String colsName[] = { "DishID", "DishName","Unit Price", "Amount", "Total Price", "Apply Discount"};
		tableOrderModel.setColumnIdentifiers(colsName);
		tableOrder.setModel(tableOrderModel);
		tableOrder.setRowHeight(30);
		JScrollPane scroll = new JScrollPane(tableOrder);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setLocation(0, 240);
		scroll.setSize(600, 100);
		billInfo.add(scroll);
		
		JButton btnAddDish = new JButton("Add");
		btnAddDish.setBounds(500,210,80,20);
		billInfo.add(btnAddDish);
		btnAddDish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				JavaConnect2SQL.searchMenuInfo("Menu", ResNo, tdishName.getText(),tamount.getText());
				tdishName.setBackground(Color.WHITE); tamount.setBackground(Color.WHITE);
				ttotalPrice.setText(""+getSum()+"");
				tdishName.setText("");
				tamount.setText("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//				closeBillPanel();
			}});
		JButton btnOrder = new JButton("Make order");
		btnOrder.setBounds(270,370,100,20);
		billInfo.add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((!tcusName.getText().equals("")) && (!tcusAddress.getText().equals(""))&& (!tcusPhone.getText().equals("")) && (tableOrderModel.getRowCount() != 0)) { // check fulfill
					try {
						JavaConnect2SQL.updateInfoToSQL("Bill", dataBill(tcusPhone.getText(), tcusAddress.getText(),
								tcusName.getText(), ResNo, ttotalPrice.getText()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int i = 0; i < tableOrderModel.getRowCount(); i++) {
						System.out.println("Dish at: " + i + "has ID: " + tableOrderModel.getValueAt(i, 0) + " with: x "
								+ tableOrderModel.getValueAt(i, 3));
						try {
							JavaConnect2SQL.updateInfoToSQL("BasedOn",
									dataBasedOnBill((String) tableOrderModel.getValueAt(i, 0),
											(String) tableOrderModel.getValueAt(i, 3)));
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} // catch
					} // for
					try {JavaConnect2SQL.calculateIngredientLeft("BillID",rbillID);} catch (Exception e1) {e1.printStackTrace();}
					
					System.out.println("Make order and find shipper");
//					closeBillPanel();
					tableOrderModel.setRowCount(0);
					ttotalPrice.setText("");
					tcusAddress.setText("");
					tcusPhone.setText("");
					tcusName.setText("");
				} else {
					JTextField[] labels = { tcusName, tcusAddress, tcusPhone };
					for (int i = 0; i < 3; i++) {
						if (labels[i].getText().equals(""))
							labels[i].setBackground(new Color(251, 217, 154));
					}
					for (int i = 0; i < 3; i++) {
						if (!labels[i].getText().equals(""))
							labels[i].setBackground(Color.WHITE);
					}
					if (tableOrderModel.getRowCount() == 0) {
						tdishName.setBackground(new Color(251, 217, 154));
						tamount.setBackground(new Color(251, 217, 154));
					}
				}
			}
		});
		closeBillPanel();
	}
		
	public int getSum() {
		int sum = 0; 
		for(int i = 0; i < tableOrder.getRowCount();i++) {
			sum += Integer.parseInt((String) tableOrder.getValueAt(i, 5));
		}
		System.out.println("TOTAL PRICE OF BILL: "+sum);
		return sum;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnmessage) {
			tout.setText("");
			System.out.println("Add bill");
			closeMenuPanel();
			closeEventPanel();
			closeSettingPanel();
			closeBillPanel();
			openBillPanel();
			repaint();

			try {
				JavaConnect2SQL.announceNewOrder(ResNo);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		if (e.getSource() == btnsetting) {
			tout.setText("");
			System.out.println("Add Setting");
			closeMenuPanel();
			closeEventPanel();
			closeBillPanel();
			openSettingPanel();
			repaint();
		}
		if (e.getSource() == btnaddMenu) {
			tout.setText("");
			System.out.println("Add menu");
			closeEventPanel();
			closeSettingPanel();
			closeBillPanel();
			openMenuPanel();
			repaint();
		}

		if (e.getSource() == btnaddEvent) {
			tout.setText("");
			System.out.println("Add Event");
			closeMenuPanel();
			closeSettingPanel();
			closeBillPanel();
			openEventPanel();
			repaint();
		}

		if (e.getSource() == btnAddToMenu) {
			tout.setText("");
			System.out.println("ADDDDDD");
			try {
				JavaConnect2SQL.updateInfoToSQL("Menu",dataMenu(tnameFood.getText(),(String)category.getSelectedItem(), 
						tdescription.getText(),tprice.getText(),tingredient1.getText(), tingredient2.getText()));
				System.out.println("Add new dish to menu: Success");
				tout.setText("Add new dish to menu: Success");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Add new dish to menu: Fail");
				tout.setText("Add new dish to menu: Fail");
				e1.printStackTrace();
			};
			closeMenuPanel();
			repaint();
		}
		if (e.getSource() == btnApplyEvent) {
			System.out.println("Confirm Event");
			String eStartDate = (String)syear.getSelectedItem() 
                    + "/" + (String)smonth.getSelectedItem() 
                    + "/" + (String)sdate.getSelectedItem(); 
			
			String eEndDate = (String)eyear.getSelectedItem() 
                    + "/" + (String)emonth.getSelectedItem() 
                    + "/" + (String)edate.getSelectedItem(); 
			try {
				JavaConnect2SQL.updateInfoToSQL("Event", dataEvent(teventName.getText(), teventContent.getText(), teventParticipant.getText(), teventCondition.getText(), eStartDate, eEndDate));
				System.out.println("Add new event: Success");
				tout.setText("Add new event: Success");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Add new event: Fail");
				tout.setText("Add new event: Fail");
				e1.printStackTrace();
			}
			closeEventPanel();
			repaint();
			
		}
	
		if (e.getSource() == btnLogOut) {
			System.out.println("See you again");
			MainFrame.callSetPanel(DynamicPanel.getLoginPanel());
		}
	}
	private String dataMenu(String dishname, String category, String description, String price, String ingredient1, String ingredient2) {
		String menuInfo = "'"+createDishID(dishname)+"','"+dishname+"','"+category+"','"+description+"',"+price+",'"+ingredient1+"','"+ingredient2+"','"+
				ResNo+"',GETDATE(),"+"null";
		System.out.println(menuInfo);
		return menuInfo;
}
	private String dataIngre(String ingredientName, String amount, String price) {
		String ingredientInfo = "'"+createDishID(ingredientName)+"','"+ingredientName+"',"+amount+","+price+",'"+ResNo+"',"+"null";
		System.out.println(ingredientInfo);
		return ingredientInfo;}
	
	private String dataMaterial(String mName, String amount) {
		String materialInfo = "'"+createDishID(mName)+"',"+amount+",'"+ResNo+"','"+createDishID(mName)+"'";
		System.out.println(materialInfo);
		return materialInfo;}

	private String dataEvent(String eName, String eContent, String eParticipant, String eCondition, String startDate, String endDate) {
		String eventInfo = "'" + createDishID(eName) + "','" + eCondition + "','" + eParticipant + "','" + eContent
				+ "','" + eName + "','" + startDate + "','" + endDate + "','" + ResNo + "'";
		System.out.println(eventInfo);
		return eventInfo;
	}
	
	private String dataBill(String cusPhone, String cusAddress, String cusName, String ResNo, String billPrice) {
		String billInfo = "'HCM','"+cusPhone+"','"+cusAddress+"','"+cusName+"','"+ResNo+"',"+"null,'"+ billPrice+"'";
		System.out.println(billInfo);
		return billInfo;
}
	private String dataBasedOnBill(String dishID, String amount) throws Exception {
		int billID = JavaConnect2SQL.findNewBillID("BillID");
		String basedOnInfo = "'"+billID+"',null,'"+dishID+"','"+amount+"'";
		System.out.println(basedOnInfo);
		rbillID = billID;
		return basedOnInfo;
	}
	
	private String dataBasedOnOrder(String dishID, String amount) throws Exception {
		int orderID = JavaConnect2SQL.findNewBillID("OrderID");
		String basedOnInfo = "null,'"+orderID+"','"+dishID+"','"+amount+"'";
		System.out.println(basedOnInfo);
		rbillID = orderID;
		return basedOnInfo;
	}
	
	public static String createDishID(String s) {
		int n = s.length();
		String DishID = "";
		for(int i = 0 ;i < n; i++) {
			if(Character.isUpperCase(s.charAt(i))) {
			DishID += s.charAt(i);}
		}
		DishID += ResNo;
		System.out.println("Dish ID: "+DishID);
		return DishID;
	}
	
	private void closeMenuPanel() {
		btnAddToMenu.setVisible(false);
		categoryl.setVisible(false); category.setVisible(false);
		option.setVisible(false); toption.setVisible(false); noption.setVisible(false);
		choice.setVisible(false); tchoice.setVisible(false); nchoice.setVisible(false);
		nameFood.setVisible(false); tnameFood.setVisible(false);
		price.setVisible(false); tprice.setVisible(false);
		description.setVisible(false); tdescription.setVisible(false);
		ingredientM.setVisible(false); tingredient1.setVisible(false); tingredient2.setVisible(false);
		
		
		layeredIngrePanel.setVisible(false); 
		layeredMaterialPanel.setVisible(false);
		ingreInfo.setVisible(false);
		materialInfo.setVisible(false);
		btnUpdateIngre.setVisible(false);
		btnUpdateMaterial.setVisible(false);
		btnUpdateIngre.setSelected(false);
		btnUpdateMaterial.setSelected(false);
		
	}
	private void openMenuPanel() {
		btnAddToMenu.setVisible(true);
		category.setVisible(true);
		categoryl.setVisible(true);
		option.setVisible(true);
		toption.setVisible(true);
		noption.setVisible(true);
		choice.setVisible(true);
		tchoice.setVisible(true);
		nchoice.setVisible(true);
		nameFood.setVisible(true);
		tnameFood.setVisible(true);
		price.setVisible(true);
		tprice.setVisible(true);
		description.setVisible(true);
		tdescription.setVisible(true);
		ingredientM.setVisible(true);
		tingredient1.setVisible(true);
		tingredient2.setVisible(true);
		btnUpdateMaterial.setVisible(true); btnUpdateIngre.setVisible(true);
	}
	
	private void closeEventPanel() {
		sdate.setVisible(false); smonth.setVisible(false); syear.setVisible(false);
		edate.setVisible(false); emonth.setVisible(false); eyear.setVisible(false);
		eventName.setVisible(false); teventName.setVisible(false);
		eventContent.setVisible(false); teventContent.setVisible(false);
		eventParticipant.setVisible(false); teventParticipant.setVisible(false);
		eventCondition.setVisible(false); teventCondition.setVisible(false);
		btnApplyEvent.setVisible(false);
		startDate.setVisible(false); endDate.setVisible(false);
	}
	private void openEventPanel() {
		sdate.setVisible(true); smonth.setVisible(true); syear.setVisible(true);
		edate.setVisible(true); emonth.setVisible(true); eyear.setVisible(true);
		eventName.setVisible(true); teventName.setVisible(true);
		eventContent.setVisible(true); teventContent.setVisible(true);
		eventParticipant.setVisible(true); teventParticipant.setVisible(true);
		eventCondition.setVisible(true); teventCondition.setVisible(true);
		btnApplyEvent.setVisible(true);
		startDate.setVisible(true); endDate.setVisible(true);
	}
	
	private void closeSettingPanel() {
		switchmenu.setVisible(false); switchevent.setVisible(false); switchIngredient.setVisible(false); switchMaterial.setVisible(false);
		menuDisplay.setVisible(false); eventDisplay.setVisible(false); ingredientDisplay.setVisible(false); materialDisplay.setVisible(false);
		btnEditMenu.setVisible(false);
		btnEditInfo.setVisible(false);
		btnLogOut.setVisible(false);
		btnEditInfo.setSelected(false);
		btnEditMenu.setSelected(false);
		
	}
	private void openSettingPanel() {
		switchmenu.setVisible(true); switchevent.setVisible(true); switchIngredient.setVisible(true); switchMaterial.setVisible(true);
		menuDisplay.setVisible(true); eventDisplay.setVisible(true); ingredientDisplay.setVisible(true); materialDisplay.setVisible(true);
		btnEditMenu.setVisible(true);
		btnEditInfo.setVisible(true);
		btnLogOut.setVisible(true);
	}
	
	public void openBillPanel() {layeredBillPanel.setVisible(true); billInfo.setVisible(true);}
	public void closeBillPanel() {layeredBillPanel.setVisible(false);billInfo.setVisible(false);}
	
	public void openEditInfoPanel() {
		layeredPanel.setVisible(true);
		editInfo.setVisible(true); 
		btnEditMenu.setSelected(false);
	}
	public void closeEditInfoPanel() {
		layeredPanel.setVisible(false);
		editInfo.setVisible(false);	
	}
	
	public void openEditMenuPanel() {
		layeredMenuPanel.setVisible(true);
		editMenu.setVisible(true); 
		btnEditInfo.setSelected(false);
		try {
			JavaConnect2SQL.view("Menu", ResNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void closeEditMenuPanel() {
		layeredMenuPanel.setVisible(false);
		editMenu.setVisible(false);	
		tableModel.setRowCount(0);
	}
	
	public void openUpdateIngrePanel() {
		layeredIngrePanel.setVisible(true);
		ingreInfo.setVisible(true);	
	}
	public void closeUpdateIngrePanel() {
		layeredIngrePanel.setVisible(false);
		ingreInfo.setVisible(false);	
	}
	
	public void openUpdateMaterialPanel() {
		layeredMaterialPanel.setVisible(true);
		materialInfo.setVisible(true);	
	}
	public void closeUpdateMaterialPanel() {
		layeredMaterialPanel.setVisible(false);
		materialInfo.setVisible(false);	
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {backGroundMenu = ImageIO.read(new File("ImageSource\\RestaurantPanel.png"));
		   g.drawImage(backGroundMenu,0 ,0, null);} 
	  catch (IOException e) {e.printStackTrace();}
	}
	public void setDefault() {
		menuText = defaultS;
		ingreText = defaultS;
		materialText = defaultS; 
		eventText = defaultS;
		tableModel.setRowCount(0);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		 if (switchmenu.isSelected()) {
			 setDefault();
			 switchmenu.setText("ON"); add(menu); add(menutextScroller); repaint();
			 try {
				JavaConnect2SQL.searchResInfo("Menu",ResNo);
				System.out.println("Menu Display: SUCCESS");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Menu Display: FAIL");
			}
			 tmenu.setText(showMenuDish());
			 }
	        else {switchmenu.setText("OFF"); remove(menutextScroller); remove(menu); repaint(); setDefault();}//menuText = ingreText = eventText= materialText = defaultS;}
		 
		 if (switchevent.isSelected()) {
			 setDefault();
			 switchevent.setText("ON"); add(event); add(eventtextScroller); repaint();
			
			 try {
				JavaConnect2SQL.searchResInfo("Event", ResNo);
				System.out.println("Event Display: SUCCESS");
				oldEvent = defaultS;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Event Display: FAIL");
			}
			 tevent.setText(showEvent());
		 }
	        else {switchevent.setText("OFF"); remove(event); remove(eventtextScroller); repaint(); setDefault();} 
		 
		 if (switchIngredient.isSelected()) {
			 setDefault();
			 switchIngredient.setText("ON"); add(ingredient); add(ingredienttextScroller);
			 try {
				JavaConnect2SQL.searchResInfo("Ingredient", ResNo);
				System.out.println("Ingredient Display: SUCCESS");
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Ingredient Display: FAIL");
			}
			 tingredient.setText(showIngredient());
		 }
	        else {switchIngredient.setText("OFF"); remove(ingredient); remove(ingredienttextScroller); repaint(); setDefault();} 
		 
		 if (switchMaterial.isSelected()) {
			 setDefault();
			 switchMaterial.setText("ON");  add(material); add(materialtextScroller); repaint(); 
		 try {
			JavaConnect2SQL.searchMaterial("MaterialRequired", ResNo);
			System.out.println("Material Display: SUCCESS");
			oldMaterial = defaultS;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Material Display: FAIL");
		}
		 tmaterial.setText(materialText);
		 }
	        else {switchMaterial.setText("OFF"); remove(material); remove(materialtextScroller); repaint(); setDefault();}
			
		 if (btnEditInfo.isSelected()) {btnEditInfo.setText("Close Edit Info");System.out.println("Edit Info"); openEditInfoPanel();repaint();}
		 	else {btnEditInfo.setText("Edit Info");closeEditInfoPanel();}
		 
		 if (btnEditMenu.isSelected()) {btnEditMenu.setText("Close Edit Menu");System.out.println("Edit Menu"); openEditMenuPanel(); 
		
		 Action action = new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//TableCellListener 
					tcl = (TableCellListener) e.getSource();
					System.out.println("Row: " + tcl.getRow());
					System.out.println("Column" + tcl.getColumn());
					System.out.println("Old Data: " + tcl.getOldValue());
					System.out.println("New Data: " + tcl.getNewValue());

				}
			};
			
			//TableCellListener 
			tcl = new TableCellListener(tableDish, action);
		 repaint();}
		 	else {btnEditMenu.setText("Edit Menu");closeEditMenuPanel();editMenu.remove(tableDish);}
		 
		 if(btnUpdateIngre.isSelected()) {btnUpdateIngre.setText("Close Update Ingredient"); System.out.println("Update Ingredient");
		 	openUpdateIngrePanel();}
		 else {btnUpdateIngre.setText("Update Ingredient"); closeUpdateIngrePanel();}
		 
		 if(btnUpdateMaterial.isSelected()) {btnUpdateMaterial.setText("Close Update Material"); System.out.println("Update Material");
		 	openUpdateMaterialPanel();}
		 else {btnUpdateMaterial.setText("Update Material"); closeUpdateMaterialPanel();}
	}

	public static String showMenuDish() {
		System.out.println("Call Menu");
		String text;
		text = "\nDish Name: " + JavaConnect2SQL.infoName + "\n" + "Category: " + JavaConnect2SQL.infoType + "\n"
				+ "Price: " + JavaConnect2SQL.infoPhone + "\n-----------------------------------";
		if (!text.equals(oldDish)) { // AVOID PRINT THE LAST DISH TWICE
			menuText += text;
		}
		oldDish = text;
		return menuText;
	}
	
	public static String showIngredient() {
		System.out.println("Call Ingredient");
		String text;
		text = "\nID: " + JavaConnect2SQL.infoAddress + "\n" + "Name: " + JavaConnect2SQL.infoName
				+ "\n" + "Amount: " + JavaConnect2SQL.infoType + "\n" + "Price: " + JavaConnect2SQL.infoPhone
				+ "\n----------------------------";
		if (!text.equals(oldIngre)) {
			ingreText += text;
		}
		oldIngre = text;
		return ingreText;
	}
	
	public static String showEvent() {
		System.out.println("Call Event");
		String text;
		text = "\nName: " + JavaConnect2SQL.infoName + "\n" + "Content: " + JavaConnect2SQL.infoAddress
				+ "\n" + "Start date: " + JavaConnect2SQL.infoType + "\n" + "End date: " + JavaConnect2SQL.infoPhone
				+ "\n------------------------";
		if (!text.equals(oldEvent)) {
			eventText += text;
		}
		oldEvent = text;
		return eventText;
	}
	
	public static String showMaterial(String info1, String info2, String info3, String info4, String info5, String info6) {
		System.out.println("Call Material");
		String text;
/*		text = "\nMaterialID: " + JavaConnect2SQL.info1 + "\n" + "Material Name: " + JavaConnect2SQL.info2
				+ "\n" + "Amount Expected: " + JavaConnect2SQL.info3 + "\n" + "Price: " + JavaConnect2SQL.info4
				+ "\n" + "Amount To Buy: " + JavaConnect2SQL.info5 + "\n" + "Total Price: " + JavaConnect2SQL.info6
				+ "\n----------------------";*/
		text = "\nMaterialID: " + info1 + "\n" + "Material Name: " + info2
				+ "\n" + "Amount Expected: " + info3 + "\n" + "Price: " + info4
				+ "\n" + "Amount To Buy: " + info5 + "\n" + "Total Price: " + info6
				+ "\n----------------------";
		if (!text.equals(oldMaterial)) {
			materialText += text;
		}
	
		oldMaterial = text;
		return materialText;
	}
	public static void announceNewBill(String rnfromOrder, String CusNo, JTable orderList) {
//		JOptionPane.showMessageDialog(MainFrame.getMainFrame().panel.loginPanel.signIn.res, "Restaurant have new bill");
//			while(true) {
//				if(newOrder == true) {
//					
//				}
		if(ResNo == rnfromOrder) {
			JFrame announceFrame = new JFrame("Announce");
			announceFrame.setBounds(500, 200, 500, 300);
			announceFrame.getContentPane().setLayout(null);
			announceFrame.setVisible(true);
			announceFrame.setResizable(false);

			JButton btnPrivacy = new JButton("Confirm");
			btnPrivacy.setBounds(190, 70, 120, 50);
			announceFrame.add(btnPrivacy);

			JButton btnLanguage = new JButton("Reject");
			btnLanguage.setBounds(190, 150, 120, 50);
			announceFrame.add(btnLanguage);
		}
			
		
	}
	public static void announceComingBill(String torderId, String torderPrice) {
			announceFrame.setVisible(true);
		
			JLabel orderId = new JLabel("Order ID: "+torderId);
			orderId.setFont(new Font("Arial", Font.ITALIC, 15));
			orderId.setSize(200, 20);
			orderId.setLocation(10, 10);
			announceFrame.add(orderId);
			
			JLabel orderPrice = new JLabel("TotalPrice:"+torderPrice);
			orderPrice.setFont(new Font("Arial", Font.ITALIC, 15));
			orderPrice.setSize(200, 20);
			orderPrice.setLocation(10, 30);
			announceFrame.add(orderPrice);
		
			tableFromApp = new JTable();
			String colsName[] = { "DishID", "Amount"};
			tableFromAppModel.setColumnIdentifiers(colsName);
			tableFromApp.setModel(tableFromAppModel);
			tableFromApp.setRowHeight(20);
			JScrollPane scroll = new JScrollPane(tableFromApp);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setLocation(0,50);
			scroll.setSize(200, 100);
			announceFrame.add(scroll);
			
			JButton btnAccept = new JButton("Accept");
			btnAccept.setBounds(200, 20, 80, 20);
			btnAccept.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e)
			    {
			    	int orderId = Integer.parseInt(torderId);
			    	try {JavaConnect2SQL.calculateIngredientLeft("OrderID",orderId);} catch (Exception e1) {e1.printStackTrace();}
			    	try {JavaConnect2SQL.updateOrderStatus("Orders", "OrderStatus", "Accepted", "OrderID", torderId);} catch (Exception e1) {e1.printStackTrace();}
			    	announceFrame.dispose();
			    }
			    });
			announceFrame.add(btnAccept);
			

//			JButton btnLanguage = new JButton("Reject");
//			btnLanguage.setBounds(190, 150, 120, 50);
//			announceFrame.add(btnLanguage);
			
		
	}
	
	
}
