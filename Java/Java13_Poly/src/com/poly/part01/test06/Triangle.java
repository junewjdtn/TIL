package com.poly.part01.test06;

import java.util.Scanner;

public class Triangle extends AreaImpl {

	@Override
	public void make() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ﰢ���� �غ� �Է�: ");
		int x = sc.nextInt();
		System.out.print("�ﰢ���� ���� �Է�: ");
		int y = sc.nextInt();
		
		double res = x * y / 2.0;
		
		setResult(String.format("%.1f", res));
	}
	
	@Override
	public void print() {
		System.out.println("�ﰢ���� ����: ");
		super.print();
	}
	
	
}
