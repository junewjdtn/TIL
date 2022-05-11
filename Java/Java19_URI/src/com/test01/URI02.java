package com.test01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URI02 {

	public static void main(String[] args) throws IOException {
		byte[] b = new byte[1];
		
		URL url = new URL("https://blog.kakaocdn.net/dn/s2lgA/btq5MoiuW18/SMwkcZ2Lc1H44TlyjKwKwK/img.png");
		
		// 연결하겠다.
		URLConnection urlConn = url.openConnection();
		urlConn.connect();
		
		// 외부 이미지랑 연결 (불러온다)
		DataInputStream di = new DataInputStream(urlConn.getInputStream());
		
		// a.png로 외부로 출력 (내보낸다)
		FileOutputStream fs = new FileOutputStream("a.png");
		
		// -1 -> 바이트 배열 내에 데이터가 있는 경우
		while(di.read(b, 0, 1) != -1) {
			fs.write(b, 0, 1);
		}
		System.out.println("완료!");
		di.close();
		fs.close();
	}

}
