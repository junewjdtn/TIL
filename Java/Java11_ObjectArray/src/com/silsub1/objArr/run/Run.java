package com.silsub1.objArr.run;

import com.silsub1.objArr.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		// ��ü (��ü�� �����ϸ鼭 ���� �Ѱ��ִ� ������ ����)
		// ���� �־��� �� �������� �Ű����� ������ ���� �־���� ������ ���� ����
		Student st1 = new Student(3, 1, 1, "ȫ�浿");
		Student st2 = new Student(4, 3, 2, "������");
		Student st3 = new Student(2, 7, 5, "������");
		
		// �迭
		Student[] arr = new Student[3];
		arr[0] = st1;
		arr[1] = st2;
		arr[2] = st3;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].information());
		}

	}

}
