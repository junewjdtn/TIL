package com.collection.part02.hashSet;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
	public void testHashSet() {
		// HashSet
		HashSet hset = new HashSet();
		
		hset.add("Java");
		hset.add(123);
		hset.add(45.67);
		hset.add(new Date());
		System.out.println("hset: " + hset);
		
		hset.add("Java");
		hset.add(123);
		System.out.println("hset: " + hset);
		System.out.println("저장된 객체수: " + hset.size());
		
		// [1] toArray()
		Object[] arr = hset.toArray();
		for(int i = 0; i<arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		
		// [2] Iterator()
		Iterator iter = hset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// hset.remove("Java");
		hset.clear();
		System.out.println(hset);
		
		hset.add(new Score("임정수", 100, 99));
		hset.add(new Score("조성득", 85, 87));
		hset.add(new Score("조유정", 72, 48));
		hset.add(new Score("최승호", 80, 82));
		System.out.println("hset: " + hset);
		System.out.println("갯수: " + hset.size());
		
		hset.add(new Score("임정수", 100, 99));
		System.out.println("추가 후 hset: " + hset);
		System.out.println("추가 후 갯수: " + hset.size());
		
	}
	
}
