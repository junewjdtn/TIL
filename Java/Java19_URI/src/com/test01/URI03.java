package com.test01;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URI03 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// URL url = new URL("http://google.com");
		// URLConnection urlConn = url.openConnection();
		URLConnection urlConn = new URL("http://google.com").openConnection();
		
		BufferedInputStream buff = new BufferedInputStream(urlConn.getInputStream());
		
		int byteRead = 0;
		while((byteRead = buff.read()) != -1) {
			System.out.print((char)byteRead);
		}
		buff.close();
	}

}
