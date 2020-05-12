public class RestaurantMenu {
	private String dishID, dishName, category, resNo;
	private String price;
	private byte[] image;
	private String resName;

	public RestaurantMenu() {
		
	}
	
	
	public RestaurantMenu(String ResNo, String dishID, String dishName, String category, String price, byte[] image, String resName) {
		this.resNo = ResNo;
		this.dishID = dishID;
		this.dishName = dishName;
		this.category = category;
		this.price = price;
		this.image = image;
		this.resName = resName;
	}

	public String getResNo() {
		return resNo;
	}

	public String getResName() {
		return resName;
	}


	public void setResName(String resName) {
		this.resName = resName;
	}


	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getDishID() {
		return dishID;
	}

	public void setDishID(String dishID) {
		this.dishID = dishID;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	
	
}
