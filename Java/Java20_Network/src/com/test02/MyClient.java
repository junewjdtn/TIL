package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MyClient {
	public static void main(String[] args) throws IOException {
		// 소켓 생성
		DatagramSocket ds = new DatagramSocket();
		System.out.println("Client");
		
		// 보낼 data
		byte[] buff = "연습입니다.".getBytes();
		
		// packet 생성 (보낼 데이터를 패킷에 담음)
		DatagramPacket sendP = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 9999);
		
		// 보냄
		ds.send(sendP);

		// 종료
		ds.close();
		ds.disconnect();
		
	}
	
}