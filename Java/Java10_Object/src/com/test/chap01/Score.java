package com.test.chap01;

public class Score {
	// ��� ����(�ʵ�)
	private String name = "������";
	private int kor = 90;
	private int eng = 86;
	private int math = 97;
	
	// ������
	public Score() {}
	
	// ������ ���� ����ϴ� ���
	public void sum() {
		int sum = kor + eng + math;
		System.out.println(name + " �л��� ���� ������: " + sum + "�� �Դϴ�.");
	}
	
	// ����� ���� ����ϴ� ���
	public void avg() {
		double avg = (kor+eng+math)/3.0;
		System.out.println(name + " �л��� ���� �����: " + avg + "�� �Դϴ�.");
	}
	
	// ���� ���� ������ ���� ������ ã�� ����ϴ� ���
	public void max() {
		int max=kor;
		if(kor>eng && kor>math) {
			System.out.println(name + " �л��� ���� ������ " + kor + "������ ���� �����ϴ�.");
		}else if(eng>kor && eng>math) {
			System.out.println(name + " �л��� ���� ������ " + eng + "������ ���� �����ϴ�.");
		}else {
			System.out.println(name + " �л��� ���� ������ " + math + "������ ���� �����ϴ�.");
		}
	}
	
	// �ʵ尪 Ȯ���Ҽ� �ִ� ���
	public void prn() {
		System.out.println(name + " �л��� ��������: " + kor + "��, ��������: " + eng +
				"��, ��������: " + math + "�� �Դϴ�.");
	}
}
