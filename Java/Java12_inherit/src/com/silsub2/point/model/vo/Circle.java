package com.silsub2.point.model.vo;

public class Circle extends Point{
	// field
	private int radius;
	
	// constructor
	public Circle() {}
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	// getter&setter
	// radius
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw() {
		
	}
	
	
	
	
}
