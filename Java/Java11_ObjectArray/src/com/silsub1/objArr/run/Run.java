package com.silsub1.objArr.run;

import com.silsub1.objArr.model.vo.Student;

public class Run {

	public static void main(String[] args) {
		// 객체 (객체를 생성하면서 값을 넘겨주는 역할을 해줌)
		// 값을 넣어줄 때 변수형과 매개변수 순서에 따라 넣어줘야 오류가 뜨지 않음
		Student st1 = new Student(3, 1, 1, "홍길동");
		Student st2 = new Student(4, 3, 2, "유관순");
		Student st3 = new Student(2, 7, 5, "윤봉길");
		
		// 배열
		Student[] arr = new Student[3];
		arr[0] = st1;
		arr[1] = st2;
		arr[2] = st3;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i].information());
		}

	}

}
