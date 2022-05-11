package com.test04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MTest {
	// ��Ʈ��
	public static void main(String[] args) {
		// createStream();
		// createStream2();
		pipeline();
	}
	
	public static void pipeline() {
		// stream�� �Ѱ��� ���� �ϴ� ���� �ƴ�, �������� �������������� �Լ����� �ٿ� ���డ��
		
		List<String> class504 = Arrays.asList("������", "�缺��", "������", "�ֽ�ȣ", "���¿�", "��¿�", "�缺��");
		List<String> s = class504.stream().filter( name -> name.contains("��")).sorted().collect(Collectors.toList());
		
		System.out.println(s);
		
		class504.stream().filter(name -> name.contains("��")).sorted().map(w -> w.replace(w.substring(1, w.length()), "*".repeat(w.length()-1)))
		//																			��> ��ġ�� �����ϴ� �żҵ�
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println( class504.stream().filter(name->name.contains("��")).sorted().collect(Collectors.toList()));
	}
	
	public static void createStream2() {
		String[] arr = new String[] {"1", "2", "3", "4", "5", "6"};
		Stream<String> stream01 = Arrays.stream(arr);
		stream01.forEach(System.out::println);
		
		List<String> list01 = Arrays.asList(arr);
		list01.forEach(System.out::print);
	}
	
	public static void createStream() {
		// builder : ��Ʈ���� ���������� ���ϴ� �� ���� �� �ִ�.
		// �������� build() �޼ҵ带 ȣ���Ͽ� ��Ʈ���� ����
		Stream<String> stream01 = Stream.<String>builder().add("ȫ�浿").add("�̼���").add("������").build();
		stream01.forEach(System.out::println);
		//          ��> for(String s : �迭 or ����Ʈ) { System.out.println(); }
		
		// empty : ����ִ� ��Ʈ�� ����
		Stream<String> stream02 = Stream.empty();
		System.out.println(stream02.toArray().length);
		
		// generate : ���� ��� ����(Supplier),
		Stream<Integer> stream03 = Stream.generate(() -> 100).limit(5);
		//														��> limit()�� �����ִ� ���� ��ŭ �����
		stream03.forEach(System.out::println);
		
		// iterate : �ʱⰪ�� �ش� ���� �ٷ�� ���ٸ� �̿��ؼ� ��Ʈ���� �� ��Ҹ� �����.
		Stream<Integer> stream04 = Stream.iterate(1, (i) -> ++i).limit(5);
		//									 	  ��> �ʱⰪ  ��> ������ �ش� ��
		stream04.forEach(System.out::println);
		
		// range(����)
		// IntStream range01 = IntStream.range(1, 5); -> 1���� 5���������� �� ���
		IntStream range01 = IntStream.rangeClosed(1, 5);
		// 									��> 1���� 5���� ���
		range01.forEachOrdered((i) -> System.out.print(i + " "));
	}
}