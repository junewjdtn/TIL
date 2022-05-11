package com.test.chap04.run;

import java.util.Date;

import com.test.chap04.model.dto.User;

public class Run {

	public static void main(String[] args) {
		// 기본생성자로 객체 생성
		User u1 = new User();
		u1.information();
		
		// 매개변수 생성자로 객체 생성
		User u2 = new User("rrhak", "june2595!", "임정수");
		//User u2 = new User("rrhak", "june2595!", null);
		u2.information();
		
		User u3 = new User("rrhak", "june2595!", "임정수", new Date());
		u3.information();
		
	}
}