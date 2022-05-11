package com.collection.silsub1.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.collection.silsub1.model.dao.BookDao;
import com.collection.silsub1.model.dto.Book;

public class BookManager {
	// 필드
	private BookDao bd = new BookDao();
	private Scanner sc = new Scanner(System.in);
	
	// 생성자
	public BookManager() {}
	public void addBook(Book book) {
		
		try {
			book.setbNo(bd.getLastBookNo()+1);
		} catch (IndexOutOfBoundsException e) {
			// 인덱스가 없을 경우 bNo에 1을 넣는다 -> 이 예외처리는 딱 한번만 실행이 됨
			book.setbNo(1);
		}
		// book에 저장된 것을 bd의 addBook으로 가라
		bd.addBook(book);
	}
	
	// 매소드
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
