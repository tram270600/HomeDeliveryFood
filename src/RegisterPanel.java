import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegisterPanel extends JPanel implements ActionListener {
	private BufferedImage backGroundMenu;
	public static String info;
	public static String table = "Registration";
	public static String typeUser;
	private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JLabel title;
    private JTextArea resadd; 
//	private Container c; 
    
	private JLabel name, accountName, password;
	private JTextField tname, taccountName, tpassword;
	
	private JLabel address;
	private JTextArea taddress;
	
	private JLabel email;
	private JTextField temail;
	
	private JLabel phoneNumber;
	private JTextField tphoneNumber; 
	
	private JLabel gender;
	private ButtonGroup gengp; 
	private JRadioButton male;
	private JRadioButton female;
	
	 private JLabel dob; 
	 private JComboBox date; 
	 private JComboBox month; 
	 private JComboBox year;
	 
	 

	 private String dates[] 
		        = { "1", "2", "3", "4", "5", 
		            "6", "7", "8", "9", "10", 
		            "11", "12", "13", "14", "15", 
		            "16", "17", "18", "19", "20", 
		            "21", "22", "23", "24", "25", 
		            "26", "27", "28", "29", "30", 
		            "31" }; 
		    private String months[] 
		        = { "Jan", "Feb", "Mar", "Apr", 
		            "May", "Jun", "July", "Aug", 
		            "Sep", "Oct", "Nov", "Dec" }; 
		    private String years[] 
		        = { "1995", "1996", "1997", "1998", 
		            "1999", "2000", "2001", "2002", 
		            "2003", "2004", "2005", "2006", 
		            "2007", "2008", "2009", "2010", 
		            "2011", "2012", "2013", "2014", 
		            "2015", "2016", "2017", "2018", 
		            "2019" }; 
	
	public int registerChoice; 
	public RegisterPanel(int choice){
		this.registerChoice = choice;
		if(this.registerChoice == 1) componentOfShipper();
		if(this.registerChoice == 2) componentOfRestaurantOwner();
		if(this.registerChoice == 3) componentOfCustomer();
		else System.out.println("");
		
	}
	public void componentOfCustomer() {
//		 c = getRootPane(); 
//	     c.setLayout(null); 
		typeUser = "Customer";
		setLayout(null);
	   title = new JLabel("Registration Form For Customer"); 
       title.setFont(new Font("Arial", Font.PLAIN, 30)); 
       title.setSize(500, 30); 
       title.setLocation(215, 50); 
       //c.
       add(title); 
		
       name = new JLabel("Name"); 
       name.setFont(new Font("Arial", Font.PLAIN, 20)); 
       name.setSize(100, 20); 
       name.setLocation(100, 120); 
//       c.add(name); 
       add(name);
 
       tname = new JTextField(); 
       tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
       tname.setSize(190, 20); 
       tname.setLocation(200, 120); 
       //c.
       add(tname); 
       
       accountName = new JLabel("Account Name");
       accountName.setFont(new Font("Arial", Font.PLAIN, 20));
       accountName.setSize(150, 20); 
       accountName.setLocation(400, 120);  
       add( accountName);
       
       taccountName = new JTextField(); 
       taccountName.setFont(new Font("Arial", Font.PLAIN, 15)); 
       taccountName.setSize(190, 20); 
       taccountName.setLocation(550, 120); 
       add(taccountName); 
       
       password = new JLabel("Password");
       password.setFont(new Font("Arial", Font.PLAIN, 20));
       password.setSize(100, 20); 
       password.setLocation(400, 170);  
       add(password);
       
       tpassword = new JTextField(); 
       tpassword.setFont(new Font("Arial", Font.PLAIN, 15)); 
       tpassword.setSize(190, 20); 
       tpassword.setLocation(550, 170); 
       add(tpassword); 
 
       phoneNumber = new JLabel("Phone"); 
       phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20)); 
       phoneNumber.setSize(100, 20); 
       phoneNumber.setLocation(100, 170); 
       //c.
       add(phoneNumber); 
 
       tphoneNumber = new JTextField(); 
       tphoneNumber.setFont(new Font("Arial", Font.PLAIN, 15)); 
       tphoneNumber.setSize(150, 20); 
       tphoneNumber.setLocation(200, 170); 
       //c.
       add(tphoneNumber); 
 
       gender = new JLabel("Gender"); 
       gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
       gender.setSize(100, 20); 
       gender.setLocation(100, 220); 
       //c.
       add(gender); 
 
       male = new JRadioButton("Male"); 
       male.setFont(new Font("Arial", Font.PLAIN, 15)); 
       male.setSelected(true); 
       male.setSize(75, 20); 
       male.setLocation(200, 220); 
       //c.
       add(male); 
 
       female = new JRadioButton("Female"); 
       female.setFont(new Font("Arial", Font.PLAIN, 15)); 
       female.setSelected(false); 
       female.setSize(80, 20); 
       female.setLocation(275, 220); 
       //c.
       add(female); 
 
       gengp = new ButtonGroup(); 
       gengp.add(male); 
       gengp.add(female); 
 
       dob = new JLabel("DOB"); 
       dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
       dob.setSize(100, 20); 
       dob.setLocation(100, 270); 
       //c.
       add(dob); 
 
       date = new JComboBox(dates); 
       date.setFont(new Font("Arial", Font.PLAIN, 15)); 
       date.setSize(50, 20); 
       date.setLocation(200, 270); 
       //c.
       add(date); 
 
       month = new JComboBox(months); 
       month.setFont(new Font("Arial", Font.PLAIN, 15)); 
       month.setSize(60, 20); 
       month.setLocation(250, 270); 
       //c.
       add(month); 
 
       year = new JComboBox(years); 
       year.setFont(new Font("Arial", Font.PLAIN, 15)); 
       year.setSize(60, 20); 
       year.setLocation(320, 270); 
       //c.
       add(year); 
 
       address = new JLabel("Address"); 
       address.setFont(new Font("Arial", Font.PLAIN, 20)); 
       address.setSize(100, 20); 
       address.setLocation(100, 320); 
       //c.
       add(address); 
 
       taddress = new JTextArea(); 
       taddress.setFont(new Font("Arial", Font.PLAIN, 15)); 
       taddress.setSize(200, 75); 
       taddress.setLocation(200, 320); 
       taddress.setLineWrap(true); 
       //c.
       add(taddress); 
 
       term = new JCheckBox("Accept Terms And Conditions."); 
       term.setFont(new Font("Arial", Font.PLAIN, 15)); 
       term.setSize(250, 20); 
       term.setLocation(350, 420); 
       //c.
       add(term); 
 
       sub = new JButton("Submit"); 
       sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
       sub.setSize(100, 20); 
       sub.setLocation(350, 480); 
       sub.addActionListener(this); 
       //c.
       add(sub); 
 
       reset = new JButton("Reset"); 
       reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
       reset.setSize(100, 20); 
       reset.setLocation(470, 480); 
       reset.addActionListener(this); 
       //c.
       add(reset); 
       
       tout = new JTextArea(); 
       tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
       tout.setSize(290, 300); 
       tout.setLocation(818, 130); 
       tout.setLineWrap(true); 
       tout.setEditable(false); 
       //c.
       add(tout); 
 
       res = new JLabel(""); 
       res.setFont(new Font("Arial", Font.PLAIN, 16)); 
       res.setSize(500, 25); 
       res.setLocation(820, 500); 
       //c.
       add(res); 
 
       resadd = new JTextArea(); 
       resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
       resadd.setSize(200, 75); 
       resadd.setLocation(880, 195); 
       resadd.setLineWrap(true); 
       //c.
       add(resadd);  
	}
	
	public void componentOfShipper() {
//		 c = getRootPane(); 
//	     c.setLayout(null); 
		typeUser = "Shipper";
		setLayout(null);
	  title = new JLabel("Registration Form For Delivery Man"); 
      title.setFont(new Font("Arial", Font.PLAIN, 30)); 
      title.setSize(500, 30); 
      title.setLocation(215, 50); 
      //c.
      add(title); 

      name = new JLabel("Name"); 
      name.setFont(new Font("Arial", Font.PLAIN, 20)); 
      name.setSize(100, 20); 
      name.setLocation(100, 120); 
//      c.add(name); 
      add(name);

      tname = new JTextField(); 
      tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tname.setSize(190, 20); 
      tname.setLocation(200, 120); 
      //c.
      add(tname); 
      
      accountName = new JLabel("Account Name");
      accountName.setFont(new Font("Arial", Font.PLAIN, 20));
      accountName.setSize(150, 20); 
      accountName.setLocation(400, 120);  
      add( accountName);
      
      taccountName = new JTextField(); 
      taccountName.setFont(new Font("Arial", Font.PLAIN, 15)); 
      taccountName.setSize(190, 20); 
      taccountName.setLocation(550, 120); 
      add(taccountName); 
      
      password = new JLabel("Password");
      password.setFont(new Font("Arial", Font.PLAIN, 20));
      password.setSize(100, 20); 
      password.setLocation(400, 170);  
      add(password);
      
      tpassword = new JTextField(); 
      tpassword.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tpassword.setSize(190, 20); 
      tpassword.setLocation(550, 170); 
      add(tpassword); 

      phoneNumber = new JLabel("Phone"); 
      phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20)); 
      phoneNumber.setSize(100, 20); 
      phoneNumber.setLocation(100, 170); 
      //c.
      add(phoneNumber); 

      tphoneNumber = new JTextField(); 
      tphoneNumber.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tphoneNumber.setSize(150, 20); 
      tphoneNumber.setLocation(200, 170); 
      //c.
      add(tphoneNumber); 

      gender = new JLabel("Gender"); 
      gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
      gender.setSize(100, 20); 
      gender.setLocation(100, 220); 
      //c.
      add(gender); 

      male = new JRadioButton("Male"); 
      male.setFont(new Font("Arial", Font.PLAIN, 15)); 
      male.setSelected(true); 
      male.setSize(75, 20); 
      male.setLocation(200, 220); 
      //c.
      add(male); 

      female = new JRadioButton("Female"); 
      female.setFont(new Font("Arial", Font.PLAIN, 15)); 
      female.setSelected(false); 
      female.setSize(80, 20); 
      female.setLocation(275, 220); 
      //c.
      add(female); 

      gengp = new ButtonGroup(); 
      gengp.add(male); 
      gengp.add(female); 

      dob = new JLabel("DOB"); 
      dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
      dob.setSize(100, 20); 
      dob.setLocation(100, 270); 
      //c.
      add(dob); 

      date = new JComboBox(dates); 
      date.setFont(new Font("Arial", Font.PLAIN, 15)); 
      date.setSize(50, 20); 
      date.setLocation(200, 270); 
      //c.
      add(date); 

      month = new JComboBox(months); 
      month.setFont(new Font("Arial", Font.PLAIN, 15)); 
      month.setSize(60, 20); 
      month.setLocation(250, 270); 
      //c.
      add(month); 

      year = new JComboBox(years); 
      year.setFont(new Font("Arial", Font.PLAIN, 15)); 
      year.setSize(60, 20); 
      year.setLocation(320, 270); 
      //c.
      add(year); 

      address = new JLabel("Address"); 
      address.setFont(new Font("Arial", Font.PLAIN, 20)); 
      address.setSize(100, 20); 
      address.setLocation(100, 320); 
      //c.
      add(address); 

      taddress = new JTextArea(); 
      taddress.setFont(new Font("Arial", Font.PLAIN, 15)); 
      taddress.setSize(200, 75); 
      taddress.setLocation(200, 320); 
      taddress.setLineWrap(true); 
      //c.
      add(taddress); 

      term = new JCheckBox("Accept Terms And Conditions."); 
      term.setFont(new Font("Arial", Font.PLAIN, 15)); 
      term.setSize(250, 20); 
      term.setLocation(350, 420); 
      //c.
      add(term); 

      sub = new JButton("Submit"); 
      sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
      sub.setSize(100, 20); 
      sub.setLocation(350, 480); 
      sub.addActionListener(this); 
      //c.
      add(sub); 

      reset = new JButton("Reset"); 
      reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
      reset.setSize(100, 20); 
      reset.setLocation(470, 480); 
      reset.addActionListener(this); 
      //c.
      add(reset); 
      
      tout = new JTextArea(); 
      tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tout.setSize(290, 300); 
      tout.setLocation(818, 130); 
      tout.setLineWrap(true); 
      tout.setEditable(false); 
      //c.
      add(tout); 

      res = new JLabel(""); 
      res.setFont(new Font("Arial", Font.PLAIN, 16)); 
      res.setSize(500, 25); 
      res.setLocation(820, 500); 
      //c.
      add(res); 

      resadd = new JTextArea(); 
      resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
      resadd.setSize(200, 75); 
      resadd.setLocation(880, 195); 
      resadd.setLineWrap(true); 
      //c.
      add(resadd);  
	}
	
	public void componentOfRestaurantOwner() {
		typeUser = "Restaurant";
		setLayout(null);
	  title = new JLabel("Registration Form For Business Partner"); 
      title.setFont(new Font("Amsterdam", Font.PLAIN, 30)); 
      title.setSize(600, 40); 
      title.setLocation(160, 50); 
      //c.
      add(title); 
		
      name = new JLabel("Name of Restaurant"); 
      name.setFont(new Font("Arial", Font.PLAIN, 20)); 
      name.setSize(200, 20); 
      name.setLocation(100, 100); 
//      c.add(name); 
      add(name);

      tname = new JTextField(); 
      tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tname.setSize(290, 20); 
      tname.setLocation(300, 100); 
      //c.
      add(tname); 
      
      accountName = new JLabel("Account Name");
      accountName.setFont(new Font("Arial", Font.PLAIN, 20));
      accountName.setSize(200, 20); 
      accountName.setLocation(100, 380);  
      add( accountName);
      
      taccountName = new JTextField(); 
      taccountName.setFont(new Font("Arial", Font.PLAIN, 15)); 
      taccountName.setSize(190, 20); 
      taccountName.setLocation(300, 380); 
      add(taccountName); 
      
      password = new JLabel("Password");
      password.setFont(new Font("Arial", Font.PLAIN, 20));
      password.setSize(100, 20); 
      password.setLocation(100, 430);  
      add(password);
      
      tpassword = new JTextField(); 
      tpassword.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tpassword.setSize(190, 20); 
      tpassword.setLocation(300, 430); 
      add(tpassword); 

      phoneNumber = new JLabel("Phone Number"); 
      phoneNumber.setFont(new Font("Arial", Font.PLAIN, 20)); 
      phoneNumber.setSize(200, 20); 
      phoneNumber.setLocation(100, 150); 
      //c.
      add(phoneNumber); 

      tphoneNumber = new JTextField(); 
      tphoneNumber.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tphoneNumber.setSize(250, 20); 
      tphoneNumber.setLocation(300, 150); 
      //c.
      add(tphoneNumber); 

      gender = new JLabel("Gender of Owner"); 
      gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
      gender.setSize(200, 20); 
      gender.setLocation(100, 200); 
      //c.
      add(gender); 

      male = new JRadioButton("Male"); 
      male.setFont(new Font("Arial", Font.PLAIN, 15)); 
      male.setSelected(true); 
      male.setSize(75, 20); 
      male.setLocation(300, 200); 
      //c.
      add(male); 

      female = new JRadioButton("Female"); 
      female.setFont(new Font("Arial", Font.PLAIN, 15)); 
      female.setSelected(false); 
      female.setSize(80, 20); 
      female.setLocation(375, 200); 
      //c.
      add(female); 

      gengp = new ButtonGroup(); 
      gengp.add(male); 
      gengp.add(female); 

      dob = new JLabel("Founding day"); 
      dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
      dob.setSize(200, 20); 
      dob.setLocation(100, 250); 
      //c.
      add(dob); 

      date = new JComboBox(dates); 
      date.setFont(new Font("Arial", Font.PLAIN, 15)); 
      date.setSize(50, 20); 
      date.setLocation(300, 250); 
      //c.
      add(date); 

      month = new JComboBox(months); 
      month.setFont(new Font("Arial", Font.PLAIN, 15)); 
      month.setSize(60, 20); 
      month.setLocation(350, 250); 
      //c.
      add(month); 

      year = new JComboBox(years); 
      year.setFont(new Font("Arial", Font.PLAIN, 15)); 
      year.setSize(60, 20); 
      year.setLocation(420, 250); 
      //c.
      add(year); 

      address = new JLabel("Address"); 
      address.setFont(new Font("Arial", Font.PLAIN, 20)); 
      address.setSize(200, 20); 
      address.setLocation(100, 290); 
      //c.
      add(address); 

      taddress = new JTextArea(); 
      taddress.setFont(new Font("Arial", Font.PLAIN, 15)); 
      taddress.setSize(200, 75); 
      taddress.setLocation(300, 285); 
      taddress.setLineWrap(true); 
      //c.
      add(taddress); 

      term = new JCheckBox("Accept Terms And Conditions."); 
      term.setFont(new Font("Arial", Font.PLAIN, 15)); 
      term.setSize(250, 20); 
      term.setLocation(350, 470); 
      //c.
      add(term); 

      sub = new JButton("Submit"); 
      sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
      sub.setSize(100, 20); 
      sub.setLocation(350, 500); 
      sub.addActionListener(this); 
      //c.
      add(sub); 

      reset = new JButton("Reset"); 
      reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
      reset.setSize(100, 20); 
      reset.setLocation(470, 500); 
      reset.addActionListener(this); 
      //c.
      add(reset); 

      tout = new JTextArea(); 
      tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
      tout.setSize(290, 300); 
      tout.setLocation(818, 130); 
      tout.setLineWrap(true); 
      tout.setEditable(false); 
      //c.
      add(tout); 

      res = new JLabel(""); 
      res.setFont(new Font("Arial", Font.PLAIN, 16)); 
      res.setSize(500, 25); 
      res.setLocation(820, 500); 
      //c.
      add(res); 

      resadd = new JTextArea(); 
      resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
      resadd.setSize(200, 75); 
      resadd.setLocation(880, 175); 
      resadd.setLineWrap(true); 
      //c.
      add(resadd);  
	}

	@Override
	public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
            if (term.isSelected()) { 
            	if(checkFulfill()) {
                String data1, dataGender, dataDob; 
                String data 
                    = "Name : "
                      + tname.getText() + "\n"
                      + "Phone Number : "
                      + tphoneNumber.getText() + "\n"; 
                if (male.isSelected()) { 
                    data1 = "Gender : Male"
                            + "\n"; 
                    dataGender = "Male";}
                else
                    {data1 = "Gender : Female"
                            + "\n"; 
                    dataGender = "Female";}
                String data2 
                    = "Date of birth : "
                      + (String)date.getSelectedItem() 
                      + "/" + (String)month.getSelectedItem() 
                      + "/" + (String)year.getSelectedItem() 
                      + "\n"; 
                dataDob = (String)year.getSelectedItem() 
                        + "/" + (String)month.getSelectedItem() 
                        + "/" + (String)date.getSelectedItem(); 
  
                String data3 = "Address : " + taddress.getText()+"\n"; 
                String data4 = "Account :"+taccountName.getText();
                tout.setText(data + data1 + data2 + data3+ data4); 
                tout.setEditable(false); 
                res.setText("Registration Successfully..");
                infoUser(taccountName.getText(), tpassword.getText(), typeUser, tname.getText(),taddress.getText(),tphoneNumber.getText(),
                		dataDob,dataGender);
            
//                MainFrame.getFrame().getJava2sql().updateRegisterInfo();}
                try {
                	System.out.println("InFo:"+newInfo()+"in Table:"+table);
					JavaConnect2SQL.updateInfoToSQL(table,newInfo());
					System.out.println("Update Success");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Dismiss info");
					e1.printStackTrace();
				}
                }
            	else res.setText("Please, fulfill information in form");
            } 
            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                		+ " terms & conditions.."); 
            }
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            taddress.setText(def); 
            tphoneNumber.setText(def); 
            res.setText(def); 
            tout.setText(def); 
            term.setSelected(false); 
            date.setSelectedIndex(0); 
            month.setSelectedIndex(0); 
            year.setSelectedIndex(0); 
            resadd.setText(def);
            taccountName.setText(def);
            tpassword.setText(def);
            
        } 
    }
	private boolean checkFulfill() {
		 if((!tname.getText().equals(""))&&(!taddress.getText().equals(""))&&(!tphoneNumber.getText().equals(""))&&
		            (!taccountName.getText().equals(""))&&(!tpassword.getText().equals("")))
			 //&&(date.getSelectedIndex()!=0)&&(month.getSelectedIndex()!=0)&&(year.getSelectedIndex()!=0))
		 
		            return true;
		return false;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {backGroundMenu = ImageIO.read(new File("ImageSource\\registerPane2.png"));
		   g.drawImage(backGroundMenu,0 ,0, null);} 
	  catch (IOException e) {e.printStackTrace();}
	}
	
	public static String infoUser(String username, String password, String typeUser, String name, String address, String phone, String dob, String gender) {
		info = "'"+username+"','"+password+"','"+typeUser+"','"+name+"','"+address+"','"+phone+"','"+dob+"','"+gender+"'";
		System.out.println(info);
		return info;
		
	}
	public static String newInfo() {
		return info;
	}
} 


