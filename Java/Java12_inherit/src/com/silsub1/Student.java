package com.silsub1;

public class Student extends Human{
	// �ʵ�
	private String number;
	private String major;
	
	// ������(�⺻, �Ű�����)
	public Student() {}
	public Student(String name, int age, int height, int weight, 
			String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	// getter&setter
	// number
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	// major
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	// information
	@Override
	public String information() {
		return super.information() + " " + number + " " + major;
	}
	
	
	
	

}
