import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CartScreen extends JPanel implements ActionListener {

	private String CusNo, ResNo;
	private JLabel resName, cusAddress, cusPhone, address, phone, cart, noteShip;
	private JTextField tcusAddress, tcusPhone, tnoteShip, ttotalPrice, tshipFee, tdishPrice; 
	private JButton btneditAddress, btneditPhone, btnchangeAddress, btnchangePhone, btnback, btnconfirm;
	
	static DefaultTableModel tableCartModel = new DefaultTableModel();
	private JTable table, tableCart;
	
	public CartScreen(String resNo, String resName, String cusNo, String cusAddress, String cusPhone, JTable table) {
		this.ResNo = resNo;
		this.CusNo = cusNo;
		this.resName = new JLabel(resName);
		this.cusAddress = new JLabel(cusAddress);
		this.cusPhone = new JLabel(cusPhone);
		this.table = table;
		CartComponent();
	}

	public void CartComponent() {
		setLayout(null);
		resName.setFont(new Font("Arial", Font.ITALIC, 20));
		resName.setSize(500, 50);
		resName.setLocation(150, 5);
		add(resName);
		
		cart = new JLabel("Order Cart");
		cart.setFont(new Font("Goudy Stout", Font.ITALIC, 30));
		cart.setSize(500, 50);
		cart.setLocation(420, 20);
		add(cart);
		
		address = new JLabel("Delivery destination");
		address.setFont(new Font("Arial", Font.PLAIN, 20));
		address.setSize(400, 20);
		address.setLocation(150, 90);
		add(address);
		
		cusAddress.setFont(new Font("Arial", Font.BOLD, 20));
		cusAddress.setSize(500, 20);
		cusAddress.setLocation(150, 120);
		add(cusAddress);
	    
	    tcusAddress = new JTextField();
		tcusAddress.setFont(new Font("Arial", Font.PLAIN, 20));
		tcusAddress.setSize(300, 20);
		tcusAddress.setLocation(600,150);
		add(tcusAddress);
		tcusAddress.setVisible(false);
	      
		phone = new JLabel("Phone Number");
		phone.setFont(new Font("Arial", Font.PLAIN, 20));
		phone.setSize(200, 20);
		phone.setLocation(150, 180);
		add(phone);
		
		cusPhone.setFont(new Font("Arial", Font.BOLD, 20));
		cusPhone.setSize(200, 20);
		cusPhone.setLocation(150, 210);
		add(cusPhone);
		
		tcusPhone = new JTextField();
		tcusPhone.setFont(new Font("Arial", Font.PLAIN, 20));
		tcusPhone.setSize(300, 20);
		tcusPhone.setLocation(600, 240);
		add(tcusPhone);
		tcusPhone.setVisible(false);
		
		btneditAddress = new JButton("Edit");
		btneditAddress.setBounds(1000, 120, 100, 20);
		btneditAddress.addActionListener(this);
		add(btneditAddress);
		
		btneditPhone = new JButton("Edit");
		btneditPhone.setBounds(1000, 210, 100, 20);
		btneditPhone.addActionListener(this);
		add(btneditPhone);
		
		btnchangeAddress = new JButton("Change");
		btnchangeAddress.setBounds(1000, 150, 100, 20);
		btnchangeAddress.addActionListener(this);
		add(btnchangeAddress);
		btnchangeAddress.setVisible(false);
		
		btnchangePhone = new JButton("Change");
		btnchangePhone.setBounds(1000, 240, 100, 20);
		btnchangePhone.addActionListener(this);
		add(btnchangePhone);
		btnchangePhone.setVisible(false);
		
		btnback = new JButton("Back");
		btnback.setBounds(10, 10, 50, 50);
		btnback.addActionListener(this);
		add(btnback);
		
		btnconfirm = new JButton("Make order");
		btnconfirm.setBounds(1000, 500, 100, 20);
		btnconfirm.addActionListener(this);
		add(btnconfirm);

		noteShip = new JLabel("Note for shipper");
		noteShip.setFont(new Font("Arial", Font.PLAIN, 20));
		noteShip.setSize(200, 20);
		noteShip.setLocation(150, 270);
		add(noteShip);
		
		tnoteShip = new JTextField();
		tnoteShip.setFont(new Font("Arial", Font.PLAIN, 20));
		tnoteShip.setSize(300, 20);
		tnoteShip.setLocation(150, 300);
		add(tnoteShip);
		
		tableCart = new JTable();
		String colsName[] = {"DishID", "DishName", "Amount", "Total Price", "Apply Discount"};
		tableCartModel.setColumnIdentifiers(colsName);
		tableCart.setModel(tableCartModel);
		tableCart.setRowHeight(30);
		JScrollPane scroll = new JScrollPane(tableCart);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setLocation(300, 350);
		scroll.setSize(600, 180);
		add(scroll);
		
		tableCart.getColumnModel().getColumn(0).setMinWidth(0);
		tableCart.getColumnModel().getColumn(0).setMaxWidth(0);
		tableCart.getColumnModel().getColumn(0).setWidth(0);
		
		TableModel ttModel = table.getModel();
		for (int i = 0; i < ttModel.getRowCount(); i++) {
			try {
				JavaConnect2SQL.searchMenuInfo2("Menu", ResNo, (String) ttModel.getValueAt(i, 0),
						(String) ttModel.getValueAt(i, 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		JLabel dishPrice = new JLabel("Dish Price");
		dishPrice.setBounds(940, 350, 200, 50);
		dishPrice.setFont(new Font("Serif", Font.ITALIC, 18));
		add(dishPrice);
		
		tdishPrice = new JTextField();
		tdishPrice.setBounds(1040, 365, 100, 20);
		add(tdishPrice);
		tdishPrice.setText(""+getSumDish()+"");
		
		JLabel shipFee = new JLabel("Shipping Fee");
		shipFee.setBounds(940, 400, 200, 50);
		shipFee.setFont(new Font("Serif", Font.ITALIC, 18));
		add(shipFee);
		
		tshipFee = new JTextField();
		tshipFee.setBounds(1040,415, 100, 20);
		add(tshipFee);
		tshipFee.setText("15000");
		
		JLabel orderPrice = new JLabel("TOTAL");
		orderPrice.setBounds(940, 450, 200, 50);
		orderPrice.setFont(new Font("Serif", Font.ITALIC, 18));
		add(orderPrice);
		
		ttotalPrice  = new JTextField();
		ttotalPrice.setBounds(1040, 465, 100, 20);
		add(ttotalPrice);
		ttotalPrice.setText(""+getSum()+"");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btneditAddress) {
			System.out.println("edit address");
			tcusAddress.setVisible(true);
			btnchangeAddress.setVisible(true);
		}
		if (e.getSource() == btneditPhone) {
			System.out.println("edit phone");
			tcusPhone.setVisible(true);
			btnchangePhone.setVisible(true);
		}

		if (e.getSource() == btnchangeAddress) {
			System.out.println("change address");
			tcusAddress.setVisible(false);
			btnchangeAddress.setVisible(false);
			if(!tcusAddress.getText().equals(""))cusAddress.setText(tcusAddress.getText());
		}
		if (e.getSource() == btnchangePhone) {
			System.out.println("change phone");
			tcusPhone.setVisible(false);
			btnchangePhone.setVisible(false);
			if(!tcusPhone.getText().equals(""))cusPhone.setText(tcusPhone.getText());
		}

		if (e.getSource() == btnback) {
			System.out.println("back");
		} // tcusAddress.setVisible(false);btnchangeAddress.setVisible(false);}
		if (e.getSource() == btnconfirm) {
			try {
				JavaConnect2SQL.updateInfoToSQL("Orders", dataOrder(ResNo, CusNo, ttotalPrice.getText()));
				
				
				
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			for (int i = 0; i < tableCartModel.getRowCount(); i++) {
				System.out.println("make order");
				try {
					JavaConnect2SQL.updateInfoToSQL("BasedOn", dataBasedOnOrder(
							(String) tableCartModel.getValueAt(i, 0), (String) tableCartModel.getValueAt(i, 2)));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} // for
		}//if 
	}
	
	private String dataBasedOnOrder(String dishID, String amount) throws Exception {
		int orderID = JavaConnect2SQL.findNewBillID("OrderID");
		String basedOnInfo = "null,'"+orderID+"','"+dishID+"','"+amount+"'";
		System.out.println(basedOnInfo);
//		rbillID = orderID;
		return basedOnInfo;
	}
	private String dataOrder(String resNo, String cusNo, String orderPrice) {
		String billInfo = "'HCM','"+resNo+"','"+cusNo+"',"+"null,'"+ orderPrice+"','Unaccepted'";
		System.out.println(billInfo);
		return billInfo;
}
	public int getSumDish() {
		int sum = 0; 
		for(int i = 0; i < tableCart.getRowCount();i++) {
			sum += Integer.parseInt((String) tableCart.getValueAt(i, 4));
		}
		System.out.println("TOTAL PRICE OF BILL: "+sum);
		return sum;
	}
	public int getSum() {
		int sum = 0; 
		int dishPrice = Integer.parseInt(tdishPrice.getText());
		int shipFee = Integer.parseInt(tshipFee.getText());
		sum = dishPrice + shipFee;
		return sum;
	}
	
}
