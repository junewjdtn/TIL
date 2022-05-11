package com.test01;

public class Thread03 {

	public static void main(String[] args) {
		MyThread02 m1 = new MyThread02("¾ß¿Ë");
		MyThread02 m2 = new MyThread02("¸Û¸Û");
		
		long start = System.currentTimeMillis();
		m1.start();
		
		try {
			// m1 thread°¡ Á¾·á µÉ¶§ ±îÁö
			// ´Ù¸¥ thread¸¦ ¸ØÃá´Ù. -> .join();
			m1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		m2.start();
		long end = System.currentTimeMillis();
		
		System.out.println("½ÇÇà½Ã°£: " + (end-start));
		
	}

}
