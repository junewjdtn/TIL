package com.inherit.chap01.after.model.dto;

import java.util.Date;

public class Computer extends Product {
	// 필드
	private String  cpu;
	private int hdd;
	private int ram;
	private String os;
	
	// 생성자(기본, 매개변수)
	public Computer() {
		// super(); <- 기본적으로 숨겨져 있음 (public Product(){}를 불러오는 것임)
	}

	public Computer(String brand, String productNumber, String productCode, String productName, 
			int price, Date date, String cpu, int hdd, int ram, String os) {
		super(brand, productNumber, productCode, productName, price, date);
		this.cpu = cpu;
		this.hdd = hdd;
		this.ram = ram;
		this.os = os;
	}

	// getter&setter
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
	
	// information
	@Override
	public String information() {
		return super.information() + cpu + ", " + hdd + ", " + ram + ", " + os;
	}
	
	
	
}
