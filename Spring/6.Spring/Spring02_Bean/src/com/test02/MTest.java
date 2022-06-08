package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
		
		Address lee = (Address)factory.getBean("lee");
		System.out.println(lee);
		
		Address hong = (Address)factory.getBean("hong");
		System.out.println(hong);
		
		
		// 이순신, 서울시 강남구, 010-1111-1111
		// 홍길동, 경기도 수원시, 010-2222-2222
	}

}
