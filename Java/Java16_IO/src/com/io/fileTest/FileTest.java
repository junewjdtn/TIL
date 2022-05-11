package com.io.fileTest;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		// ��ü ����
		File file = new File("person.txt");
		
		System.out.println("���ϸ�: " + file.getName());
		// ������ Ȯ�ι�
		System.out.println("������: " + file.getAbsolutePath());
		// ���� ������ Ȯ�ι�
		System.out.println("������: " + file.getPath());
		System.out.println("�뷮: " + file.length());
		System.out.println("��������: " + file.getParent());
		
		try {
			// ���� ���� �� ������ �ִ��� �� �������� Ȯ��
			boolean b = file.createNewFile();
			System.out.println(b);
			
			// ���� ���� �� ������ �ִ��� �� �������� Ȯ��
			boolean b1 = file.delete();
			System.out.println(b1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}