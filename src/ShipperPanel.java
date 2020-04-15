

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

public class ShipperPanel {
	private JFrame frame;
		


		

	public ShipperPanel() {
		ShipperPanelComponent();
	}

	
	private void ShipperPanelComponent() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(178, 0, 1008, 563);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
	
		
		JPanel TransactionHistory = new JPanel();
		layeredPane.add(TransactionHistory, "name_1056410234313800");
		TransactionHistory.setLayout(null);
		TransactionHistory.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(175, 140, 400, 145);
		TransactionHistory.add(lblNewLabel);
		
		JPanel Order = new JPanel();
		layeredPane.add(Order, "name_1056416579217300");
		Order.setVisible(false);
		Order.setLayout(null);
		
		JLabel reAdd = new JLabel("Receiving Address");
		reAdd.setBounds(0, 0, 303, 563);
		reAdd.setHorizontalAlignment(SwingConstants.CENTER);
		reAdd.setVerticalAlignment(SwingConstants.TOP);
		reAdd.setFont(new Font("Castellar", Font.PLAIN, 18));
		Order.add(reAdd);
		
		JLabel deliAdd = new JLabel("Delivery Address");
		deliAdd.setBounds(354, 0, 344, 553);
		deliAdd.setVerticalAlignment(SwingConstants.TOP);
		deliAdd.setHorizontalAlignment(SwingConstants.CENTER);
		deliAdd.setFont(new Font("Castellar", Font.PLAIN, 18));
		Order.add(deliAdd);
		
		JLabel label = new JLabel("New label");
		label.setBounds(962, 7, -136, 245);
		Order.add(label);
		
		JPanel Rating = new JPanel();
		layeredPane.add(Rating, "name_1060048078321400");
		Rating.setLayout(null);
		
		JCheckBox vbad = new JCheckBox("Very Bad");
		vbad.setBounds(78, 49, 95, 21);
		Rating.add(vbad);
		
		JCheckBox bad = new JCheckBox("Bad");
		bad.setBounds(78, 78, 95, 21);
		Rating.add(bad);
		
		JCheckBox normal = new JCheckBox("Normal");
		normal.setBounds(78, 109, 95, 21);
		Rating.add(normal);
		
		JCheckBox good = new JCheckBox("Good");
		good.setBounds(78, 138, 95, 21);
		Rating.add(good);
		
		JCheckBox vgood = new JCheckBox("Very Good");
		vgood.setBounds(78, 170, 95, 21);
		Rating.add(vgood);
		
		JEditorPane comment = new JEditorPane();
		comment.setFont(new Font("SansSerif", Font.PLAIN, 14));
		comment.setText("Comments");
		comment.setBounds(405, 49, 473, 142);
		Rating.add(comment);
		
		JButton btnHistory = new JButton("Transaction History");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order.setVisible(false);
				TransactionHistory.setVisible(true);
				Rating.setVisible(false);
			}
		});
		btnHistory.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnHistory.setBounds(0, 0, 176, 190);
		frame.getContentPane().add(btnHistory);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order.setVisible(true);
				TransactionHistory.setVisible(false);
				Rating.setVisible(false);
			}
		});
		btnOrder.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnOrder.setBounds(0, 189, 176, 190);
		frame.getContentPane().add(btnOrder);
		
		JButton btnRating = new JButton("Rating ");
		btnRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order.setVisible(false);
				TransactionHistory.setVisible(false);
				Rating.setVisible(true);
			}
		});
		btnRating.setFont(new Font("Castellar", Font.PLAIN, 10));
		btnRating.setBounds(0, 373, 176, 190);
		frame.getContentPane().add(btnRating);
	}
}
