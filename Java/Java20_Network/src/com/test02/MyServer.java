package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {
	public static void main(String[] args) throws IOException {
		// ���� ����(���� ����)
		DatagramSocket ds = new DatagramSocket(9999);
		System.out.println("Server");
		
		// ���� �迭 ����
		byte[] buff = new byte[1024];
		
		// ��Ŷ�� ����
		DatagramPacket receiveP = new DatagramPacket(buff, buff.length);
		
		// ��Ŷ�� ����
		ds.receive(receiveP);
		
		// ��Ŷ�� ����� �����͸� ���
		System.out.println(new String(receiveP.getData()));
		
		// ����
		ds.close();
		ds.disconnect();
		
	}
	
}
