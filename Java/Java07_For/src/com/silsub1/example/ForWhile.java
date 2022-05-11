package com.silsub1.example;

import java.util.Scanner;

public class ForWhile {
	Scanner sc = new Scanner(System.in);

	public void printStar2() {
		System.out.print("정수 입력: ");
		int row = sc.nextInt();

		if (row > 0) {
			// 양수일때
			for (int r = 1; r <= row; r++) {
				for (int c = 1; c <= r; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (row < 0) {
			// 음수일때
			for (int r = (-row); r > 0; r--) {
				for (int c = 1; c <= r; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("출력 기능이 없습니다.");
		}
	}

	public void countInputCharacter() {
		System.out.print("문자열 입력: ");
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			if (!(temp >= 'a' && temp <= 'z' || temp >= 'A' && temp <= 'Z')) {
				System.out.println("영문자가 아닙니다.");
				return; // 실행되고 있는 메서드를 종료시켜줌 break는 반복문을 멈출때 사용
			}
		}

		System.out.print("문자 입력: ");
		char ch = sc.next().charAt(0);
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}
		System.out.println("포함된 갯수: " + count + "개");
	}

}
