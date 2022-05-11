package com.poly.silsub1.shape.model.vo;

public class Triangle extends Shape {
	// �ʵ�
	private double base;
	private double height;
	
	// ������
	public Triangle() {}
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	// getter&setter
	// base
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	// height
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double area() {
		return base*height/2.0;
	}
	
	@Override
	public double perimeter() {
		// Math.sqrt -> ������ �޼ҵ� (square root)
		double Hypotenuse = Math.sqrt(base*base + height*height);
		return base + height + Hypotenuse;
	}

}
