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
		//초기식
		int i = 0;
		
		//조건식
		while(i<8) {
			System.out.println((i+1) + "번째 반복문 수행중...");
			
			//증감식
			i++;
		}
		System.out.println("while이 종료된 후의 i 값: " + i);
	}
	
	public void testWhile2() {
		//문자열을 입력받아 인덱스별로 문자(char)를 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력: ");
		String str = sc.next();
		
		int index=0;
		while(index < str.length()) {
			char ch = str.charAt(index);
			System.out.println(index + " : " + ch);
			index++;
		}
	}
	
	public void testWhile3() {
		//1부터 입력받은 수 까지의 합을 구하자
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		int num = sc.nextInt();
		
		int sum = 0;
		int i = 1;
		while(i<=num) {
			sum += i; // sum = sum + i
			
			i++;
		}
		System.out.println("1부터 " + num + "까지의 합은 " + sum + "입니다.");
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
		//키보드로 정수를 입력받는다.
		//입력받은 숫자가 4이면 while문 종료.
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("숫자를 입력하세요: ");
			int i = sc.nextInt();
			
			if(i==4) {
				System.out.println("4가 입력되었습니다. 종료!!");
				break;
			}
		}
	}
	
}
