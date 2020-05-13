import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class OrderScreen {

	private JFrame frame;
	private JTable table;
	
	//change WHERE clause
	private String query;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel text0, text1, text2, text3, text4, text5, text6, text7;

	
	public void showFood() {
		if(RestaurantTable.getSelected() == true) { 
			query = "select M.ResNo, M.DishID, M.DishName, M.Category, M.Price, M.Image, R.ResName"
					+ " from Restaurant R, Menu M" 
					+ " where R.ResName = '" + RestaurantTable.getRes() + "' AND  M.ResNo = R.ResNo";
		} else {
			query = "select R.ResNo, M.DishID, M.DishName, M.Category, M.Price, M.Image, R.ResName"
					+ " from Restaurant R, Menu M" 
					+ " where (CHARINDEX('"+ AppScreen.getText() +"', M.DishName) > 0 AND  M.ResNo = R.ResNo)";
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[8];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			System.out.println(query);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				row[0] = rs.getString("ResNo");
				row[1] = rs.getString("DishID");
				row[2] = rs.getString("DishName");
				row[3] = rs.getString("Category");
				row[4] = rs.getString("Price");
				if (rs.getBytes("Image") != null) {
					ImageIcon image = new ImageIcon(new ImageIcon(rs.getBytes("Image")).getImage().getScaledInstance(100,
							120, Image.SCALE_SMOOTH));
					row[5] = image;
				} else {
					row[5] = null;}
				row[6] = rs.getString("ResName");
				row[7] = "0";
				model.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}	
	}
	
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodTable window = new FoodTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public OrderScreen() {
		initialize();
		showFood();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 784, 335);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 748, 213);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ResNo", "DishID", "DishName", "Category", "Price", "Image", "ResName", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, Byte.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Add amount");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = table.getSelectedRow();
				System.out.println(number);
				String qty = JOptionPane.showInputDialog("Enter amount");	
				table.getModel().setValueAt(qty, number, 7);
			}
		});
		btnNewButton.setBounds(528, 250, 101, 23);
		frame.getContentPane().add(btnNewButton);
		text0 = new JLabel();
		text1 = new JLabel();
		text2 = new JLabel();
		text3 = new JLabel();
		text4 = new JLabel();
		text5 = new JLabel();
		text6 = new JLabel();
		text7 = new JLabel();
		
		btnNewButton_1 = new JButton("Add to cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = table.getSelectedRow();
				
				text0.setText((String) table.getValueAt(number,0));
				String resNo = text0.getText();
				
				text1.setText((String) table.getValueAt(number,1));
				String dishID = text1.getText();
				
				text2.setText((String) table.getValueAt(number,2));
				String dishName = text2.getText();
				
				text3.setText((String) table.getValueAt(number,3));
				String u3 = text3.getText();
				
				text4.setText((String) table.getValueAt(number,4));
				String price = text4.getText();
				
				text5.setText((String) table.getValueAt(number,5));
				String u5 = text5.getText();
				
				text6.setText((String) table.getValueAt(number,6));
				String resName = text6.getText();
				
				text7.setText((String) table.getValueAt(number,7));
				String amount = text7.getText();
				
				System.out.println(Customer.getCusPhone());
//				System.out.println("T IN NE: "+ table.getValueAt(number,6));
//				System.out.println("U nè: "+u);
				
/*				CartScreen(String resNo, String resName, dishID, dishName, Price, Amount) 
 * 
				CartScreen cart = new CartScreen(resNo, resName, dishID, dishName, price, amount);
				CartScreen cart = new CartScreen(resNo, resName, Customer.getCusNo(), Customer.getCusAddress(), Customer.getCusPhone, table);*/
			}
	//		CartScreen(String resNo, String resName, String cusNo, String cusAddress, String cusPhone, JTable table
		});
		btnNewButton_1.setBounds(657, 250, 101, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					if(AppScreen.isSearchingRes(AppScreen.getText()) == true && AppScreen.isSearchingFood(AppScreen.getText()) == false) {
//					RestaurantTable rt = new RestaurantTable();
						RestaurantTable.display();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(406, 250, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
