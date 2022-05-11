package com.poly.part01.test06;

public abstract class AreaImpl implements Area {
	
	private String result;
	
	// result_setter
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public void print() {
		System.out.println(Area.print + result);
	}

	@Override
	public abstract void make();	
	

}
