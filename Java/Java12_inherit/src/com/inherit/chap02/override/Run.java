package com.inherit.chap02.override;

public class Run {

	public static void main(String[] args) {
		// 객체
		Book b1 = new Book("수학의 정석", "나수학", 100);
		Book b2 = new Book("자바의 정석", "다자바", 200);
		
		System.out.println("b1 = " + b1);
		System.out.println("b2 = " + b2);
		
		// 비교
		System.out.println("b1과 b2는 같은 객체? : " + b1.equals(b2));
		
		Book b3 = b1;
		System.out.println("b1과 b3는 같은 객체? : " + b1.equals(b3));
		
		// b1과 값이 동일한 객체 생성
		Book b4 = new Book("수학의 정석", "나수학", 100);
		System.out.println("b1과 b4는 같은 객체? : " + b1.equals(b4));
		System.out.println(b1.hashCode());
		System.out.println(b4.hashCode());
		
	}
}