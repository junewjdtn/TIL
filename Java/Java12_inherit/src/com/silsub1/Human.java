package com.silsub1;

public class Human {
	// 필드
	private String name;
	private int age;
	private int height;
	private int weight;
	
	// 생성자(기본, 매개변수)
	public Human() {}
	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	// getter&setter
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// age
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// height
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	// weight
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	// information
	public String information() {
		return name + " " + age + " " + height + " " + weight;
		
	}


}
