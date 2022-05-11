package com.silsub2.point.model.vo;

public class Point {
	// field
	private int x;
	private int y;
	
	// constructor
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// getter&setter
	// x
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	// y
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	// draw
	public void draw() {
		System.out.println(x + " " + y);
	}

}


