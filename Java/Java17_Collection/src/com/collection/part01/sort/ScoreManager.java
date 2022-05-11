package com.collection.part01.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreManager {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(new Score("임정수", 99));
		list.add(new Score("김승우", 88));
		list.add(new Score("원현준", 77));
		list.add(new Score("김종호", 66));
		list.add(new Score("최승호", 86));
		list.add(new Score("박세인", 100));
		list.add(new Score("조유정", 72));
		
		System.out.println("list: " + list);
		
		Collections.sort(list);
		System.out.println("sortList: " + list);
		
		Collections.sort(list, new AscScore());
		System.out.println(list);
		
		Collections.sort(list, new DescScore());
		System.out.println(list);
		
	}

}
