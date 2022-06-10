package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
		
		Person w = factory.getBean("woman", Person.class);
		Person m = (Person) factory.getBean("man");
		
		System.out.println("양성희 접속!");
		w.classWork();
		System.out.println("-----------");
		System.out.println("이영재 접속!");
		m.classWork();
	}

}
