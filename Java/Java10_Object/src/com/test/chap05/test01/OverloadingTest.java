package com.test.chap05.test01;

public class OverloadingTest {
	public int test() {
		return 0;
	}
	
	public int test(int a) {
		return 0;
	}
	
	public int test(int a, int b) {
		return 0;
	}
	/*
	매개변수의 명이 다르다고 오버로딩이 적용되지는 않는다.
	public int test(int c, int a) {
		return 0;
	}*/
	
	public int test(String s, int a) {
		return 0;
	}
	
	public String test(int a, int b, String str) {
		return null;
	}
	/*
	반환형이 다르다고 오버로딩이 적용되지는 않는다.
	public int test(int a, int b, String str) {
		return 0;
	}
	
	접근제한자 다르다고 오버로딩이 적용되지는 않는다.
	private String test(int a, int b, String str) {
		return "";
	}*/
	
	
	
}
