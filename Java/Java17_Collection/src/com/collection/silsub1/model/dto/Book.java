package com.collection.silsub1.model.dto;

public class Book {
	// 필드
	private int bNo;
	private int category;
	private String title;
	private String author;
	
	// 생성자
	public Book() {}
	public Book(int category, String title, String author) {
		super();
		this.category = category;
		this.title = title;
		this.author = author;
	}
	
	// getter&setter
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		String str = "";
		if(category == 1) {
			str = "인문";
		}else if(category == 2) {
			str = "자연과학";
		}else if(category == 3) {
			str = "의료";
		}else if(category == 4) {
			str = "기타";
		}
		
		return "도서번호: " + bNo + " | 분류: " + str + " | 제목: " + title + " | 저자: " + author;
	}
	
	
	
	
	
	
	
	
	
}