package com.test01;

import java.util.Scanner;

public class WhileTest02 {

	public static void main(String[] args) {
		WhileTest02 wt = new WhileTest02();
		//wt.testDoWhile1();
		wt.testDoWhile2();
	}
	
	public void testDoWhile1() {
		int i = 1; //i���� 10�� ���� ��쿡�� i ���� ����� �� -> do ~ while������ do�� ���� ���� �����Ű�� ������ ���� ����� �ȴ�.
		
		do {
			System.out.println(i);
			i++;
			
		}while(i<10);
		
		System.out.println("While ���� �� ���� " + i + " �Դϴ�.");
		
	}
	
	public void testDoWhile2() {
		//Ű����� ���� ���ڿ��� �Է� �޾� ���
		//"end" �Է½� ����
		Scanner sc = new Scanner(System.in);
		String str = null; //�ż��� �ȿ����� ���� �ְ� ���
		do {
			System.out.print("���ڿ� �Է� : ");
			str = sc.next();   //sc.next()-> ���� ��� �ȵ�   sc.nextLine() -> ���� ����
			
			System.out.println("str : " + str);
		}while(!str.equals("end")); //���ڿ�, ������������ !=, ==�� ������� �ʰ� !str.equals �޼��带 ����Ͽ� ���ؾ��� (equals = ����)
		
	}

}
