package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");
		
		Developer lim = factory.getBean("limjs", Developer.class);
		System.out.println(lim);
		
		Engineer kim = factory.getBean("kimjs", Engineer.class);
		System.out.println(kim);
	}

}
