package com.test02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MyClient {
	public static void main(String[] args) throws IOException {
		// ���� ����
		DatagramSocket ds = new DatagramSocket();
		System.out.println("Client");
		
		// ���� data
		byte[] buff = "�����Դϴ�.".getBytes();
		
		// packet ���� (���� �����͸� ��Ŷ�� ����)
		DatagramPacket sendP = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"), 9999);
		
		// ����
		ds.send(sendP);

		// ����
		ds.close();
		ds.disconnect();
		
	}
	
}