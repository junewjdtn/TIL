package com.inherit.chap01.after.model.dto;

import java.util.Date;

public class Television extends Product {
	// �ʵ�
	private int inchType;
	
	// ������(�⺻, �Ű�����)
	public Television() {}
	public Television(String brand, String productNumber, String productCode, 
			String productName, int price, Date date, int inchType) {
		// �θ��� ������ ȣ�� (super()�� ȣ���� �ڽĺ��� ���� �־�� �ȴ�)
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
