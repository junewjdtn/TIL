package com.test.chap05.test02;

public class MethodTest {
	// 1.매개변수 없다, 반환값 없다.
	public void method1() {
		System.out.println("매개변수와 반환값이 둘 다 없는 매소드입니다.");
		return;
	}
	
	// 2. 매개변수 없다, 반환값 있다.
	public String method2() {
		return "매개변수가 없지만 반환값이 있는 메소드입니다.";
	}
	
	// 3. 매개변수 있다, 반환값 없다.
	public void method3(int num, int num2) {
		System.out.println("sum: " + (num+num2));
		return;
	}
	
	// 4. 매개변수 있다, 반환값 있다.
	public int method4(int num, int num2) {
		int sum = num+num2;
		return sum;
	}
	
}
