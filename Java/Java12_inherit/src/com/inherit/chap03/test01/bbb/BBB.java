package com.inherit.chap03.test01.bbb;

import com.inherit.chap03.test01.aaa.AAA;

public class BBB extends AAA {
	// �ʵ�
	private int b;
	
	// ������(�⺻, �Ű�����)
	public BBB() {
		// super();  // �θ�Ŭ���� ������ -> AAA();
		System.out.println("BBB ����");
	}
	public BBB(int abc, int b) {
		super(abc);	// �θ��� ������ -> AAA(abc);
		this.b = b;
		System.out.println("BBB ����(abc, b �޾Ƽ� ����)");
	}
	public BBB(int b) {
		super(b);	// �θ��� ������ -> AAA(abc);
		this.b = b;
		System.out.println("BBB ����(b �޾Ƽ� ����)");
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
