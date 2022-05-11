package com.silsub2.point.main;

import com.silsub2.point.model.vo.Point;

public class Main {

	public static void main(String[] args) {
		Point p = new Point(5, 6);
		
		int[] Crr = new int[3];
		Crr[0] = 1;
		Crr[1] = 2;
		Crr[2] = 3;
		
		int[] Rrr = new int[3];
		Rrr[0] = 1;
		Rrr[1] = 2;
		Rrr[2] = 3;
		
		
		p.draw();
	}

}
