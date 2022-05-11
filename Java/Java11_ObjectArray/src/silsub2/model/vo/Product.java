package silsub2.model.vo;

public class Product {
	// 필드(멤버 변수)
	private String pName;
	private int price;
	private String brand;
	
	// 생성자(기본, 매개변수)
	// 기본 생성자
	public Product() {}
	
	// 매개변수 생성자
	public Product(String pName, int price, String brand) {
		this.pName = pName;
		this.price = price;
		this.brand = brand;
	}
	
	// setter&getter
	// pName_setter&getter
	public void setPName(String pName) {
		this.pName = pName;
	}
	public String getPName() {
		return pName;
	}
	
	// price_setter&getter
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	// brand_setter&getter
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	
	// information
	public String information() {
		return "pName: " + pName + ", price: " + price + ", brand" + brand;
	}
	
	

}
