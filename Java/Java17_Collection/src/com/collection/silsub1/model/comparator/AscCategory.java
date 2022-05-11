package com.collection.silsub1.model.comparator;

import java.util.Comparator;

import com.collection.silsub1.model.dto.Book;

public class AscCategory implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		int other1 = ((Book)o1).getCategory();
		int other2 = ((Book)o2).getCategory();
		
		return other1-other2;
	}
	
	

}
