package com.io.part03.add.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferStreamTest {
	public void fileSave() {
		/*// 보조스트림
		BufferedWriter bw = null;
		// 기반스트림
		FileWirter fw = null;
		
		fw = new FileWriter("sample3.txt");
		bw = new BufferedWriter(fw);
		*/
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter("sample3.txt"));
			
			bw.write("안녕하세요.\n");
			bw.write("반갑습니다.\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileOpen() {
		
		try (BufferedReader br = new BufferedReader(new FileReader("sample3.txt"));){
			
			String tmp = null;
			
			while((tmp = br.readLine()) != null) {
				System.out.println(tmp);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
}