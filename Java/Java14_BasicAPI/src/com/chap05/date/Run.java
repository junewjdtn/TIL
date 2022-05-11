package com.chap05.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Run {

	public static void main(String[] args) {
		
		// Date
		Date date1 = new Date();
		System.out.println(date1);
		
		Date today = new Date();
		System.out.println(today);
		
		// 원하는 포맷으로 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(today));
		
		// System.out.println(today.getDay());
		
		System.out.println("=====캘린더=====");
		Calendar calendar = Calendar.getInstance(); // 현재시간
		System.out.println(calendar);
		calendar.set(2019, 9-1, 9);
		
		
		int year = calendar.get(1);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		
		System.out.println(year+ "년 " + month + "월 " + date + "일 " + hour + ":" + min + ":" + sec);
		System.out.println(calendar.getTime());
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
		System.out.println(sdf1.format(calendar.getTime()));
		
		Calendar cal = (Calendar)calendar.clone();
		cal.add(Calendar.YEAR, -9);
		cal.add(Calendar.MONTH, -3);
		cal.add(Calendar.DATE, 20);
		
		System.out.println(cal.getTime());
		
		System.out.println("=====그레고리안======");
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.getTime());
		
		System.out.println("year: " + gc.get(GregorianCalendar.YEAR));
		System.out.println("month: " + gc.get(Calendar.MONTH));
		System.out.println("date: " + gc.get(5));
		
		// 윤년확인 (2월 29일이 4년에 한번 찾아오는 날)
		System.out.println(gc.isLeapYear(2024));
		
		
	}
	
	
	

}
