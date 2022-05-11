package com.chap03.myException;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �ϳ� �Է�: ");
		int no = sc.nextInt();
		
		try {
			checkNum(no);
		} catch (MyException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void checkNum(int num) throws MyException {
		if(num<10) {
			// ���ܹ߻�
			// throw new MyException();
			throw new MyException(num + "��(��) 10���� ���� ���Դϴ�.");
		}else {
			System.out.println(num + "��(��) 10���� ũ�ų� �����ϴ�.");
		}
	}
	
	
}
