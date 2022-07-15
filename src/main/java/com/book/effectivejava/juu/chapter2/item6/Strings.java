package com.book.effectivejava.juu.chapter2.item6;

public class Strings {
	public static void main(String[] args) {
		String hello = "hello";
		String hello2 = new String("hello");
		//jvm은 내부적으로 문자열을 pool에서 캐싱.. 위로 만들면 강제적으로 불필요한 객체 생성
		String hello3 = "hello";
		System.out.println(hello == hello2);
		System.out.println(hello.equals(hello2));
	}
}
