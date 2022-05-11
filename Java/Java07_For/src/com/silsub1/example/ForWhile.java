package com.silsub1.example;

import java.util.Scanner;

public class ForWhile {
	Scanner sc = new Scanner(System.in);

	public void printStar2() {
		System.out.print("���� �Է�: ");
		int row = sc.nextInt();

		if (row > 0) {
			// ����϶�
			for (int r = 1; r <= row; r++) {
				for (int c = 1; c <= r; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (row < 0) {
			// �����϶�
			for (int r = (-row); r > 0; r--) {
				for (int c = 1; c <= r; c++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("��� ����� �����ϴ�.");
		}
	}

	public void countInputCharacter() {
		System.out.print("���ڿ� �Է�: ");
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			if (!(temp >= 'a' && temp <= 'z' || temp >= 'A' && temp <= 'Z')) {
				System.out.println("�����ڰ� �ƴմϴ�.");
				return; // ����ǰ� �ִ� �޼��带 ��������� break�� �ݺ����� ���⶧ ���
			}
		}

		System.out.print("���� �Է�: ");
		char ch = sc.next().charAt(0);
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (ch == str.charAt(i)) {
				count++;
			}
		}
		System.out.println("���Ե� ����: " + count + "��");
	}

}
