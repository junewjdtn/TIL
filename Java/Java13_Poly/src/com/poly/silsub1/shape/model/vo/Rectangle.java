package com.poly.silsub1.shape.model.vo;

public class Rectangle extends Shape {
	// 필드
	private double width;
	private double height;

	// 생성자
	// 매개변수 생성자를 사용할때는 기본 생성자를 사용해 주어야 다른 클래스에서 호출할때 오류가 안남
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
