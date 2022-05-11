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
		//0~10 출력
		int i;
		for(i=0; i<=10; i++) {
			System.out.println("i = " + i);
		}
	}
	
	public static void testFor02() {
		//역순
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
		//정수하나를 입력받아 그 수가 양수일때만 그 수의 구구단을 출력
		//양수가 아니면 "반드시 1~9 사이의 양수를 입력" 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~9사이의 양수 하나 입력: ");
		int no = sc.nextInt();
		
		if(no>=1 && no<=9) {
			//구구단 출력
			for(int i=1; i<=9; i++) {
				System.out.println(no + " * " + i + " = " + no*i);
			}
		}else {
			System.out.println("반드시 1~9 사이의 양수를 입력");
		}
		
	}
	
	public static void testFor05() {
		//1~100사이의 난수를 구하고
		//1부터 구한 난수까지의 합을 출력
		int random = (int)(Math.random()*100) + 1;
		//Math.random -> 0.0000... ~ 0.9999...
		// 0.000... ~ 0.999...
		//*				100 
		// 0.000... ~ 99.999...
		//int로 정수값만 구하면
		// 0 ~ 99
		//+		1		1
		// 1 ~ 100
		int sum = 0;
		for(int i =1; i<=random; i++) {
			sum += i;
		}
		System.out.println("1부터 " + random + " 까지의 합계: " + sum);
	}
	
	public static void testFor06() {
		// 키보드로 정수 두개 입력
		// 작은수 ~ 큰수 까지의 합
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수: ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수: ");
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
		System.out.println(min + "에서 " + max + "까지의 정수들의 합계: " + sum);
	}
	
}
