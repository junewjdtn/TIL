package com.arrayPractice1.sample;

import java.util.Random;
import java.util.Scanner;

public class ArraySample {
	public void test1() {
		// 1. 10개의 int 배열 선언하고 할당함
		// 2. 각 방에 1~100사이의 임의의 난수를 기록함
		// Math.random() 사용함
		// new Random().nextInt(100) + 1;
		// 3. 10개의 정수들의 합계를 구하여 출력함

		int[] ar = new int[10];
		int sum = 0;

		for (int i = 0; i < ar.length; i++) {
			ar[i] = new Random().nextInt(100) + 1;
		}
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
			System.out.println(i + " 인덱스 값: " + ar[i]);
		}
		System.out.println("sum: " + sum);
	}
	
	public void test2() {
		int arr[] = new int[10];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*100)+1;
			System.out.println(arr[i]+ " ");
		}
		System.out.println();
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("max: " + max);
		System.out.println("min: " + min);
	}

	public void test4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력: ");
		String value = sc.next();
		
		int sum=0;
		
		for(int i=0; i<value.length(); i++) {
			String s = value.substring(i,i+1);
			sum += Integer.parseInt(s);
			// sum += Integer.parsInt(value.substring(i,i+1));
		}
		System.out.println("합계: " + sum);
	}
	
	public void test4_1() { // 두자리 숫자 합계 구하기

		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력: ");
		String value = sc.next();
		
		int sum=0;
		
		for(int i=0; i<value.length(); i+=2) {
			String s = value.substring(i,i+2);
			sum += Integer.parseInt(s);
		}
		System.out.println(sum);
		System.out.println();
	}

	public void test5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력: ");
		String value = sc.next();
		
		int sum=0;
		
		for(int i=0; i<value.length(); i++) {
			sum += (int)value.charAt(i) - 48;
		}
		System.out.println("합계: " + sum);
	}
}