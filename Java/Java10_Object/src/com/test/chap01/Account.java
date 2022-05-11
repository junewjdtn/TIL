package com.test.chap01;

public class Account {
	// ��� ����(�ʵ�)
	private String name = "������";
	private String accNo = "302-0937-1857-31";
	private String pwd = "1234";
	private int bankCode = 20;
	private int balance = 0;
	
	// ������(��ü�� �����ϱ� ���� ������ �޼ҵ�)
	public Account() {}
	
	// �Ա�
	public void in(int money) {
		if(money > 0) {
			balance += money;
			System.out.println(name + "���� ���¿� " + money + "���� �Ա� �Ǿ����ϴ�.");
		}else {
			System.out.println("�߸��� �ݾ��� �Է� �Ǿ����ϴ�.");
		}
	}
	
	// ���
	public void out(int money) {
		if(money < balance) {
			balance -= money;
			System.out.println(name + "���� ���¿��� " + money + "���� ��� �Ǿ����ϴ�.");
		}else {
			System.out.println("�ܾ��� �����մϴ�. �ܾ��� Ȯ���ϼ���.");
		}
	}
	
	// �ܾ���ȸ
	public void display() {
		System.out.println(name + "���� ���¿� �ܾ��� " + balance + "�� �Դϴ�.");
	}
	
	
}
