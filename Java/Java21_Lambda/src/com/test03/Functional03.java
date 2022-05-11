package com.test03;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functional03 {
	public static void main(String[] args) {
		// func01();
		// func02();
		func03();
		
		
	}
	
	public static void func01() {
		// Function 매개변수가 있고, 반환값도 있음
		// apply();
		// Function<매개변수, 리턴값>
		Function<Integer, String> ti = n -> (n<10)?"0"+n : ""+n;
		System.out.println(ti.apply(1));
		System.out.println(ti.apply(6));
		System.out.println(ti.apply(10));
		System.out.println(ti.apply(13));
		
	}
	
	public static void func02() {
		// BiFunction 
		// BiFunction<매개변수, 매개변수, 리턴값> sum = (i, j) -> 받은 i 값을 정수형으로 저장 + 받은 j 값을 정수형으로 저장
		BiFunction<String, String, Integer> sum = (i, j) -> Integer.parseInt(i) + Integer.parseInt(j);
		
		System.out.println(sum.apply("10", "20"));
	}
	
	public static void func03() {
		// supplier : 매개변수 없고, 반환값은 있음
		Supplier<Integer> run = () -> (int)(Math.random()*45)+1;
		System.out.println(run.get());
		
		// consumer : 매개변수 있고, 반환값은 없음
		Consumer<String> hello = (name) -> System.out.println("hello, " + name);
		hello.accept("Lambda");
		
	}
	
}
