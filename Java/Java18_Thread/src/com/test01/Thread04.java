package com.test01;

public class Thread04 {

	public static void main(String[] args) {
		for(int i = 0; i<50; i++) {
			
			// �ش� Thread�� sleep() �и��� ��ŭ ������ ���Ѷ�
			// sleep(1000) -> 1�� ���� �ִٰ� �����ض�
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("�� ");
		}
		
		
		
	}

}
