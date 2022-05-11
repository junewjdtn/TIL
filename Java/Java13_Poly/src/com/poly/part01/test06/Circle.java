package com.poly.part01.test06;

import java.util.Scanner;

public class Circle extends AreaImpl {

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름 입력: ");
		int r = sc.nextInt();
		
		double res = r * r * Math.PI;
		
		//super.setResult(res+"");
		// format -> 변형해주는 매소드
		setResult(String.format("%.2f", res));
	}
	
	// 재정의
	@Override
	public void print() {
		System.out.println("원의 ");
		super.print();
	}
	
	
}
