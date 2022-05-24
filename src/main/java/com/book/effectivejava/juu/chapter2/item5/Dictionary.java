package com.book.effectivejava.juu.chapter2.item5;

import java.util.List;

public interface Dictionary {
	public boolean contains(String word);

	public List<String> closeWordTo(String typo);
}
