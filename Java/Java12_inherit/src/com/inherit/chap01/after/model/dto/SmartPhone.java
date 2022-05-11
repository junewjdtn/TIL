package com.inherit.chap01.after.model.dto;

import java.util.Date;

public class SmartPhone extends Computer {
	// 필드
	private String mobileAgency;

	// 생성자(기본, 매개변수)
	public SmartPhone() {}
	public SmartPhone(String brand, String productNumber, String productCode, String productName, int price, Date date,
			String cpu, int hdd, int ram, String os, String mobileAgency) {
		super(brand, productNumber, productCode, productName, price, date, cpu, hdd, ram, os);
		this.mobileAgency = mobileAgency;
	}
	// getter&setter
	// mobileAgency
	public String getMobileAgency() {
		return mobileAgency;
	}
	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}
	
	// information
	@Override
	public String information() {
		return super.information() + ", " + mobileAgency;
	}
}
