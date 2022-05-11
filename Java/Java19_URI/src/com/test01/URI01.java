package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class URI01 {

	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("http://localhost:8787/Java19_URI/res.jsp?name=lim&addr=seoul");
		//				�������� |  ȣ��Ʈ	 | ��Ʈ | ���α׷�  | ����Ʈ | ����
		// ��������
		System.out.println(u.getScheme());
		// ȣ��Ʈ - IP
		System.out.println(u.getHost());
		// ��Ʈ 
		System.out.println(u.getPort());
		// ���� - 
		System.out.println(u.getQuery());
		
		
	}
	/*
	 * 1. URL : Uniform Resource Locator = �ּ�(��ġ)
	 * 			Ư�� ������ �ϳ��� ���ҽ��� ���� ��ü���� ��ġ�� ������ ��.
	 * 
	 * 2. URN : Uniform Resource Name = ���(�̸�)
	 * 			�������� �̷�� �� ���ҽ��� ����, �� ���ҽ��� ��ġ�� ���� ���� �ʴ�
	 * 			���� ������ �̸� ����
	 * 
	 * 3. URI : Uniform Resource Identifier = �ĺ���
	 * 			URL + URN = URI
	 * 
	 */
}