package com.inherit.chap02.override;

public class Book {
	// �ʵ�
	private String title;
	private String writer;
	private int price;
	
	// ������(�⺻, �Ű�����)
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
		// ��ü�� �ּҰ� ������ ���� ��ü
		if(this == obj) {
			return true;
		}
		// ���޹��� ��ü�� null
		if(obj == null) {
			return false;
		}
		// �ʵ尪 ��
		Book other = (Book)obj;
		// title ��
		if(title == null) {
			if(other.title != null) {
				return false;
			}
		// �� ��ü�� title���� ���� �ٸ��� false ����
		}else if(!title.equals(other.title)) {
			return false;
		}
		// writer ��
		if(writer == null) {
			if(other.writer != null) {
				return false;
			}
		}else if(!writer.equals(other.writer)) {
			return false;
		}
		// price ��
		if(price != other.price) {
			return false;
		}
		// ��� ���� ����ϸ� �� ��ü�� ���� ��ü
		return true;
	}
	
	@Override
	public int hashCode() {
		return (writer + price + title).hashCode();
	}
}