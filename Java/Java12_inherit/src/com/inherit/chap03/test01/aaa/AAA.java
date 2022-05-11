package com.inherit.chap03.test01.aaa;

public class AAA {
	// 필드
	private int abc;
	
	// 생성자(기본, 매개변수)
	public AAA() {
		// super();
		System.out.println("AAA 생성");
	}
	public AAA(int abc) {
		// super();
		System.out.println("AAA 생성(abc 받아서 생성)");
		this.abc = abc;
	}
	
	// getter&setter
	// abc
	public int getAbc() {
		return abc;
	}
	public void setAbc(int abc) {
		this.abc = abc;
	}
	
	// information
	public void prn() {
		System.out.println("AAA의 prn 메소드");
	}
	
	
	

}
