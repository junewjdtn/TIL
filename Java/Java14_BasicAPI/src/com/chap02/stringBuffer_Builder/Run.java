package com.chap02.stringBuffer_Builder;

public class Run {

	public static void main(String[] args) {
		// Run.method1();
		Run.method2();
	}
	
	public static void method1() {
		StringBuilder sb = new StringBuilder("�ƾ� ������ħ?");
		System.out.println(sb);
		
		String str = "�ȳ��ϼ���!";
		System.out.println("str ����: " + str + ", �ּ�: " + System.identityHashCode(str));
		
		str += "���� �������Դϴ�.";
		System.out.println("str �߰� ��: " + str + ", �ּ�: " + System.identityHashCode(str));
		
		StringBuffer sf = new StringBuffer("��ħ�� ����");
		System.out.println("sf ����: " + sf + ", �ּ�: " + sf.hashCode() + ", " + System.identityHashCode(sf));
		
		sf.append("�ҽ��ϳ׿�!");
		System.out.println("sf �߰� ��: " + sf + ", �ּ�: " + sf.hashCode() + ", " + System.identityHashCode(sf));
		
	}
	
	public static void method2() {
		StringBuilder sb = new StringBuilder("�� ");
		
		// append(�� �ڿ� �����߰�)
		sb.append("Ŀ�� �Ծ�");
		sb.append("~!");
		// sb.append("Ŀ�� �Ծ�").append("~!");
		System.out.println(sb);
		
		// length
		System.out.println(sb.length());
		
		// insert(���ϴ� ��ġ�� �����߰�)
		sb.insert(0, "���� �� ���� ");
		System.out.println(sb);
		
		// delete(���ϴ� ��ġ�� �������)
		sb.delete(0, 8);
		System.out.println(sb);
		
		// reverse
		sb.reverse();
		System.out.println(sb);
		
		
		
	}
	
}
