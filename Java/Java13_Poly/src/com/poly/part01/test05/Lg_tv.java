package com.poly.part01.test05;

public class Lg_tv implements Tv{
	// 필드
	private int vol;
	
	// 생성자
	public Lg_tv() {
		System.out.println("Lg TV가 켜졌습니다.");
	}
	// getter&setter
	// vol
	public int getVol() {
		return vol;
	}
	public void setVol(int vol) {
		this.vol = vol;
	}
	
	@Override
	public int volUp() {
		setVol(getVol()+1);
		return getVol();
	}
	@Override
	public int volDown() {
		vol = vol - 1;
		return vol;
	}
	
	public void tvClosed() {
		System.out.println("Lg TV가 꺼졌습니다.");
	}
	
}
