package com.test.chap03.test01;

public class KindOfVariable2 {
	
	public static int staticNum;
	
	public static final int STATIC_NUM=1;
	// public 접근제한자에 static + final 키워드를 함께 사용하는 것을
	// '상수 필드' 라고 한다. -> 선언과 동시에 초기화가 되어야 한다.
	
	public final static int STATIC_NUM2=2;
	
	public void methodTest() {
		// static int localStaticNum;

	}
	
	public static void staticMethodTest() {
		// static int localStaticNum;
		// 지역변수에서는 static 변수 사용 불가
		
	}

}
