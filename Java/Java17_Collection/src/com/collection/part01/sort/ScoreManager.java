package com.collection.part01.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreManager {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(new Score("������", 99));
		list.add(new Score("��¿�", 88));
		list.add(new Score("������", 77));
		list.add(new Score("����ȣ", 66));
		list.add(new Score("�ֽ�ȣ", 86));
		list.add(new Score("�ڼ���", 100));
		list.add(new Score("������", 72));
		
		System.out.println("list: " + list);
		
		Collections.sort(list);
		System.out.println("sortList: " + list);
		
		Collections.sort(list, new AscScore());
		System.out.println(list);
		
		Collections.sort(list, new DescScore());
		System.out.println(list);
		
	}

}
