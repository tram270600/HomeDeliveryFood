

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
//import com.sun.jdi.connect.spi.Connection;

public class JavaConnect2SQL {
	public static String infoType, infoName, infoAddress, infoPhone; 
	public static String getInfoType() {
		return infoType;
	}
	public static void setInfoType(String infoType) {
		JavaConnect2SQL.infoType = infoType;
	}
	public static String getInfoName() {
		return infoName;
	}
	public static void setInfoName(String infoName) {
		JavaConnect2SQL.infoName = infoName;
	}
	public static String getInfoAddress() {
		return infoAddress;
	}
	public static void setInfoAddress(String infoAddress) {
		JavaConnect2SQL.infoAddress = infoAddress;
	}
	public static String getInfoPhone() {
		return infoPhone;
	}
	public static void setInfoPhone(String infoPhone) {
		JavaConnect2SQL.infoPhone = infoPhone;
	}

	static Connection connection = null;
	public static Connection getConnection() {
		return connection;
	}
	public static void setConnection(Connection connection) {
		JavaConnect2SQL.connection = connection;
	}

//	MainFrame mainFrame = MainFrame.getFrame();
	public static Connection connectToSQL() throws SQLException{
//		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://MSI:1433;databaseName=HomeDeliveryFood;integratedSecurity=true;";
			connection = DriverManager.getConnection(connectionURL, "sa", "ngntram2706");
			System.out.println("Successssss");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error when connect database");
			System.err.println(e.getMessage()+"\n"+e.getClass()+"\n"+e.getCause());
		//	e.printStackTrace();
		}
		return connection;
	}
	public static void updateInfoToSQL(String table, String info)throws SQLException{
		connectToSQL();
//		String info = MainFrame.getPanel().getLoginPanel().getSignUp().getRegisterPanel().updateInfo();
		try (Statement st = connection.createStatement();){
			String sqlInsert = "INSERT INTO "+ table +" VALUES("+info+");";
			System.out.println("SQL INSERT:"+sqlInsert);
			int numberRowsAffected = st.executeUpdate(sqlInsert);
			System.out.println("Affected rows after inserted: "+numberRowsAffected);
			}
	}
	public static boolean searchInfo(String user, String password) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT * FROM Registration WHERE Username ="+"'"+user+"' AND Password ="+"'"+password+"'";
		System.out.println(sqlSelect);
	    try (
	            Statement st = connection.createStatement(
	            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = st.executeQuery(sqlSelect);
	        ) {
	    	if(rs.next()) {showUserInfo(rs);
			infoType = rs.getString(4);
			infoName = rs.getString(5);
			infoAddress = rs.getString(6);
			infoPhone = rs.getString(7);
			return true;}
	        else return false;
	     
	}
		}
	
/*	public static void main(String[] args) throws SQLException {
		connectToSQL();
	Connection connection = null;
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionURL = "jdbc:sqlserver://MSI:1433;databaseName=Restaurant;integratedSecurity=true;";
		connection = DriverManager.getConnection(connectionURL, "sa", "ngntram2706");
		System.out.println("Successssss");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Error when connect database");
		System.err.println(e.getMessage()+"\n"+e.getClass()+"\n"+e.getCause());
	//	e.printStackTrace();
	}
*/	
	//Insert
/*	try (Statement st = connection.createStatement();){
	String sqlInsert = "INSERT INTO restaurants(Name, Address, Phone, Date, Gender)"+"VALUES('Yi Hae Tang','Tran Van Dang','0903660153',2010/10/21,'Male');";
	int numberRowsAffected = st.executeUpdate(sqlInsert);
	System.out.println("Affected rows after inserted: "+numberRowsAffected);
	}
*/	
/*	String sqlSelect = "SELECT * FROM restaurants";
    try (
          //  Connection con = ConnectionUtils.openConnection();
            Statement st = connection.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery(sqlSelect);
        ) {

        while (rs.next()) {
            showUserInfo(rs);
        }

        System.out.println("\n=== Move to previous row ===");
        while (rs.previous()) {
            showUserInfo(rs);
        }
         
        System.out.println("\n=== Move to last row ===");
        rs.last();
        showUserInfo(rs);
         
        System.out.println("\n=== Move to first row ===");
        rs.first();
        showUserInfo(rs);
    }
}
*/ 
private static void showUserInfo(ResultSet rs) throws SQLException {
	String typeUser;
	System.out.println("Type User: "+rs.getString(3));
    System.out.println("Name: " + rs.getString(5));
    System.out.println("Address: " + rs.getString(6));
    System.out.println("Phone: " + rs.getString(7));
    System.out.println("CreatedDate: " + rs.getDate(8));
    System.out.println("Gender Of Owner:"+rs.getString(9));
    System.out.println("---");
}
}
	


