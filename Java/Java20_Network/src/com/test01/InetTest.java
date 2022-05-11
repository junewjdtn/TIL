package com.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetTest {
	public static void main(String[] args) throws UnknownHostException {
		// 컴퓨터 정보를 가져옴 (컴퓨터 이름/ip주소)
		InetAddress addr = InetAddress.getLocalHost();
		
		System.out.println(addr);
		System.out.println("host name: " + addr.getHostName());
		System.out.println("localhost: " + addr.getHostAddress());
		System.out.println();
		
		// getAllByName해당 IP 주소를 배열함
		InetAddress[] iArr = InetAddress.getAllByName("www.youtube.com");
		
		for(int i = 0; i<iArr.length; i++) {
			System.out.println(iArr[i].getHostName() + " : " + iArr[i].getHostAddress());
		}
		
	}

}
