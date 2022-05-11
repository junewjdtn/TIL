package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {
	public static void main(String[] args) throws IOException {
		// 서버 생성(소켓 생성)
		DatagramSocket ds = new DatagramSocket(9999);
		System.out.println("Server");
		
		// 받을 배열 생성
		byte[] buff = new byte[1024];
		
		// 패킷을 받음
		DatagramPacket receiveP = new DatagramPacket(buff, buff.length);
		
		// 패킷을 저장
		ds.receive(receiveP);
		
		// 패킷에 담겨진 데이터를 출력
		System.out.println(new String(receiveP.getData()));
		
		// 종료
		ds.close();
		ds.disconnect();
		
	}
	
}
