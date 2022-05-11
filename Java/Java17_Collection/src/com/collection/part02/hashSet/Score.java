package com.collection.part02.hashSet;

import java.util.Objects;

public class Score {
	private String name;
	private int kor;
	private int eng;
	
	// 생성자(기본, 매개변수)
	public Score() {}
	public Score(String name, int kor, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	// getter&setter
	// name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// kor
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	// eng
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(eng, kor, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return eng == other.eng && kor == other.kor && Objects.equals(name, other.name);
	}
	
	
	
	

}
