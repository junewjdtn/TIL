package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class URI01 {

	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("http://localhost:8787/Java19_URI/res.jsp?name=lim&addr=seoul");
		//				프로토콜 |  호스트	 | 포트 | 프로그램  | 사이트 | 쿼리
		// 프로토콜
		System.out.println(u.getScheme());
		// 호스트 - IP
		System.out.println(u.getHost());
		// 포트 
		System.out.println(u.getPort());
		// 쿼리 - 
		System.out.println(u.getQuery());
		
		
	}
	/*
	 * 1. URL : Uniform Resource Locator = 주소(위치)
	 * 			특정 서버의 하나의 리소스에 대한 구체적인 위치를 서술한 것.
	 * 
	 * 2. URN : Uniform Resource Name = 대상(이름)
	 * 			콘텐츠를 이루는 한 리소스에 대한, 그 리소스의 위치에 영향 받지 않는
	 * 			유일 무일한 이름 역할
	 * 
	 * 3. URI : Uniform Resource Identifier = 식별자
	 * 			URL + URN = URI
	 * 
	 */
}