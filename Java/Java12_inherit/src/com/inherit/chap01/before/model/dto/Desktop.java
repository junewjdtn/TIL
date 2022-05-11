package com.inherit.chap01.before.model.dto;

import java.util.Date;

public class Desktop {
	// �ʵ�
	private String brand; 			// ������
	private String productNumber; 	// ��ǰ��ȣ
	private String productCode; 	// ��ǰ�ڵ�
	private String productName; 	// ��ǰ��
	private String cpu;				// cpu
	private int hdd;				// �ϵ��ũ
	private int ram;				// �޸�
	private String os;				// �ü��
	private int price;				// ����
	private Date date;				// ��������
	private boolean allInOne;		// ��ü�� ����
	
	// ������
	// �⺻������
	public Desktop() {}
	// �Ű����� ������
	public Desktop(String brand, String productNumber, String productCode,
			String productName, String cpu, int hdd, int ram, String os,
			int price, Date date, boolean allInOne) {
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
		this.allInOne = allInOne;
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
	
	// allInOne
	public boolean getAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	// information
	public void information() {
		System.out.println(brand + ", " + productNumber + ", " + productCode +
				", " + productName + ", " + cpu + ", " + hdd + ", " + ram + 
				", " + os + ", " + price + ", " + date + ", " + allInOne);
	}
	

}
