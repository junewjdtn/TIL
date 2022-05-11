package com.inherit.chap02.override;

public class Book {
	// 필드
	private String title;
	private String writer;
	private int price;
	
	// 생성자(기본, 매개변수)
	public Book() {}
	public Book(String title, String writer, int price) {
		this.title = title;
		this.writer = writer;
		this.price = price;
	}
	
	// getter&setter
	// title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	// writer
	public String getWriter() {
		return writer;
	}
	public void setWirter(String writer) {
		this.writer = writer;
	}
	// price
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// information
	@Override
	public String toString() {
		return title + ", " + writer + ", " + price;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 객체의 주소가 같으면 같은 객체
		if(this == obj) {
			return true;
		}
		// 전달받은 객체가 null
		if(obj == null) {
			return false;
		}
		// 필드값 비교
		Book other = (Book)obj;
		// title 비교
		if(title == null) {
			if(other.title != null) {
				return false;
			}
		// 두 객체의 title값이 서로 다르면 false 리턴
		}else if(!title.equals(other.title)) {
			return false;
		}
		// writer 비교
		if(writer == null) {
			if(other.writer != null) {
				return false;
			}
		}else if(!writer.equals(other.writer)) {
			return false;
		}
		// price 비교
		if(price != other.price) {
			return false;
		}
		// 모든 조건 통과하면 두 객체는 같은 객체
		return true;
	}
	
	@Override
	public int hashCode() {
		return (writer + price + title).hashCode();
	}
}