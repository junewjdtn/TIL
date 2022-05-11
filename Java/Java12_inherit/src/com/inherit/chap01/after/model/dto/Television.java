package com.inherit.chap01.after.model.dto;

import java.util.Date;

public class Television extends Product {
	// 필드
	private int inchType;
	
	// 생성자(기본, 매개변수)
	public Television() {}
	public Television(String brand, String productNumber, String productCode, 
			String productName, int price, Date date, int inchType) {
		// 부모의 생성자 호출 (super()의 호출이 자식보다 먼저 있어야 된다)
		super(brand, productNumber, productCode, productName, price, date);
		this.inchType = inchType;
	}
	
	// getter&setter
	// inchType
	public int getInchType() {
		return inchType;
	}
	public void setInchType(int inchType) {
		this.inchType = inchType;
	}
	
	// information
	@Override
	public String information() {
		return super.information() + ", " + inchType;
	}
	

}
