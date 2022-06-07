package com.book.effectivejava.juu.chapter2.item7.reference;

public class MyClass {
	private String name;

	public MyClass() {
		this.name = "juu";
	}

	@Override
	public String toString() {
		return "MyClass{" +
			"name='" + name + '\'' +
			'}';
	}
}
