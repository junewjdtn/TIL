package com.test.chap03.test01;

public class KindOfVariable { // Ŭ���� ���� ���ۺκ�
	// Ŭ���� ������ �ۼ��ϴ� ���� -> �ʵ�
	// �ʵ� == �������(Ŭ������ ������ ������ �ǹ�) == ��������(Ŭ���� �������� ����� �� �ִ� ������� �ǹ�)
	private int globalNum;
	
	
	public void testMethod(int num /*�޼ҵ� ��ȣ �ȿ� �����ϴ� ���� -> �Ű�����*/) {// �޼ҵ� ���� ���ۺκ�
		// �޼ҵ� �������� �ۼ��ϴ� ���� -> ��������
		int localNum;
		
		// ���������� ���� �ܿ� ����ϱ� ���ؼ��� �ݵ�� �ʱ�ȭ �Ǿ�� �Ѵ�.
		//System.out.println(localNum);
		
		System.out.println(num);
		
		System.out.println(globalNum);
		
	}// �޼ҵ� ���� ���κ�
	
	public void testMethod2() {
		System.out.println(globalNum);
		//System.out.println(localNum);
	}
}// Ŭ���� ���� ���κ�
