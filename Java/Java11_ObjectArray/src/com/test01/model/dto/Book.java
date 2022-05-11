package com.test01.model.dto;

public class Book {
	// 필드
	private String title;
	private String author;
	private String publisher;
	private int price;
	
	// 생성자(기본생성자, 매개변수 생성자)
	// 기본 생성자
	public Book() {}
	
	// 매개변수 생성자
	public Book(String title, String author, String publisher, int price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	// getter&setter
	// String title의 getter&setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//String author의 getter&setter
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// String publisher의 getter&setter
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	// int price의 getter&setter
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String information() {
		return "title= " + title + ", author= " + author + ", publisher= " + 
				publisher + ", price= " + price;
	}
	
	
}