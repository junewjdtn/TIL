package com.test01.run;

import java.util.Scanner;

import com.test01.model.dto.Book;

public class ObjectArrayTest {

	public static void main(String[] args) {
		int[] arr = new int[3];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		
		/*
		Book[] bk = new Book[3];
		
		bk[0] = new Book("�̰��� �ڹٴ�", "�ſ��", "�Ѻ��̵��", 30000);
		bk[1] = new Book("HTML5 �� ���α׷��� �Թ�", "���μ�", "�Ѻ���ī����", 26000);
		bk[2] = new Book("�ڹ� ���� �ٷ�� ���", "�̺���", "���", 35000);
		*/
		
		Book[] bk = {
				new Book("�̰��� �ڹٴ�", "�ſ��", "�Ѻ��̵��", 30000),
				new Book("HTML5 �� ���α׷��� �Թ�", "���μ�", "�Ѻ���ī����", 26000),
				new Book("�ڹ� ���� �ٷ�� ���", "�̺���", "���", 35000)
				};
		
		// ���
		/*
		System.out.println(bk);					// Book[]
		System.out.println(bk[0]);				// Book
		System.out.println(bk[0].getPrice());	// int
		*/
		
		// �˻�
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� å ����: ");
		String sTitle = sc.nextLine();
		
		// �ݸ�
		for(int i=0; i<bk.length; i++) {
			if(bk[i].getTitle().equals(sTitle)) {
				System.out.println(bk[i].information());
				break;
			}else {
				System.out.println("�˻��� å�� ã�� �� �����ϴ�.");
				break;
			}
		}
	}
}