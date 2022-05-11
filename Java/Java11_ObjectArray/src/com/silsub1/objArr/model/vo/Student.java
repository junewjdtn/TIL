package com.silsub1.objArr.model.vo;

public class Student {
	// �ʵ�
	private int grade;
	private int classroom;
	private int number;
	private String name;
	
	// ������
	// �⺻ ������
	public Student() {}
	// �Ű����� ������
	public Student(int grade, int classroom, int number, String name) {
		// ���� �ʱ�ȭ ���ִ� ����
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
		this.grade = grade;  // ���� �������ִ� ����
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
	
	// ��¿� �޼ҵ�
	public String information() {
		return grade + "�г� " + classroom + "�� " + number + "�� " + name;
	}
	

}
