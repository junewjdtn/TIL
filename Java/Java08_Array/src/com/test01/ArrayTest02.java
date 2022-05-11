package com.test01;

public class ArrayTest02 {
	public static void main(String[] ars) {
		//�迭�� ������ �Է�
		//a~z
		char[] ch = new char[26];
		for(int i=0; i<26; i++) {
			ch[i] = (char)((int)'a'+i);
		}
		
		//1. a~z�� ����ִ� ������ �迭 ���
		new ArrayTest02().prn(ch);
		
		//2. �迭�� �Ųٷ� ���
		new ArrayTest02().reverse(ch);
		
		//3. �빮�ڷ� �����Ͽ� ���
		new ArrayTest02().upper(ch);
	}
	
	public void prn(char[] ch) {
		// a b c d e . . . x y z
		for(int i=0; i<ch.length; i++) {
			System.out.print(ch[i] + " ");
			if(i%6==5) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}
	
	public void reverse(char[] ch) {
		//���ο� �迭 re[] �� ����� �������� ���� �� re ���
		/*char[] re = new char[26]; // char re[] = new char[ch.length];
		for(int i=0; i<26; i++) {
			re[i] = (char)((int)'z'-i);
			System.out.print(re[i] + " ");
			if(i%6==5) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();*/
		char re[] = new char[26];
		int temp=0;
		for(int i=ch.length-1; i>=0; i--) {
			re[temp] = ch[i];
			temp++;
		}
		prn(re);
	}
	
	public void upper(char[] ch) {
		//ch -> �빮�ڷ� , prn(ch)
		for(int i=0; i<ch.length; i++) {
			ch[i] = (char)((int)ch[i]-32);
			//ch[i] = character.toUpperCase(ch[i]);
		}
		prn(ch);
	}
	
}
