package com.poly.part01.test04;

public class MTest {

	public static void main(String[] args) {
		// ��ü
		Animal a = new Cat();
		a.bark();
		a.eat("����");
		
		a = new Dog();
		a.bark();
		a.eat("���ٱ�");
		// �ٿ� ĳ����
		((Dog)a).bite();
		
		a = new Eagle();
		a.bark();
		a.eat("��ѱ�");
		((Eagle)a).fly();
	}
}