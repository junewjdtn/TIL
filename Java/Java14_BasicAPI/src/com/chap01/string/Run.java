package com.chap01.string;

public class Run {

	public static void main(String[] args) {
		Run.method1();
	}
	
	public static void method1() {
		// 문자열을 리터럴로 생성
		String str = "abc";
		String str1 = "abc";
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		
		// new 연산자 이용
		String str2 = new String("abc");
		String str3 = new String("abc");
		
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		System.out.println();
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		
		System.out.println("================");
		// charAt(i)
		// 해당 인덱스의 문자를(i번째 문자를) 하나 가져오겠다
		System.out.println(str.charAt(0));
		
		// concat(합치기)
		System.out.println(str.concat("def"));
		
		// contains(포함여부) -> true or false
		System.out.println(str.contains("a"));
		System.out.println(str.contains("u"));
		
		// equals() (비교)
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("bc"));
		
		// length() (길이)
		System.out.println(str.length());

		// split(문자 구분)
		str1 = "a,b,c,d,e,f";
		String[] sArr = str1.split(",");
		for(String arr : sArr) {
			System.out.println(arr);
		}
		for(int i = 0; i<sArr.length; i++) {
			System.out.println(sArr[i]);
		}
		
		// toUpperCase(대문자로 바꾸어줌)
		System.out.println(str.toUpperCase());
		
		// toLowerCase(소문자로 바꾸어줌)
		System.out.println(str.toLowerCase());
		
		// substring(잘라내기)
		System.out.println(str1.substring(2,4));
		
		// trim(공백을 제거) -> 맨 앞과 맨 뒤의 공백만 제거해줌
		str2 = "       abc       ";
		System.out.println(str2);
		System.out.println(str2.trim());
		
	}

}
