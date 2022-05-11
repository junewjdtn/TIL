package com.silsub1.objArr.model.vo;

public class Student {
	// 필드
	private int grade;
	private int classroom;
	private int number;
	private String name;
	
	// 생성자
	// 기본 생성자
	public Student() {}
	// 매개변수 생성자
	public Student(int grade, int classroom, int number, String name) {
		// 값을 초기화 해주는 역할
		this.grade = grade;
		this.classroom = classroom;
		this.number = number;
		this.name = name;
	}
	
	// getter&setter
	// grade
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;  // 값을 저장해주는 역할
	}
	
	// classroom
	public int getClassroom() {
		return classroom;
	}
	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}
	
	// number
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// 출력용 메소드
	public String information() {
		return grade + "학년 " + classroom + "반 " + number + "번 " + name;
	}
	

}
