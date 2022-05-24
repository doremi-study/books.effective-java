package com.book.effectivejava.juu.chapter2.item5;

import java.util.List;

public class KoreanDictionary implements Dictionary{
	@Override
	public boolean contains(String word) {
		return false;
	}

	@Override
	public List<String> closeWordTo(String typo) {
		return null;
	}
}
