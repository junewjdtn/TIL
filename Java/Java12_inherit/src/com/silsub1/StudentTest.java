package com.silsub1;

public class StudentTest {

	public static void main(String[] args) {
		// ��ü
		int[] arr = new int[3];
		
		Student[] s = {
				new Student("ȫ�浿", 15, 171, 81, "201101", "����"),
				new Student("�ѻ��", 13, 183, 72, "201102", "����"),
				new Student("�Ӱ���", 16, 175, 65, "201103", "����")
		};
		
		for(int i = 0; i<s.length; i++) {
			System.out.println(s[i].information());
		}

	}
}
