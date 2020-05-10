import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderHistory {

	private JFrame frmOrderHistory;
	private JTable jTable_display_order;
	private Customer customer;
	private String CusNo;
	private Connection connection = null;

	public ArrayList<Order> orderList() {

		ArrayList<Order> ordersList = new ArrayList<>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query1 = "SELECT * FROM Orders WHERE CusNo = (SELECT C.CusNo"
															+ " FROM Customer C, Users U"
															+ " WHERE U.Username = '" + SignInPanel.getUsername()
															+ "' AND U.UserID = C.UserID)";
			System.out.println(query1);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query1);
			Order order;
			while (rs.next()) {
				order = new Order(rs.getString("ServerID"),rs.getInt("OrderID"), rs.getString("ResNo"), rs.getInt("CusNo"),
						rs.getInt("ShipNo"), rs.getString("OrderPrice"), rs.getString("OrderStatus"));
				ordersList.add(order);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return ordersList;
	}

	public void showOrder() {
		ArrayList<Order> list = orderList();
		DefaultTableModel model = (DefaultTableModel) jTable_display_order.getModel();
		Object[] row = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getServerID();
			row[1] = list.get(i).getOrderID();
			row[2] = list.get(i).getResNo();
			row[3] = list.get(i).getCusNo();
			row[4] = list.get(i).getShipNo();
			row[5] = list.get(i).getOrderPrice();
			row[6] = list.get(i).getOrderStatus();
			model.addRow(row);
		}
	}

	public static void orderScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHistory window = new OrderHistory();
					window.frmOrderHistory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrderHistory() {
		initialize();
		showOrder();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOrderHistory = new JFrame();
		frmOrderHistory.setTitle("Order History");
		frmOrderHistory.setBounds(100, 100, 657, 366);
		frmOrderHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmOrderHistory.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 621, 168);
		frmOrderHistory.getContentPane().add(scrollPane);

		jTable_display_order = new JTable();
		jTable_display_order.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ServerID", "OrderID", "ResNo", "CusNo", "ShipNo", "Order Price", "Order Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, Integer.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(jTable_display_order);
	}
}
