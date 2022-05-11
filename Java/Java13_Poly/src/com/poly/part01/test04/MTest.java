package com.poly.part01.test04;

public class MTest {

	public static void main(String[] args) {
		// °´Ã¼
		Animal a = new Cat();
		a.bark();
		a.eat("»ý¼±");
		
		a = new Dog();
		a.bark();
		a.eat("»À´Ù±Í");
		// ´Ù¿î Ä³½ºÆÃ
		((Dog)a).bite();
		
		a = new Eagle();
		a.bark();
		a.eat("ºñµÑ±â");
		((Eagle)a).fly();
	}
}