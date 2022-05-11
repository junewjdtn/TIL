package com.test.chap03.test02;

public class InitBlock {
	private String name = "Galaxy Note10+";
	private int price=200;
	private static String brand = "SAMSUNG";
	
	{
		name = "Galaxy S22 Ultra";
		price = 300;
		brand = "SAMSUNG";
	}
	static {
		//name = "Iphone13";
		brand = "삼성";
	}
	
	// 생성자
	// 기본 생성자
	public InitBlock() {}
	// 매개변수 있는 생성자
	public InitBlock(String name, int price, String brand) {
		this.name = name;
		this.price = price;
		InitBlock.brand = brand;
	}
	
	public void information() {
		System.out.println(name + ", " + price + ", " + brand);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

}
