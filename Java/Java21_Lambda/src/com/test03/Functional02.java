package com.test03;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Functional02 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// Predicate
		// �Ű����� �ְ�, ��ȯ���� ���� (Boolean ���� ��ȯ)
		// predic01();
		predic02();
		
	}
	
	public static boolean isNull(String name, Predicate<String> predic) {
		// .test -> �˻縦 �Ѵ�.
		return predic.test(name);
	}
	
	public static void predic01() {
		String name = null;
		while(true) {
			System.out.println("�̸� �Է�: ");
			name = sc.nextLine();
			
			if(isNull(name, (input) -> input.trim().length() == 0)) {
				System.out.println("�ٽ� �Է��� �ּ���.");
			}else {
				sc.close();
				break;
			}
			
		}
		System.out.println("�� �̸��� " + name + "�Դϴ�.");
	}
	
	public static void predic02() {
		// BiPredicate 
		BiPredicate<Integer, Integer> bp01 = (i, j) -> i-j>0;
		
		int i = 10;
		int j = 20;
		
		if(bp01.test(i, j)) {
			System.out.println("i>j");
		}else {
			System.out.println("i<=j");
		}
		
	}
	
}
