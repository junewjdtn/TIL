package com.chap03.myException;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력: ");
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
			// 예외발생
			// throw new MyException();
			throw new MyException(num + "은(는) 10보다 작은 수입니다.");
		}else {
			System.out.println(num + "은(는) 10보다 크거나 같습니다.");
		}
	}
	
	
}
