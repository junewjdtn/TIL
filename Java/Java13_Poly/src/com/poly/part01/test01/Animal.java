package com.poly.part01.test01;

public abstract class Animal {
	// 매소드
	public void eat(String animal) {
		System.out.println(animal + " 먹는다.");
	}
	
	public abstract void bark();
}
