package com.poly.silsub1.shape.model.vo;

public class Circle extends Shape {
	private double radius;
	
	// 상수 필드
	public static final double PI = Math.PI;
	
	// 생성자
	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// getter&setter
	// radius
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	// PI
	public static double getPi() {
		return PI;
	}
	
	@Override
	public double area() {
		double area = radius * radius * PI;
		return area;
	}

	@Override
	public double perimeter() {
		return (radius * 2) * PI;
	}
	
	
	
	
}
