package com.silsub2.point.model.vo;

public class Rectangle extends Point{
	// field
	private int width;
	private int height;
	
	// constructor
	public Rectangle() {}
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	// getter&setter
	// width
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	// height
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void draw() {
		
	}
	
	
	
	
	
	
}
