package com.book.effectivejava.juu.chapter2.item5;

import java.util.Arrays;
import java.util.List;

public class MockDictionary implements Dictionary{
	@Override
	public boolean contains(String word) {
		return true;
	}

	@Override
	public List<String> closeWordTo(String typo) {
		return Arrays.asList("apple", "app");
	}
}
