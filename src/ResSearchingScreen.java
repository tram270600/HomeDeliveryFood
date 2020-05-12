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
import java.awt.event.ActionEvent;

public class ResSearchingScreen {

	private JFrame frame;
	private JTable table;
	private static String res;
	private static boolean isSelected = false;
	
	public void displayRes() {
		Query qr = new Query();
		ArrayList<RestaurantPanel> list = qr.resTable();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[7];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getName();
			row[1] = list.get(i).getAddress();
			model.addRow(row);
		}
	}
	
	public static void orderScreen() {
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
	public RestaurantTable() {
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
				OrderScreen o = new OrderScreen();
				o.orderScreen();
				frame.setVisible(false);
			}
			});
		btnNewButton.setBounds(333, 259, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
