package com.test01;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
		WhileTest01 wt = new WhileTest01();
		//wt.testWhile();
		//wt.testWhile2();
		//wt.testWhile3();
		//wt.testWhile4();
		wt.testWhile4_1();
	}
	
	public void testWhile() {
		//�ʱ��
		int i = 0;
		
		//���ǽ�
		while(i<8) {
			System.out.println((i+1) + "��° �ݺ��� ������...");
			
			//������
			i++;
		}
		System.out.println("while�� ����� ���� i ��: " + i);
	}
	
	public void testWhile2() {
		//���ڿ��� �Է¹޾� �ε������� ����(char)�� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� �Է�: ");
		String str = sc.next();
		
		int index=0;
		while(index < str.length()) {
			char ch = str.charAt(index);
			System.out.println(index + " : " + ch);
			index++;
		}
	}
	
	public void testWhile3() {
		//1���� �Է¹��� �� ������ ���� ������
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int num = sc.nextInt();
		
		int sum = 0;
		int i = 1;
		while(i<=num) {
			sum += i; // sum = sum + i
			
			i++;
		}
		System.out.println("1���� " + num + "������ ���� " + sum + "�Դϴ�.");
	}
	
	public void testWhile4() {
		int i=1;
		while(true) {
			System.out.println(i);
			i++;
			
			if(i==10) {
				break;
			}
		}
	}
	
	public void testWhile4_1() {
		//Ű����� ������ �Է¹޴´�.
		//�Է¹��� ���ڰ� 4�̸� while�� ����.
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("���ڸ� �Է��ϼ���: ");
			int i = sc.nextInt();
			
			if(i==4) {
				System.out.println("4�� �ԷµǾ����ϴ�. ����!!");
				break;
			}
		}
	}
	
}
