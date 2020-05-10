public class Order {
	private int orderID, cusNo, shipNo;
	private String resNo, orderPrice, orderStatus, serverID;

	public Order(String serverID, int orderID, String resNo, int CusNo, int ShipNo, String orderPrice, String orderStatus) {
		this.orderID = orderID;
		this.resNo = resNo;
		this.cusNo = CusNo;
		this.shipNo = ShipNo;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
	}
	public String getServerID() {
		return serverID;
	}
	
	public int getOrderID() {
		return orderID;
	}

	public String getResNo() {
		return resNo;
	}

	public int getCusNo() {
		return cusNo;
	}

	public int getShipNo() {
		return shipNo;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}



}
