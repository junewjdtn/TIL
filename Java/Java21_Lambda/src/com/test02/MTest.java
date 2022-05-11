package com.test02;

public class MTest {
	public static void main(String[] args) {
		MyCalc sum = (a, b) -> a+b;
		MyCalc sub = (a, b) -> a-b;
		MyCalc mul = (a, b) -> a*b;
		MyCalc div = (a, b) -> a/b;
		
		int i = 10;
		int j = 3;
		
		System.out.println(i + " + " + j + " = " + sum.calc(i, j));
		System.out.println(i + " - " + j + " = " + sub.calc(i, j));
		System.out.println(i + " * " + j + " = " + mul.calc(i, j));
		System.out.println(i + " / " + j + " = " + div.calc(i, j));
		
		// 나머지
		MyCalc mod = (a, b) -> {System.out.println("나머지"); return a%b;};
		System.out.println(i + " % " + j + " = " + mod.calc(i, j));
		
	}

}
