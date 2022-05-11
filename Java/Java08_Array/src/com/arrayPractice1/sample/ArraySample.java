package com.arrayPractice1.sample;

import java.util.Random;
import java.util.Scanner;

public class ArraySample {
	public void test1() {
		// 1. 10���� int �迭 �����ϰ� �Ҵ���
		// 2. �� �濡 1~100������ ������ ������ �����
		// Math.random() �����
		// new Random().nextInt(100) + 1;
		// 3. 10���� �������� �հ踦 ���Ͽ� �����

		int[] ar = new int[10];
		int sum = 0;

		for (int i = 0; i < ar.length; i++) {
			ar[i] = new Random().nextInt(100) + 1;
		}
		for (int i = 0; i < ar.length; i++) {
			sum += ar[i];
			System.out.println(i + " �ε��� ��: " + ar[i]);
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
		
		System.out.println("���� �Է�: ");
		String value = sc.next();
		
		int sum=0;
		
		for(int i=0; i<value.length(); i++) {
			String s = value.substring(i,i+1);
			sum += Integer.parseInt(s);
			// sum += Integer.parsInt(value.substring(i,i+1));
		}
		System.out.println("�հ�: " + sum);
	}
	
	public void test4_1() { // ���ڸ� ���� �հ� ���ϱ�

		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �Է�: ");
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
		
		System.out.println("���� �Է�: ");
		String value = sc.next();
		
		int sum=0;
		
		for(int i=0; i<value.length(); i++) {
			sum += (int)value.charAt(i) - 48;
		}
		System.out.println("�հ�: " + sum);
	}
}