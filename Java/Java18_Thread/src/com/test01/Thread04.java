package com.test01;

public class Thread04 {

	public static void main(String[] args) {
		for(int i = 0; i<50; i++) {
			
			// 해당 Thread를 sleep() 밀리초 만큼 딜레이 시켜라
			// sleep(1000) -> 1초 정도 있다가 실행해라
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("♥ ");
		}
		
		
		
	}

}
