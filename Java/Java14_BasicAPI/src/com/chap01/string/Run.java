package com.chap01.string;

public class Run {

	public static void main(String[] args) {
		Run.method1();
	}
	
	public static void method1() {
		// ���ڿ��� ���ͷ��� ����
		String str = "abc";
		String str1 = "abc";
		
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		
		// new ������ �̿�
		String str2 = new String("abc");
		String str3 = new String("abc");
		
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		
		System.out.println();
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		
		System.out.println("================");
		// charAt(i)
		// �ش� �ε����� ���ڸ�(i��° ���ڸ�) �ϳ� �������ڴ�
		System.out.println(str.charAt(0));
		
		// concat(��ġ��)
		System.out.println(str.concat("def"));
		
		// contains(���Կ���) -> true or false
		System.out.println(str.contains("a"));
		System.out.println(str.contains("u"));
		
		// equals() (��)
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("bc"));
		
		// length() (����)
		System.out.println(str.length());

		// split(���� ����)
		str1 = "a,b,c,d,e,f";
		String[] sArr = str1.split(",");
		for(String arr : sArr) {
			System.out.println(arr);
		}
		for(int i = 0; i<sArr.length; i++) {
			System.out.println(sArr[i]);
		}
		
		// toUpperCase(�빮�ڷ� �ٲپ���)
		System.out.println(str.toUpperCase());
		
		// toLowerCase(�ҹ��ڷ� �ٲپ���)
		System.out.println(str.toLowerCase());
		
		// substring(�߶󳻱�)
		System.out.println(str1.substring(2,4));
		
		// trim(������ ����) -> �� �հ� �� ���� ���鸸 ��������
		str2 = "       abc       ";
		System.out.println(str2);
		System.out.println(str2.trim());
		
	}

}
