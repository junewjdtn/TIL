package com.test01;

import java.util.Scanner;

public class WhileTest02 {

	public static void main(String[] args) {
		WhileTest02 wt = new WhileTest02();
		//wt.testDoWhile1();
		wt.testDoWhile2();
	}
	
	public void testDoWhile1() {
		int i = 1; //i값이 10이 넘을 경우에는 i 값이 출력이 됨 -> do ~ while에서는 do의 식을 먼저 실행시키기 때문에 값이 출력이 된다.
		
		do {
			System.out.println(i);
			i++;
			
		}while(i<10);
		
		System.out.println("While 종료 후 값은 " + i + " 입니다.");
		
	}
	
	public void testDoWhile2() {
		//키보드로 영어 문자열을 입력 받아 출력
		//"end" 입력시 종료
		Scanner sc = new Scanner(System.in);
		String str = null; //매서드 안에서만 쓸수 있게 사용
		do {
			System.out.print("문자열 입력 : ");
			str = sc.next();   //sc.next()-> 띄어쓰기 사용 안됨   sc.nextLine() -> 띄어쓰기 사용됨
			
			System.out.println("str : " + str);
		}while(!str.equals("end")); //문자열, 참조형변수는 !=, ==를 사용하지 않고 !str.equals 메서드를 사용하여 비교해야함 (equals = 같다)
		
	}

}
