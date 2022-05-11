package com.collection.part04.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericsTest {
	public void test1() {
		List list = new ArrayList();
		
		list.add(new String("Orange"));
		list.add(new Book());
		list.add(new Car());
		list.add(new Student());
		
		System.out.println("저장된 객체 수: " + list.size());
		System.out.println("list: " + list);
		
		for(int i = 0; i<list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
			
			if(obj instanceof Book) {
				((Book)obj).printBook();
			}
			if(obj instanceof Student) {
				((Student) obj).score();
			}
			if(obj instanceof Car) {
				((Car) obj).printCar();
			}
			
		}
		
	}
	
	public void test2() {
		ArrayList<Book> list = new ArrayList<Book>();
		ArrayList list2 = new ArrayList();
		
		list.add(new Book());
		list.add(new Book());
		// list.add("test Book");
		
		list2.add(new Book());
		list2.add(new Book());
		//list2.add("test Book");
		
		// list안에 있는 객체를 하나씩 꺼내어 b에 넣고 for문 실행 반복
		for(Book b: list) {
			b.printBook();
		}
		
		for(Object ob: list2) {
			((Book)ob).printBook();
		}
		
		
	}
	
	public void test3() {
		HashMap<String, Book> map = new HashMap<String, Book>();
		
		map.put("one", new Book("java"));
		map.put("two", new Book("html"));
		map.put("three", new Book("spring"));
		
		System.out.println(map);
		
		// entryset(), Iterator
		Set<Map.Entry<String, Book>> entry = map.entrySet();
		Iterator<Map.Entry<String, Book>> iter = entry.iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String, Book> ent = iter.next();
			String key = ent.getKey();
			Book value = ent.getValue();
			System.out.println(key + " : " + value);
		}
		
	}
	
}

class Book{
	private String title;
	public Book() {}
	public Book(String title) {
		this.title = title;
	}
	public void printBook() {
		System.out.println("printBook() call...");
	}
	@Override
	public String toString() {
		return "Book";
	}
}

class Student{
	public Student() {}
	public void score() {
		System.out.println("score() call...");
	}
	@Override
	public String toString() {
		return "Student";
	}
}

class Car{
	public Car() {}
	public void printCar() {
		System.out.println("printCar() call...");
	}
	@Override
	public String toString() {
		return "Car";
	}
}

