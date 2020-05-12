import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Query {
	
	public ArrayList<RestaurantMenu> table(String query) {
		ArrayList<RestaurantMenu> list = new ArrayList<RestaurantMenu>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			System.out.println(query);
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			RestaurantMenu r;
			while (rs.next()) {
				r = new RestaurantMenu(rs.getString("ResNo"),rs.getString("DishID"), rs.getString("DishName"), rs.getString("Category"),
						rs.getString("Price"), rs.getBytes("Image"), rs.getString("ResName"));
				list.add(r);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return list;
	}
	
	public ArrayList<RestaurantPanel> resTable() {
		ArrayList<RestaurantPanel> list = new ArrayList<RestaurantPanel>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-CME024L\\SQLEXPRESS:1433;databaseName=DataProject;integratedSecurity=true";
			Connection connection = DriverManager.getConnection(connectionURL, "sa", "hai01256445678");
			String query = "select R.ResNo, R.ResName"
					+ " from Restaurant R"
					+ " where CHARINDEX('KFC', ResName) > 0";
			System.out.println(query);		
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			RestaurantPanel r;
			while (rs.next()) {
				r = new RestaurantPanel(rs.getString("ResNo"), rs.getString("ResName"));						
				list.add(r);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return list;
	}
	
}
