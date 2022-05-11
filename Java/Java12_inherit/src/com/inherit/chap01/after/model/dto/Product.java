package com.inherit.chap01.after.model.dto;

import java.util.Date;

public class Product {
	// 필드
	private String brand;
	private String productNumber;
	private String productCode;
	private String productName;
	private int price;
	private Date date;
	
	// 생성자(기본, 매개변수)
	public Product() {}
	public Product(String brand, String productNumber, String productCode, String productName, int price, Date date) {
		super();
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.date = date;
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
		
	// information
	public String information() {
		return brand + ", " + productNumber + ", " + productCode + ", " +
	productName + ", " + price + ", " + date + ", ";
	}
}
