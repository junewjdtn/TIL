package com.inherit.chap01.after.model.dto;

import java.util.Date;

public class Desktop extends Computer {
	// �ʵ�
	private boolean allInOne;
	
	// ������(�⺻, �Ű�����)
	public Desktop() {}
	public Desktop(String brand, String productNumber, String productCode,
			String productName, int price, Date date, String cpu, int hdd, 
			int ram, String os, boolean allInOne) {
		super(brand, productNumber, productCode, productName, price, date, 
				cpu, hdd, ram, os);
		this.allInOne = allInOne;
	}
	// getter&setter
	// allInOne
	public boolean isAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}

	// information
	@Override
	public String information() {
		return super.information() + ", " + allInOne;
	}
	
}
