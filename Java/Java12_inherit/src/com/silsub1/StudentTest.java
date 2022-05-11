package com.silsub1;

public class StudentTest {

	public static void main(String[] args) {
		// 객체
		int[] arr = new int[3];
		
		Student[] s = {
				new Student("홍길동", 15, 171, 81, "201101", "영문"),
				new Student("한사람", 13, 183, 72, "201102", "건축"),
				new Student("임걱정", 16, 175, 65, "201103", "무영")
		};
		
		for(int i = 0; i<s.length; i++) {
			System.out.println(s[i].information());
		}

	}
}
