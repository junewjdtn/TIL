package com.collection.silsub1.model.dao;

import java.util.ArrayList;

import com.collection.silsub1.model.comparator.AscCategory;
import com.collection.silsub1.model.dto.Book;

public class BookDao {
	// �ʵ�
	private ArrayList<Book> bookList;
	
	// ������
	public BookDao() {
		bookList = new ArrayList<Book>();
	}
	public BookDao(ArrayList<Book> list) {
		bookList = list;
	}
	
	// �żҵ�
	// ������ ���� ��ȣ ����
	public int getLastBookNo() {
		// bookList�� ������(ũ��)�� -1�� �� ��ȣ ���� ������ bookList�� �ִ´�
		// bookList.size()-1 -> ������ ��ü ��ȣ�� ������ -1�� ���شٴ� �ǹ�
		return bookList.get(bookList.size()-1).getbNo();
	}
	
	// �� ���� �߰�
	public void addBook(Book book) {
		// �Ѱܹ��� book�� ���� bookList�� �߰��ض�
		bookList.add(book);
	}
	
	public int deleteBook(int no) {
		int res = 0;
		for(int i = 0; i<bookList.size(); i++) {
			if(bookList.get(i).getbNo() == no) {
				bookList.remove(i);
				res = 1;
			}
		}
		return res;
	}
	
	public int searchBook(String title) {
		int index = -1;
		for(int i = 0; i<bookList.size(); i++) {
			// contains -> ��
			if(bookList.get(i).getTitle().contains(title));
			index = i;
			break;
		}
		return index;
	}
	
	// �ش� �ε��� ���� �̿��� book ��ü ����
	public Book selectBook(int index) {
		// �Ѱ� ���� index ���� ���� bookList�� ����
		return bookList.get(index);
	}
	
	// ��ü ���
	public ArrayList<Book> selectAll(){
		return bookList;
	}
	
	public ArrayList<Book> sortedBookList(){
		ArrayList<Book> cList = new ArrayList<>();
		for(int i=0; i<bookList.size(); i++) {
			cList.add(bookList.get(i));
		}
		cList.sort(new AscCategory());
		return cList;
	}
	
	
	
	
	

}
