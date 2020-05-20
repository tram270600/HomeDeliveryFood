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
	private JDialog jDialog1;
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
// 		frame = new JFrame();
// 		frame.setBounds(100, 100, 777, 344);
// 		frame.getContentPane().setLayout(null);
		
// 		JScrollPane scrollPane = new JScrollPane();
// 		scrollPane.setBounds(10, 11, 741, 216);
// 		frame.getContentPane().add(scrollPane);
		
		
// 		table = new JTable();
// 		table.setModel(new DefaultTableModel(
// 			new Object[][] {
// 			},
// 			new String[] {
// 				"ResNo", "ResName"
// 			}
// 		) {
// 			Class[] columnTypes = new Class[] {
// 				String.class, String.class
// 			};
// 			public Class getColumnClass(int columnIndex) {
// 				return columnTypes[columnIndex];
// 			}
// 		});
// 		scrollPane.setViewportView(table);
		
// 		JLabel getRes = new JLabel();
		
// 		JButton btnNewButton = new JButton("Select");
// 		btnNewButton.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				isSelected = true;
// 				int number = table.getSelectedRow();
// 				getRes.setText(table.getValueAt(number,1).toString());
// 				res = getRes.getText();
// 				System.out.println(res);
// 				System.out.println(number);
// 				FoodTable f = new FoodTable();
// 				f.display();
// 				frame.setVisible(false);
// 			}
// 			});
// 		btnNewButton.setBounds(401, 257, 89, 23);
// 		frame.getContentPane().add(btnNewButton);
		
// 		JButton btnNewButton_1 = new JButton("Back");
// 		btnNewButton_1.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				frame.dispose();
// 			}
// 		});
// 		btnNewButton_1.setBounds(273, 257, 89, 23);
// 		frame.getContentPane().add(btnNewButton_1);
	jDialog1 = new javax.swing.JDialog();
	jDialog1.setLocation(450, 200);
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        JButton jButton1 = new javax.swing.JButton();
        JButton jButton2 = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ResNo", "Restaurant name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jButton1.setText("Back");
        jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jDialog1.setVisible(false);
			}
		});
        
        JLabel getRes = new JLabel();
        
        jButton2.setText("Select");
        jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSelected = true;
				int number = table.getSelectedRow();
				getRes.setText(table.getValueAt(number,1).toString());
				res = getRes.getText();
				System.out.println(res);
				System.out.println(number);
				FoodTable f = new FoodTable();
				f.display();
				jDialog1.setVisible(false);
			}
			});
        
        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        jDialog1.pack();
        jDialog1.setModal(true);
	}
}
