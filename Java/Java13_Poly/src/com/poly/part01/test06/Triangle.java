package com.poly.part01.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl {

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삼각형의 밑변 입력: ");
		int x = sc.nextInt();
		System.out.print("삼각형의 높이 입력: ");
		int y = sc.nextInt();
		
		double res = x * y / 2.0;
		
		setResult(String.format("%.1f", res));
	}
	
	@Override
	public void print() {
		System.out.println("삼각형의 면적: ");
		super.print();
	}
	
	
}
