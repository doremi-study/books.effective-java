package com.book.effectivejava.juu.chapter2.item5.springioc;

import java.util.List;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;

public class SpringDictionary implements Dictionary {
	@Override
	public boolean contains(String word) {
		System.out.println("contains = " + word);
		return false;
	}

	@Override
	public List<String> closeWordTo(String typo) {
		return null;
	}
}
