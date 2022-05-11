package com.chap03.myException;

public class MyException extends Exception {
	public MyException() {
		System.out.println("내가 만든 예외클래스다!!");
	}
	
	public MyException(String msg) {
		super(msg);
	}
	
}
