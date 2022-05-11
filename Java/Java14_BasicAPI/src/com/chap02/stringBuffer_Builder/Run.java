package com.chap02.stringBuffer_Builder;

public class Run {

	public static void main(String[] args) {
		// Run.method1();
		Run.method2();
	}
	
	public static void method1() {
		StringBuilder sb = new StringBuilder("아아 좋은아침?");
		System.out.println(sb);
		
		String str = "안녕하세요!";
		System.out.println("str 기존: " + str + ", 주소: " + System.identityHashCode(str));
		
		str += "저는 임정수입니다.";
		System.out.println("str 추가 후: " + str + ", 주소: " + System.identityHashCode(str));
		
		StringBuffer sf = new StringBuffer("아침은 아직");
		System.out.println("sf 기존: " + sf + ", 주소: " + sf.hashCode() + ", " + System.identityHashCode(sf));
		
		sf.append("쌀쌀하네요!");
		System.out.println("sf 추가 후: " + sf + ", 주소: " + sf.hashCode() + ", " + System.identityHashCode(sf));
		
	}
	
	public static void method2() {
		StringBuilder sb = new StringBuilder("난 ");
		
		// append(맨 뒤에 내용추가)
		sb.append("커피 먹어");
		sb.append("~!");
		// sb.append("커피 먹어").append("~!");
		System.out.println(sb);
		
		// length
		System.out.println(sb.length());
		
		// insert(원하는 위치에 내용추가)
		sb.insert(0, "잠이 덜 깨서 ");
		System.out.println(sb);
		
		// delete(원하는 위치의 내용삭제)
		sb.delete(0, 8);
		System.out.println(sb);
		
		// reverse
		sb.reverse();
		System.out.println(sb);
		
		
		
	}
	
}
