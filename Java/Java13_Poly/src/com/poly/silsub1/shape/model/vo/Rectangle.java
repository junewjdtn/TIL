package com.poly.silsub1.shape.model.vo;

public class Rectangle extends Shape {
	// �ʵ�
	private double width;
	private double height;

	// ������
	// �Ű����� �����ڸ� ����Ҷ��� �⺻ �����ڸ� ����� �־�� �ٸ� Ŭ�������� ȣ���Ҷ� ������ �ȳ�
	public Rectangle() {} 
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	// getter&setter
	// width
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	// height
	public double getHeight() {
		return height;
	}
	public void setHeigth(double height) {
		this.height = height;
	}
	
	@Override
	public double area() {
		return width*height;
	}
	@Override
	public double perimeter() {
		return (width+height)*2;
	}
}
