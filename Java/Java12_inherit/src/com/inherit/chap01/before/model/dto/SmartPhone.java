package com.inherit.chap01.before.model.dto;

import java.util.Date;

public class SmartPhone {
	// 필드
	private String brand;
	private String productNumber;
	private String productCode;
	private String productName;
	private String cpu;
	private int hdd;
	private int ram;
	private String os;
	private int price;
	private Date date;
	private String mobileAgency;

	// Alt + Shift + s
	// 생성자
	// 기본생성자
	public SmartPhone() {}
	// 매개변수 생성자
	public SmartPhone(String brand, String productNumber, String productCode,
			String productName, String cpu, int hdd, int ram, String os,
			int price, Date date, String mobileAgency) {
		this.brand = brand;
		this.productNumber = productNumber;
		this.productCode = productCode;
		this.productName = productName;
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
		this.price = price;
		this.date = date;
		this.mobileAgency = mobileAgency;
	}
	
	// getter&setter
	// brand
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//productNumber
	public String getProductNmber() {
		return productNumber;
	}
	public void setProductNmber(String productNmber) {
		this.productNumber = productNmber;
	}
	//productCode
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
	// cpu
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	// hdd
	public int getHdd() {
		return hdd;
	}
	public void setHdd(int hdd) {
		this.hdd = hdd;
	}
	// ram
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	// os
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
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
	// mobileAgency
	public String getMobileAgency() {
		return mobileAgency;
	}
	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	// information
	public void information() {
		System.out.println(brand + ", " + productNumber + ", " + productCode +
				", " + productName + ", " + cpu + ", " + hdd + ", " + ram + 
				", " + os + ", " + price + ", " + date + ", " + mobileAgency);
	}
	
	

}
