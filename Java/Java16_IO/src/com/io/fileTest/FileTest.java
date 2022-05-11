package com.io.fileTest;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		// 객체 생성
		File file = new File("person.txt");
		
		System.out.println("파일명: " + file.getName());
		// 절대경로 확인법
		System.out.println("저장경로: " + file.getAbsolutePath());
		// 파일 저장경로 확인법
		System.out.println("저장경로: " + file.getPath());
		System.out.println("용량: " + file.length());
		System.out.println("상위폴더: " + file.getParent());
		
		try {
			// 파일 생성 후 파일이 있는지 참 거짓으로 확인
			boolean b = file.createNewFile();
			System.out.println(b);
			
			// 파일 삭제 후 파일이 있는지 참 거짓으로 확인
			boolean b1 = file.delete();
			System.out.println(b1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}