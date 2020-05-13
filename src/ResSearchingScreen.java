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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ResSearchingScreen {

	private JFrame frame;
	private JTable table;
	private static String res;
	private static boolean isSelected = false;
	
	public void displayRes() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[2];
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query = "select R.ResNo, R.ResName"
					+ " from Restaurant R"
					+ " where CHARINDEX('"+ AppScreen.getText() +"', ResName) > 0";
			System.out.println(query);		
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				row[0] = rs.getString("ResNo");	
				row[1] = rs.getString("ResName");
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
					RestaurantTable window = new RestaurantTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResSearchingScreen() {
		initialize();
		displayRes();
	}
	
	

	public static boolean getSelected() {
		return isSelected;
	}
	
	public static String getRes() {
		System.out.println(res);
		return res;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 777, 344);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 741, 216);
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ResNo", "ResName"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel getRes = new JLabel();
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSelected = true;
				int number = table.getSelectedRow();
				getRes.setText(table.getValueAt(number,1).toString());
				res = getRes.getText();
				System.out.println(res);
				System.out.println(number);
				FoodTable f = new FoodTable();
				f.display();
				frame.setVisible(false);
			}
			});
		btnNewButton.setBounds(401, 257, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(273, 257, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
