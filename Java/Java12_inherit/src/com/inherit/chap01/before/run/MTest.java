package com.inherit.chap01.before.run;

import java.util.Date;

import com.inherit.chap01.before.model.dto.Desktop;
import com.inherit.chap01.before.model.dto.SmartPhone;
import com.inherit.chap01.before.model.dto.Television;

public class MTest {

	public static void main(String[] args) {
		// °´Ã¼ »ý¼º ÈÄ °ª ³Ö±â
		Desktop d = new Desktop("SAMSUNG", "01", "S-01234", "»ï¼º ³ëÆ®ºÏ",
				"i5-5200", 128, 8, "WindowOs", 110, new Date(), true);
		
		SmartPhone s = new SmartPhone("SAMSUNG", "02", "SM-43210", 
				"Galaxy Note10+", "½º³Àµå·¡°ï", 256, 12, "Android", 100, 
				new Date(), "KT");
		
		Television t = new Television("LG", "03", "T-22334", "LG-OLEDTV"
				, 350, new Date(), 65);
		
		d.information();
		s.information();
		t.information();

	}
}