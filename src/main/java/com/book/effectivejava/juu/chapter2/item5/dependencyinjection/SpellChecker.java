package com.book.effectivejava.juu.chapter2.item5.dependencyinjection;

import java.util.List;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;

public class SpellChecker {
	// dictionary 가 interface일때! 재사용이 가능하다
	private final Dictionary dictionary;

	public SpellChecker(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드(부가적인 코드)
		return dictionary.contains(word);
	}

	public List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordTo(typo);
	}
}
