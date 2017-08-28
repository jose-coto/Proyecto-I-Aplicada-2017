package cr.ac.ucr.proyectoiaplicada.domain;

public class Product {
	private int code;
	private String name;
	private String description;
	private float price;
	private float dollarPrice;
	private int quantity;
	private String urlImage;
	private String category;
	
	public Product() {
		
	}
	public Product(int code, String name, String description, float price, int quantity, String urlImage,
			String category) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.urlImage = urlImage;
		this.category = category;
	}
	public float getDolarPrice() {
		return dollarPrice;
	}
	public void setDolarPrice(float dolarPrice) {
		this.dollarPrice = dolarPrice;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
