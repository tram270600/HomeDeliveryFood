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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderHistory {
	private JDialog jDialog1;
	private JFrame frmOrderHistory;
	private JTable jTable_display_order;
	private Customer customer;
	private String CusNo;
	private Connection connection = null;
	private JButton btnNewButton;


	public void showOrder() {
		DefaultTableModel model = (DefaultTableModel) jTable_display_order.getModel();
		Object[] row = new Object[7];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query = "SELECT * FROM Orders WHERE OrderStatus = 'Done' AND CusNo = (SELECT C.CusNo"
					+ " FROM Customer C, Users U"
					+ " WHERE U.Username = '" + SignInPanel.getUsername()
					+ "' AND U.UserID = C.UserID)";
			System.out.println(query);		
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				row[0] = rs.getString("ServerID");	
				row[1] = rs.getString("OrderID");
				row[2] = rs.getString("ResNo");	
				row[3] = rs.getInt("CusNo");
				row[4] = rs.getInt("ShipNo");	
				row[5] = rs.getString("OrderPrice");
				row[6] = rs.getString("OrderStatus");	
				model.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public static void orderScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderHistory window = new OrderHistory();
					window.jDialog1.setVisible(true);
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
// 		frmOrderHistory = new JFrame();
// 		frmOrderHistory.setTitle("Order History");
// 		frmOrderHistory.setBounds(375, 170, 657, 366);
// 		frmOrderHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// 		frmOrderHistory.getContentPane().setLayout(null);

// 		JScrollPane scrollPane = new JScrollPane();
// 		scrollPane.setBounds(10, 11, 621, 168);
// 		frmOrderHistory.getContentPane().add(scrollPane);

// 		jTable_display_order = new JTable();
// 		jTable_display_order.setModel(new DefaultTableModel(
// 			new Object[][] {
// 			},
// 			new String[] {
// 				"ServerID", "OrderID", "ResNo", "CusNo", "ShipNo", "Order Price", "Order Status"
// 			}
// 		) {
// 			Class[] columnTypes = new Class[] {
// 				String.class, Integer.class, String.class, Integer.class, Integer.class, String.class, String.class
// 			};
// 			public Class getColumnClass(int columnIndex) {
// 				return columnTypes[columnIndex];
// 			}
// 			boolean[] columnEditables = new boolean[] {
// 				false, true, true, true, true, true, true
// 			};
// 			public boolean isCellEditable(int row, int column) {
// 				return columnEditables[column];
// 			}
// 		});
// 		scrollPane.setViewportView(jTable_display_order);
		
// 		btnNewButton = new JButton("Back");
// 		btnNewButton.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				Customer.activity();
// 				frmOrderHistory.setVisible(false);
// 			}
// 		});
// 		btnNewButton.setBounds(275, 231, 89, 23);
// 		frmOrderHistory.getContentPane().add(btnNewButton);
// 		//scrollPane.getViewport().add(jTable_display_order, null);
		jDialog1 = new javax.swing.JDialog();
        jDialog1.setModal(true);
        jDialog1.setLocation(400, 200);
       
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 621, 168);
        
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
		});
		scrollPane.setViewportView(jTable_display_order);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDialog1.setVisible(false);
				Customer.activity();
			}
		});
		
		javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
		jDialog1Layout.setHorizontalGroup(
			jDialog1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jDialog1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(10, Short.MAX_VALUE))
				.addGroup(jDialog1Layout.createSequentialGroup()
					.addContainerGap(555, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		jDialog1Layout.setVerticalGroup(
			jDialog1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jDialog1Layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1.pack();
	}
}
