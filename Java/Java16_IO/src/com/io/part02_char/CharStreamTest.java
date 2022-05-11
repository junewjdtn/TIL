package com.io.part02_char;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamTest {
	public void fileSave() {
		// new 보조스트림(다른스트림);
		// new 보조스트림(new 기반스트림(외부자원));
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("sample2.txt");
			fw.write("우리나라 대한민국");
			fw.write('A');
			char[] car = {'a', 'p', 'p', 'l', 'e'};
			fw.write(car);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				System.out.println("저장 완료");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void fileOpen() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("sample2.txt");
			
			int val = 0;
			while((val=fr.read()) != -1) {
				System.out.print((char)val);
			}
			
			System.out.println("======");
			for(int i = 0; i<50; i++) {
				System.out.println(fr.read());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}