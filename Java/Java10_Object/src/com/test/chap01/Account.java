package com.test.chap01;

public class Account {
	// 멤버 변수(필드)
	private String name = "임정수";
	private String accNo = "302-0937-1857-31";
	private String pwd = "1234";
	private int bankCode = 20;
	private int balance = 0;
	
	// 생성자(객체를 생성하기 위한 일종의 메소드)
	public Account() {}
	
	// 입금
	public void in(int money) {
		if(money > 0) {
			balance += money;
			System.out.println(name + "님의 계좌에 " + money + "원이 입금 되었습니다.");
		}else {
			System.out.println("잘못된 금액이 입력 되었습니다.");
		}
	}
	
	// 출금
	public void out(int money) {
		if(money < balance) {
			balance -= money;
			System.out.println(name + "님의 계좌에서 " + money + "원이 출금 되었습니다.");
		}else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요.");
		}
	}
	
	// 잔액조회
	public void display() {
		System.out.println(name + "님의 계좌에 잔액은 " + balance + "원 입니다.");
	}
	
	
}
