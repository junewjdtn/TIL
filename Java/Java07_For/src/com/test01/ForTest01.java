package com.test01;

import java.util.Scanner;

public class ForTest01 {

	public static void main(String[] args) {
		//ForTest01.testFor01();
		//ForTest01.testFor02();
		//ForTest01.testFor03();
		//ForTest01.testFor04();
		//ForTest01.testFor05();
		ForTest01.testFor06();
	}

	public static void testFor01() {
		//0~10 ���
		int i;
		for(i=0; i<=10; i++) {
			System.out.println("i = " + i);
		}
	}
	
	public static void testFor02() {
		//����
		int i;
		for(i=100; i>0; i--) {
			System.out.print(i + " ");
			if(i%10==1) {
				System.out.println();
			}
		}
	}
	
	public static void testFor03() {
		
		int i=1;
		for( ; ; ) {
			System.out.print(i+ " ");
			i++;
			if(i==10) {
				break;
			}
		}
	}
	
	public static void testFor04() {
		//�����ϳ��� �Է¹޾� �� ���� ����϶��� �� ���� �������� ���
		//����� �ƴϸ� "�ݵ�� 1~9 ������ ����� �Է�" ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~9������ ��� �ϳ� �Է�: ");
		int no = sc.nextInt();
		
		if(no>=1 && no<=9) {
			//������ ���
			for(int i=1; i<=9; i++) {
				System.out.println(no + " * " + i + " = " + no*i);
			}
		}else {
			System.out.println("�ݵ�� 1~9 ������ ����� �Է�");
		}
		
	}
	
	public static void testFor05() {
		//1~100������ ������ ���ϰ�
		//1���� ���� ���������� ���� ���
		int random = (int)(Math.random()*100) + 1;
		//Math.random -> 0.0000... ~ 0.9999...
		// 0.000... ~ 0.999...
		//*				100 
		// 0.000... ~ 99.999...
		//int�� �������� ���ϸ�
		// 0 ~ 99
		//+		1		1
		// 1 ~ 100
		int sum = 0;
		for(int i =1; i<=random; i++) {
			sum += i;
		}
		System.out.println("1���� " + random + " ������ �հ�: " + sum);
	}
	
	public static void testFor06() {
		// Ű����� ���� �ΰ� �Է�
		// ������ ~ ū�� ������ ��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ����: ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ����: ");
		int num2 = sc.nextInt();
		
		int sum=0, min=0, max=0;
		
		if(num1>num2) {
			max = num1;
			min = num2;
		}else {
			max = num2;
			min = num1;
		}
		for(int i =min; i<=max; i++) {
			sum += i;
		}
		System.out.println(min + "���� " + max + "������ �������� �հ�: " + sum);
	}
	
}
