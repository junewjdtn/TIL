package com.inherit.chap01.after.run;

import java.util.Date;

import com.inherit.chap01.after.model.dto.Computer;
import com.inherit.chap01.after.model.dto.Desktop;
import com.inherit.chap01.after.model.dto.Product;
import com.inherit.chap01.after.model.dto.SmartPhone;
import com.inherit.chap01.after.model.dto.Television;


public class MTest {

	public static void main(String[] args) {
		// °´Ã¼
		Television t = new Television("LG", "01", "T-12345", "LG TV",
				400, new Date(), 65);
		
		Desktop d = new Desktop("»ï¼º", "02", "D-23456", "»ï¼º ³ëÆ®ºÏ", 
				200, new Date(), "i5-5200", 128, 8, "WindowOs", true);
		
		SmartPhone s = new SmartPhone("»ï¼º", "03", "SM-44242", "Galaxy Note10+"
				, 130, new Date(), "½º³Àµå·¡°ï", 256, 12, "Android", "KT");
		
		// Ãâ·Â
		System.out.println(t.information());
		System.out.println(d.information());
		System.out.println(s.information());
		
	}
}