package com.test.chap01;

public class Main {

	public static void main(String[] args) {
		Account my = new Account();
		
		// 현재 잔액 조회
		my.display();
		
		// 입금
		my.in(100);
		my.display();
		
		my.in(150);
		my.display();
		
		// 출금
		my.out(50);
		my.display();
		
		//my.balance -= 200;
		
		my.out(50);
		my.display();
	}
}
