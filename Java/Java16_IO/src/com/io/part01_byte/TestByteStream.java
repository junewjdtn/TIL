package com.io.part01_byte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestByteStream {
	
	public void fileSave() {
		// fin을 try 안에서 호출하면 try안에서만의 호출된 변수이기때문에 public void 안에서 변수를 선언해줌
		FileOutputStream fout = null;
		
		try {
			fout = new FileOutputStream("sample.txt");
			fout.write(97);
			byte[] bar = {98, 99, 100, 101, 102, 10};
			fout.write(bar);
			fout.write(bar, 1, 3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public void fileOpen() {
		// fin을 try 안에서 호출하면 try안에서만의 호출된 변수이기때문에 public void 안에서 변수를 선언해줌
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("sample.txt");
			/* [1]
			int fileSize = (int)new File("sample.txt").length();
			byte[] bar = new byte[fileSize];
			
			fin.read(bar);
			
			for(int i = 0; i<bar.length; i++) {
				System.out.print((char)bar[i] + " ");
			}*/
			
			// [2]
			int val = 0;
			while((val=fin.read()) != -1) {
				System.out.print((char)val + " ");
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

	public void fileOpen2() {
		// try with resource
		try (FileInputStream fin = new FileInputStream("sample.txt")) {
			
			int size = (int)new File("sample.txt").length();
			byte[] bar = new byte[size];
			
			fin.read(bar);
			
			for(int i = 0; i<bar.length; i++) {
				System.out.print(bar[i] + " ");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}