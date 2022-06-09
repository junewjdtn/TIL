package com.test08;

public class MTest {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		
		TV tv = (TV) factory.getBean("lg");
		
		tv.powerOn();
		tv.powerOff();
		tv.volUp();
		tv.volDown();
	}

}
