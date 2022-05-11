package com.test.chap01;

public class ScoreMain {

	public static void main(String[] args) {
		Score my = new Score();
		
		// 총합
		my.sum();
		
		// 평균
		my.avg();
		
		// 높은 점수
		my.max();
		
		// 점수 확인
		my.prn();
	}
}
