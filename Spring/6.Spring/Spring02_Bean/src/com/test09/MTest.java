package com.test09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test09/applicationContext.xml");
		System.out.println("spring bean container 생성 완료");
		
		TV tv = (TV) factory.getBean("samsung");
		
		tv.powerOn();
		tv.powerOff();
		tv.volUp();
		tv.volDown();
	}

}
