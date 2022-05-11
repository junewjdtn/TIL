package com.inherit.chap03.test01.bbb;

import com.inherit.chap03.test01.aaa.AAA;

public class BBB extends AAA {
	// 필드
	private int b;
	
	// 생성자(기본, 매개변수)
	public BBB() {
		// super();  // 부모클래스 생성자 -> AAA();
		System.out.println("BBB 생성");
	}
	public BBB(int abc, int b) {
		super(abc);	// 부모의 생성자 -> AAA(abc);
		this.b = b;
		System.out.println("BBB 생성(abc, b 받아서 생성)");
	}
	public BBB(int b) {
		super(b);	// 부모의 생성자 -> AAA(abc);
		this.b = b;
		System.out.println("BBB 생성(b 받아서 생성)");
	}
	
	// getter&setter
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public int getSum() {
		int sum = super.getAbc() + this.b;
		return sum;
	}
	
	@Override
	public void prn() {
		System.out.println("BB.print()");
	}
	

}
