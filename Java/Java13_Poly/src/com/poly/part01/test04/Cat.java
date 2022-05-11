package com.poly.part01.test04;

public class Cat extends Animal {

	@Override
	public void bark() {
		System.out.println("야옹");
	}
	
	@Override
	public void eat(String feed) {
		System.out.println(feed + "를 고양이가 먹는다!");
	}

}
