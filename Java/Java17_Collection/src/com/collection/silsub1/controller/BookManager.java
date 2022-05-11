package com.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.collection.silsub1.model.dao.BookDao;
import com.collection.silsub1.model.dto.Book;

public class BookManager {
	// �ʵ�
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);
	
	// ������
	public BookManager() {}
	public void addBook(Book book) {
		
		try {
			book.setbNo(bd.getLastBookNo()+1);
		} catch (IndexOutOfBoundsException e) {
			// �ε����� ���� ��� bNo�� 1�� �ִ´� -> �� ����ó���� �� �ѹ��� ������ ��
			book.setbNo(1);
		}
		// book�� ����� ���� bd�� addBook���� ����
		bd.addBook(book);
	}
	
	// �żҵ�
	public int deleteBook(int no) {
		return bd.deleteBook(no);
	}
	
	public int searchBook(String title) {
		int index = bd.searchBook(title);
		return index;
	}
	
	public Book selectBook(int index) {
		return bd.selectBook(index);
	}
	
	public ArrayList<Book> selectAll(){
		return bd.selectAll();
	}
	
	public Book[] sortedBookList() {
		ArrayList<Book> list = bd.sortedBookList();
		Book[] bk = new Book[list.size()];
		for(int i = 0; i<bk.length; i++) {
			bk[i] = list.get(i);
		}
		return bk;
	}
	
	public void printBookList(Book[] br) {
		for(Book tem : br) {
			System.out.println(tem);
		}
	}
	
	
	
	
	

}
