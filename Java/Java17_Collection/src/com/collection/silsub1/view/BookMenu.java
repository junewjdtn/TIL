package com.collection.silsub1.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.collection.silsub1.controller.BookManager;
import com.collection.silsub1.model.dto.Book;

public class BookMenu {
	// 필드
	private Scanner sc = new Scanner(System.in);
	private BookManager bm = new BookManager();

	// 생성자
	public BookMenu() {}

	public void mainMenu() {
		// 구현 순서 : 1->5->4->3->2
		while (true) {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색 출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num) {
			case 1:
				// inputBook()의 내용을 입력받아 addBook으로 넘겨준다.
				// Book b = inputBook();
				// bm.addBook(b);
				bm.addBook(inputBook());
				break;
			case 2:
				bm.printBookList(bm.sortedBookList());
				break;
			case 3:
				int result = bm.deleteBook(inputBookNo());
				if(result >0) {
					System.out.println("성공적으로 삭제되었습니다.");
				}else {
					System.out.println("삭제할 글이 존재하지 않습니다.");
				}
				break;
			case 4:
				// 책 등록 유무 확인
				// inputBookTilte()의 리턴값을 searchBook으로 넘겨줌
				// Book b = inputBookTitle();
				// bm.searchBook(b);
				int index = bm.searchBook(inputBookTitle());
				
				// index 번호에 따라 출력
				if(index == -1) {
					System.out.println("조회한 글이 존재하지 않습니다.");
				}else {
					System.out.println(bm.selectBook(index));
				}
				break;
			case 5:
				ArrayList<Book> list = bm.selectAll();
				// isEmpty() -> 비어있는지 확인
				if(list.isEmpty()) {
					System.out.println("도서가 없습니다.");
				}else {
					// Iterator
					Iterator<Book> it = list.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}

	// 매소드
	public Book inputBook() {
		System.out.print("제목: ");
		String title = sc.nextLine();
		System.out.print("장르 (1.인문 / 2.자연과학 / 3.의료 / 4.기타) 숫자로 입력: ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("저자: ");
		String author = sc.nextLine();
		
		return new Book(category, title, author);
	}

	public int inputBookNo() {
		System.out.print("도서 번호: ");
		int no = sc.nextInt();
		sc.nextLine();
		return no;
	}

	public String inputBookTitle() {
		System.out.println("도서 제목: ");
		String title = sc.nextLine();
		
		return title;
	}

}
