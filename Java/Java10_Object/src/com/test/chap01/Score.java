package com.test.chap01;

public class Score {
	// 멤버 변수(필드)
	private String name = "임정수";
	private int kor = 90;
	private int eng = 86;
	private int math = 97;
	
	// 생성자
	public Score() {}
	
	// 총합을 구해 출력하는 기능
	public void sum() {
		int sum = kor + eng + math;
		System.out.println(name + " 학생의 과목 총점은: " + sum + "점 입니다.");
	}
	
	// 평균을 구해 출력하는 기능
	public void avg() {
		double avg = (kor+eng+math)/3.0;
		System.out.println(name + " 학생의 과목 평균은: " + avg + "점 입니다.");
	}
	
	// 제일 높은 점수를 받은 과목을 찾아 출력하는 기능
	public void max() {
		int max=kor;
		if(kor>eng && kor>math) {
			System.out.println(name + " 학생의 국어 점수가 " + kor + "점으로 제일 높습니다.");
		}else if(eng>kor && eng>math) {
			System.out.println(name + " 학생의 영어 점수가 " + eng + "점으로 제일 높습니다.");
		}else {
			System.out.println(name + " 학생의 수학 점수가 " + math + "점으로 제일 높습니다.");
		}
	}
	
	// 필드값 확인할수 있는 기능
	public void prn() {
		System.out.println(name + " 학생의 국어점수: " + kor + "점, 영어점수: " + eng +
				"점, 수학점수: " + math + "점 입니다.");
	}
}
