package com.collection.part01.sort;

import java.util.Comparator;

public class AscScore implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// 점수 오름차순
		int other1 = ((Score)o1).getScore();
		int other2 = ((Score)o2).getScore();
		
		if(other1 > other2) {
			return 1;
		}else {
			return -1;
		}
		
	}
	

}
