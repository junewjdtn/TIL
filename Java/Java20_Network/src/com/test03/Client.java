package com.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		Socket clientSocket = null;
		// 서버와 통신을 위한 입출력 생성
		PrintWriter out = null;
		BufferedReader in = null;
		
		// 키보드로 입력 받기 위해 생성
		BufferedReader stdIn = null;
		
		System.out.println("server에 접속합니다.");
		
		try {
			clientSocket = new Socket("localhost", 8888);
			
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			String inputLine = null;
			while((inputLine = stdIn.readLine()) != null) {
				out.println(inputLine);
				System.out.println("server로부터 다시 받은 메시지: " + in.readLine());
			}
			
			stdIn.close();
			in.close();
			out.close();
			clientSocket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
