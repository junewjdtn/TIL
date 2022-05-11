package com.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// 서버 생성
		ServerSocket serverSocket = null;
		
		// 접속된 클라이언트 소캣
		Socket serviceSocket = null;
		
		// 출력 객체
		PrintWriter out = null;
		
		BufferedReader in = null;
		
		try {
			// 서버소캣을 8888로 만듦
			serverSocket = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("client를 기다립니다.");
			
			try {
				// 8888 포트로 연결 요청을 받아 들이겠다
				serviceSocket = serverSocket.accept();
				System.out.println("client가 접속했습니다.");
				
				// client에게 받은 내용을 라인단위로 읽어오기
				in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
				
				// 잘받았다라고 다시 보내 주겠다.
				out = new PrintWriter(serviceSocket.getOutputStream(), true);
				
				String inputLine = null;
				while((inputLine = in.readLine()) != null) {
					System.out.println("클라이언트가 보낸 메시지: " + inputLine);
					
					out.println(inputLine + " - 메시지 잘 받았어!");
				}
				out.close();
				in.close();
				serviceSocket.close();
				serverSocket.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
