package com.poly.silsub1.shape.model.vo;

public class Triangle extends Shape {
	// 필드
	private double base;
	private double height;
	
	// 생성자
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
		// Math.sqrt -> 제곱근 메소드 (square root)
		double Hypotenuse = Math.sqrt(base*base + height*height);
		return base + height + Hypotenuse;
	}

}
