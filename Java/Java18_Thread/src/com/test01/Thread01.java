package com.test01;

public class Thread01 {

	public static void main(String[] args) {
		System.out.println("===== main start =====");
		
		/*
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
		m1.run();
		m2.run();
		*/
		
		Thread m1 = new Thread(new MyThread());
		Thread m2 = new Thread(new MyThread());
		
		// thread가 각자 알아서 시작 됨 (동시에 사용할 수 있게 도와주는 기능 / 평소 코딩은 순서대로 진행되면서 시간이 걸리지만 thread는 동시에 사용가능 하다)
		// 네이버로 예로 들면 기존 코딩은 한 사람이 사용하면 다른 사람이 기다려야 하지만 thread를 사용하면 기다릴 필요없이 같이 사용 가능
		m1.start();
		m2.start();
		
		System.out.println("----- main stop -----");
		
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			System.out.println("i="+i);
		}
	}
}
