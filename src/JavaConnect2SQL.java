import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
//import com.sun.jdi.connect.spi.Connection;

public class JavaConnect2SQL {
	public static String infoType, infoName, infoAddress, infoPhone, infoUserId, infoTransfer, infoResNo; 
	
	public static String getInfoTransfer() {
		return infoTransfer;
	}
	public static void setInfoTransfer(String infoTransfer) {
		JavaConnect2SQL.infoTransfer = infoTransfer;
	}
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

		return connection;}
	
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
	public static void searchResInfo(String table, String ResNo) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT * FROM " + table +" M, Restaurant R WHERE M.ResNo = R.ResNo AND R.ResNo = '"+ResNo+"';";
		System.out.println(sqlSelect);
	    try (
	            Statement st = connection.createStatement(
	            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = st.executeQuery(sqlSelect);
	    		
	        ) {
	    	while(rs.next()) {
	    	//	showUserInfo(rs);
				if (table.equals("Menu")) {
					infoName = rs.getString(2);
					infoType = rs.getString(3);
					infoAddress = rs.getString(4);
					infoPhone = rs.getString(5);
					MainFrame.getMainFrame().panel.loginPanel.signIn.res.showMenuDish();
				}
				if (table.equals("Ingredient")) {
					infoAddress = rs.getString("IngredientID");
					infoName = rs.getString("IngredientName");
					infoType = rs.getString("IngredientAmount");
					infoPhone = rs.getString("IngredientPrice");
					MainFrame.getMainFrame().panel.loginPanel.signIn.res.showIngredient();
				}
				if (table.equals("Event")) {
					infoAddress = rs.getString("EventContent");
					infoName = rs.getString("EventName");
					infoType = rs.getString("StartDate");
					infoPhone = rs.getString("EndDate");
					MainFrame.getMainFrame().panel.loginPanel.signIn.res.showEvent();
				}
	    	}
	     
	}
	}

	public static void searchMenuInfo(String table, String ResNo, String DishName, String Amount) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT * FROM " + table +" M, Restaurant R WHERE M.ResNo = R.ResNo AND R.ResNo = '"+ResNo+"' AND M.DishName = '"+ DishName + "';";
		System.out.println(sqlSelect);
	   
	            
		
		try (Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = st.executeQuery(sqlSelect);
		) {
			
			while (rs.next()) {
				String rows[] = new String[6];
				rows[0] = rs.getString("DishID");
				rows[1] = DishName;
				rows[2] = rs.getString("Price");
				rows[3] = Amount;
				int price = Integer.parseInt(rs.getString("Price"));
				int amount = Integer.parseInt(Amount);
				int totalPrice = price * amount;
				rows[4] = "" +totalPrice+ "";
				int eventPrice = calculateDiscount(rs.getString("EventID"), totalPrice);
				rows[5] = ""+eventPrice+"";

				MainFrame.getMainFrame().panel.loginPanel.signIn.res.tableOrderModel.addRow(rows);
			}
		}
		
	    }
	
	public static int calculateDiscount(String EventID, int Amount) throws Exception {
		int priceApplyEvent = Amount;
		System.out.println("Amount in cal: "+Amount);
		connectToSQL();
		String sqlSelect = "SELECT * FROM Event E WHERE E.EventID = '"+EventID+ "';";
		System.out.println(sqlSelect);
		
		try (Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = st.executeQuery(sqlSelect);
		) {
			while (rs.next()) {
				String eventContent;
				eventContent = rs.getString("EventContent");
				switch(eventContent) {
				case "Discount 20%":
					{priceApplyEvent = (int) (Amount*(1 - 0.2));
					System.out.println("Discount 20%: "+priceApplyEvent);}
					return priceApplyEvent;
				case "Discount 10%":
					{priceApplyEvent = (int) (Amount*(1-0.1));
					return priceApplyEvent;}
				case "Discount 50%":
					{priceApplyEvent = (int) (Amount*(1-0.5));
					return priceApplyEvent;}
				}
			}
		}
		System.out.println("Price apply event"+priceApplyEvent);
		return priceApplyEvent;
	    }
	
	
/*	public static ResultSet view(String table, String ResNo) throws Exception {
		connectToSQL();
		ResultSet result = null;
		String sqlSelect = "SELECT * FROM "+table+" M WHERE M.ResNo = '"+ResNo+"'";
		System.out.println(sqlSelect);
		try {
		Statement statement = (Statement) connection.createStatement();
		return statement.executeQuery(sqlSelect);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void updateData(ResultSet result) {
		System.out.println("FUKKKKKKKKKKKKKKKKKKKKKKKKKK");
		try {
			while(result.next()) {
				String rows[] = new String[9];
				rows[0] = result.getString("DishID");
				rows[1] = result.getString("DishName");
				rows[0] = result.getString("Category");
				rows[0] = result.getString("Description");
				rows[0] = result.getString("Price");
				rows[0] = result.getString("Ingredient1");
				rows[0] = result.getString("Ingredient2");
				rows[0] = result.getString("ApplyDate");
				rows[0] = result.getString("EventID");
				System.out.println("row[0]: "+rows[0]);
				if(rows[0]!= null) MainFrame.getMainFrame().panel.loginPanel.signIn.res.tableModel.addRow(rows);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	public static void view(String table, String ResNo) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT * FROM "+table+" M WHERE M.ResNo = '"+ResNo+"'";
		System.out.println(sqlSelect);
		try (Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery(sqlSelect);

		) {
			
			while (rs.next()) {
				String rows[] = new String[9];
				rows[0] = rs.getString("DishID");
				System.out.println(rs.getString("DishID"));
				rows[1] = rs.getString("DishName");
				rows[2] = rs.getString("Category");
				rows[3] = rs.getString("Description");
				rows[4] = rs.getString("Price");
				rows[5] = rs.getString("Ingredient1");
				rows[6] = rs.getString("Ingredient2");
				rows[7] = rs.getString("ApplyDate");
				rows[8] = rs.getString("EventID");
				System.out.println("row[0]: "+rows[0]);
				System.out.println("row[8]: "+rows[8]);
				MainFrame.getMainFrame().panel.loginPanel.signIn.res.tableModel.addRow(rows);
			}
		}
	}
	public static void searchMaterial(String table, String ResNo) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT M.MaterialID, M.AmountExpected, I.IngredientName, I.IngredientPrice, (M.AmountExpected - I.IngredientAmount)AS AmountToBuy, \r\n"
				+ "		((M.AmountExpected - I.IngredientAmount)*I.IngredientPrice)AS TotalPrice" + " FROM " + table
				+ " M, Restaurant R, Ingredient I WHERE M.ResNo = R.ResNo AND M.ResNo = I.ResNo AND I.IngredientID = M.MaterialID AND R.ResNo = I.ResNo AND R.ResNo = '"
				+ ResNo + "';";
		System.out.println(sqlSelect);
		try (Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery(sqlSelect);

		) {
			
			while (rs.next()) {
				if(!rs.isBeforeFirst()) {
				String info1 = rs.getString("MaterialID");
				String info2 = rs.getString("IngredientName");
				String info3 = rs.getString("AmountExpected");
				String info4 = rs.getString("IngredientPrice");
				String info5 = rs.getString("AmountToBuy");
				String info6 = rs.getString("TotalPrice");
				MainFrame.getMainFrame().panel.loginPanel.signIn.res.showMaterial(info1, info2 ,info3, info4, info5, info6);
				info1 = info2 = info3 = info4 = info5 = info6 = "";}
				else System.out.println("No data found");
			}
		}

	}
	
	public static void updateResInfo(String table, String attributeChange, String dataN, String condition, String DishID) throws Exception {
		//UPDATE Menu SET Price = 145000 WHERE DishID = 'HBPC'; 
		connectToSQL();
		try (Statement st = connection.createStatement();){
			String sqlUpdate =  "UPDATE "+table+" SET "+ attributeChange +" = "+ dataN +" WHERE "+condition +" = '" + DishID + "'";
			System.out.println("SQL INSERT:"+sqlUpdate);
			int numberRowsAffected = st.executeUpdate(sqlUpdate);
			System.out.println("Affected rows after update: "+numberRowsAffected);
			}

	}
	public static void deleteResInfo(String table, String condition, String DishID) throws SQLException {
		connectToSQL();
		try (Statement st = connection.createStatement();){
			String sql =  "DELETE FROM "+table+" WHERE "+ condition +" = '"+DishID+"'";
			System.out.println("SQL DELETE:"+sql);
			int numberRowsAffected = st.executeUpdate(sql);
			System.out.println("Affected rows after delete: "+numberRowsAffected);
			}
	}
	
	public static boolean searchInfo(String user, String password) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT * FROM Users WHERE Username ="+"'"+user+"' AND Password ="+"'"+password+"'";
		System.out.println(sqlSelect);
	    try (
	            Statement st = connection.createStatement(
	            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = st.executeQuery(sqlSelect);
	        ) {
	    	if(rs.next()) {
			infoType = rs.getString("UserType");
			infoUserId = rs.getString("UserID");
			
			if(infoType.equals("Restaurant")) 
				{
				sqlSelect = "SELECT R.ResNo, R.ResName, Re.Address FROM Restaurant R, Users U, ResAddress Re "
					+ "WHERE R.UserID = U.UserID AND R.ResNo = Re.ResNo AND U.UserID ="+ infoUserId +";";
				System.out.println(sqlSelect);
			try (
		            Statement st1 = connection.createStatement(
		            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		            ResultSet rs1 = st1.executeQuery(sqlSelect);
		        ){
				if(rs1.next()) {
				infoName = rs1.getString("ResName");
				infoResNo = rs1.getString("ResNo");
				System.out.println(infoName);
				System.out.println(infoResNo);
				infoAddress = rs1.getString("Address");
				System.out.println(infoAddress);}

			}
				}
			if(infoType.equals("Shipper")) {}
			if(infoType.equals("Customer")) {}
			
			return true;}
	        else return false;
	     
	}
		}
	
	public static boolean searchParticularInfo(String selectAttribute, String fromTable, String user, String password) throws Exception {
		connectToSQL();
		String sqlSelect = "SELECT " + selectAttribute+ " FROM " +fromTable+" WHERE Username ="+"'"+user+"' AND Password ="+"'"+password+"'";
		System.out.println(sqlSelect);
	    try (
	            Statement st = connection.createStatement(
	            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = st.executeQuery(sqlSelect);
	        ) {
	    	if(rs.next()) {
	    		showUserInfos(rs, selectAttribute);
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
    System.out.println("CreatedDate: " + rs.getDate(9));
    System.out.println("Gender Of Owner:"+rs.getString(10));
    System.out.println("---");
}

private static ResultSet showUserInfos(ResultSet rs, String selectAttribute) throws SQLException {
	System.out.println(rs);
	infoTransfer = rs.getString(selectAttribute);
	System.out.println("Info transfer in sql: "+infoTransfer);
	return rs;
}

}
	


