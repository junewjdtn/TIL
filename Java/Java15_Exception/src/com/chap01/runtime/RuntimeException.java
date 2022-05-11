package com.chap01.runtime;

import java.util.Scanner;

public class RuntimeException {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		RuntimeException re = new RuntimeException();
		// re.test1();
		re.test2();

	}

	public void test1() {
		int no = 100;

		System.out.println("������ �� �ϳ� �Է�: ");
		int inputNum = sc.nextInt();
		
		// if�� ó��
		/*
		if (inputNum == 0) {
			System.out.println("0�� �Է��߽��ϴ�.");
		}else {
			int res = no / inputNum;
			System.out.println("������ ���: " + res);
		}*/
		
		// try catch ó��
		try {
			int res = no/inputNum;
			System.out.println("������ ���: " + res);
		}catch(ArithmeticException e) {
			System.out.println("Exception �߻�");
		}
		
	}
	
	public void test2() {
		try {
			/*
			// ClassCastException
			Object obj = 'a';
			System.out.println(obj);
			String str = (String)obj;
			System.out.println(str);
			*/
			/*
			// ArrayIndexOutOfBoundsException
			int arr[] = new int[2];
			arr[0] = 1;
			arr[1] = 2;
			arr[2] = 3;
			System.out.println("�̰� ���� �ɱ�???");
			*/
			// NullPointerException
			String str = null;
			int length = str.length();
			
		}catch(ClassCastException e) {
			System.out.println("���� �߻�! ����ȯ �Ұ�");
			e.printStackTrace();  // ���� ������ �����ִ� �ڵ�
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�̰� �迭�� ������ �Ѿ�� �߻��Ǵ� ���ܾ�!!");
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("Null �߻�!");
		}finally {
			System.out.println("finally ����!!!");
		}
	}
}