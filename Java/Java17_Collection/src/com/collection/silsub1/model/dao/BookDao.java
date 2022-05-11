package com.collection.silsub1.model.dao;

import java.util.ArrayList;

import com.collection.silsub1.model.comparator.AscCategory;
import com.collection.silsub1.model.dto.Book;

public class BookDao {
	// 필드
	private ArrayList<Book> bookList;
	
	// 생성자
	public BookDao() {
		bookList = new ArrayList<Book>();
	}
	public BookDao(ArrayList<Book> list) {
		bookList = list;
	}
	
	// 매소드
	// 마지막 도서 번호 리턴
	public int getLastBookNo() {
		// bookList의 사이즈(크기)에 -1을 한 번호 값을 가져와 bookList에 넣는다
		// bookList.size()-1 -> 마지막 객체 번호를 가져와 -1을 해준다는 의미
		return bookList.get(bookList.size()-1).getbNo();
	}
	
	// 새 도서 추가
	public void addBook(Book book) {
		// 넘겨받은 book의 값을 bookList에 추가해라
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
			// contains -> 비교
			if(bookList.get(i).getTitle().contains(title));
			index = i;
			break;
		}
		return index;
	}
	
	// 해당 인덱스 값을 이용한 book 객체 리턴
	public Book selectBook(int index) {
		// 넘겨 받은 index 값과 같은 bookList를 리턴
		return bookList.get(index);
	}
	
	// 전체 출력
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
