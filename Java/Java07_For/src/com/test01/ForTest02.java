package com.test01;

import java.util.Scanner;

public class ForTest02 {

	public static void main(String[] args) {
		//ForTest02.testFor01();
		//ForTest02.testFor02();
		//ForTest02.testFor03();
		ForTest02.testFor04();
		
	}
	
	public static void testFor01() {
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.println("i= " + i + ", j= " + j);
			}
			System.out.println();
		}
	}
	
	public static void testFor02() {
		//������ 2�ܺ��� 9�ܱ��� ���
		for(int i=2; i<10; i++) {
			System.out.println("====" + i + "��====");
			for(int j=1; j<10; j++) {
				System.out.println(i + " * " + j + " = " + i*j);
			}
			System.out.println();
		}
	}
	
	public static void testFor03() {
		
		for(int r=1; r<=5; r++) {
			for(int c=1; c<=5; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void testFor04() {
		//�� �ٿ� ��ǥ���ڸ� �Էµ� �ټ��� ĭ����ŭ ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ��: ");
		int row = sc.nextInt();
		System.out.print("ĭ ��: ");
		int col = sc.nextInt();
		
		for(int r=1; r<=row; r++) {
			for(int c=1; c<=col; c++) {
				if(r==c) {
					System.out.print(r);
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
