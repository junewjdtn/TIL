package com.test.chap03.test02;

public class MTest {

	public static void main(String[] args) {
		InitBlock p = new InitBlock("아이폰13", 200, "애플");
		
		p.setName("아이폰14");
		String pName = p.getName();
		
		p.information();
	}
}