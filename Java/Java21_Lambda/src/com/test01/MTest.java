package com.test01;

public class MTest {
	public static void main(String[] args) {
		// () -> {code}
		Test01 test01_1 = () -> {System.out.println("test01_1");};
		test01_1.prn();
		
		Test01 test01_2 = () -> System.out.println("test01_2");
		test01_2.prn();
		
		// (parameter) -> code;
		Test02 test02_1 = (int n) -> System.out.println("input: " + n);
		test02_1.prn(1);
		Test02 test02_2 = (n) -> System.out.println("input: " + n);
		test02_2.prn(2);
		Test02 test02_3 = n -> System.out.println("input: " + n);
		test02_3.prn(3);
		
		// (parameter) -> code; (return 생략 가능)
		// 코드가 한줄일때 return 생략 가능
		Test03 test03_1 = (n) -> n+n;
		System.out.println(test03_1.prn(1));
		
		// (parameter, parameter) -> {codes; return val;} (return 생략 불가
		Test04 test04_1 = (n1, n2) -> {
			System.out.println("input: " + n1 + " and " + n2);
			return n1*n2;
		};
		System.out.println(test04_1.prn(10, 3));
		
		
	}

}
