package com.poly.part01.test04;

public abstract class Animal {
	// 추상 매소드
	public abstract void bark();
	// 일반 매소드
	public void eat(String feed) {
		System.out.println(feed + " 먹는다.!!");
	}

}
