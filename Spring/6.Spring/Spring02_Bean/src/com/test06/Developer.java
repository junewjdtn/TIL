package com.test06;

public class Developer {
	
	private Emp emp;
	private String dept;
	
	public Developer() {
		super();
	}

	public Developer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp + " Developer [dept=" + dept + "]";
	}
	
}
