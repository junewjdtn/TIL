package com.test03;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Functional01 {
	public static void main(String[] args) {
		unaryTest();
		binaryTest();
	}
	
	public static void unaryTest() {
		// UnaryOperator : �Ű����� ���� �ϳ�, ������ type ��ü�� ����
		// apply() �޼ҵ� ���
		UnaryOperator<String> hello = (name) -> "Hello, " + name;
		
		System.out.println(hello.apply("Lambda"));
		
	}
	
	public static void binaryTest() {
		BinaryOperator<Integer> sum = (i, j) -> i+j;
		System.out.println(sum.apply(10, 3));
		
		System.out.println(sum.andThen((n) -> n*2).apply(10, 30));
	
	}
	
}
