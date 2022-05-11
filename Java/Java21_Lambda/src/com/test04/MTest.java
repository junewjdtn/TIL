package com.test04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MTest {
	// 스트림
	public static void main(String[] args) {
		// createStream();
		// createStream2();
		pipeline();
	}
	
	public static void pipeline() {
		// stream은 한개만 실행 하는 것이 아닌, 여러개를 파이프라인으로 함수들을 붙여 실행가능
		
		List<String> class504 = Arrays.asList("원현준", "양성식", "조유정", "최승호", "이태영", "김승우", "양성희");
		List<String> s = class504.stream().filter( name -> name.contains("승")).sorted().collect(Collectors.toList());
		
		System.out.println(s);
		
		class504.stream().filter(name -> name.contains("승")).sorted().map(w -> w.replace(w.substring(1, w.length()), "*".repeat(w.length()-1)))
		//																			ㄴ> 위치를 변경하는 매소드
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println( class504.stream().filter(name->name.contains("승")).sorted().collect(Collectors.toList()));
	}
	
	public static void createStream2() {
		String[] arr = new String[] {"1", "2", "3", "4", "5", "6"};
		Stream<String> stream01 = Arrays.stream(arr);
		stream01.forEach(System.out::println);
		
		List<String> list01 = Arrays.asList(arr);
		list01.forEach(System.out::print);
	}
	
	public static void createStream() {
		// builder : 스트림에 직접적으로 원하는 값 넣을 수 있다.
		// 마지막에 build() 메소드를 호출하여 스트림을 리턴
		Stream<String> stream01 = Stream.<String>builder().add("홍길동").add("이순신").add("유관순").build();
		stream01.forEach(System.out::println);
		//          ㄴ> for(String s : 배열 or 리스트) { System.out.println(); }
		
		// empty : 비어있는 스트림 생성
		Stream<String> stream02 = Stream.empty();
		System.out.println(stream02.toArray().length);
		
		// generate : 람다 사용 가능(Supplier),
		Stream<Integer> stream03 = Stream.generate(() -> 100).limit(5);
		//														ㄴ> limit()에 적혀있는 숫자 만큼 만든다
		stream03.forEach(System.out::println);
		
		// iterate : 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만든다.
		Stream<Integer> stream04 = Stream.iterate(1, (i) -> ++i).limit(5);
		//									 	  ㄴ> 초기값  ㄴ> 람다의 해당 값
		stream04.forEach(System.out::println);
		
		// range(범위)
		// IntStream range01 = IntStream.range(1, 5); -> 1부터 5이전까지의 값 출력
		IntStream range01 = IntStream.rangeClosed(1, 5);
		// 									ㄴ> 1부터 5까지 출력
		range01.forEachOrdered((i) -> System.out.print(i + " "));
	}
}