package com.inherit.chap01.before.model.dto;

import java.util.Date;

public class Television {
	// 필드
	private String brand;
	private String productNumber;
	private String productCode;
	private String productName;
	private int price;
	private Date date;
	private int inchType;
	
	// 생성자(기본, 매개변수)
	public Television() {}
	public Television(String brand, String productNumber, String productCode, 
			String productName, int price, Date date, int inchType) {
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
		this.inchType = inchType;
	}
	
	// getter&setter
	// brand
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	// productNumber
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	// productCode
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	// productName
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	// price
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// date
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	// inchType
	public int getInchType() {
		return inchType;
	}
	public void setInchType(int inchType) {
		this.inchType = inchType;
	}
	
	// information
	public void information() {
		System.out.println(brand + ", " + productNumber + ", " + productCode +
				", " + productName + ", " + price + ", " + date + ", " + inchType);
	}

}
