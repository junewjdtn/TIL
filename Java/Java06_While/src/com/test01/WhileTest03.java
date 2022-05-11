package com.test01;

public class WhileTest03 {

	public static void main(String[] args) {
		WhileTest03 wt = new WhileTest03();
		
		// 1~100 의 숫자를 역순으로 출력
		//wt.prn01();
		// 1~100 의 숫자 중, 2의 배수만 출력
		//wt.prn02();
		// 1~100 의 숫자 중, 7의 배수의 갯수와 총합 출력
		wt.prn03();

	}
	
	public void prn01() {
		
		int i = 100;
		
		while(i>0) {
			System.out.println(i);
			i--;
		}
	}
	
	public void prn02() {
		
		int i = 1;
		
		while(i<=100) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}
	
	public void prn03() {
		
		int cnt = 0;
		int sum = 0;
		int i = 1;
		
		while(i<=100) {
			if(i % 7 == 0) {
				cnt++;
				sum += i;
			System.out.println(i);
			}
			i++;
		}
		System.out.println("갯수: " + cnt + " 총합은 :" + sum);
	}

}
