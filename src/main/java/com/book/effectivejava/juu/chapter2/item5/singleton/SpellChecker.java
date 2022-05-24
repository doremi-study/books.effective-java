package com.book.effectivejava.juu.chapter2.item5.singleton;

import java.util.List;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;
import com.book.effectivejava.juu.chapter2.item5.EnglishDictionary;

public class SpellChecker {
	//싱글톤으로 작성하면 유연성이 떨어지고, 재사용성이 떨어짐
	//또 dictionary 추가해야함. -> ex KoreanSpellChecker, EnglishSpellChecker..
	private final Dictionary dictionary = new EnglishDictionary();
	private SpellChecker() {}
	public static final SpellChecker INSTANCE = new SpellChecker();

	public boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드(부가적인 코드)
		return dictionary.contains(word);
	}

	public List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordTo(typo);
	}
}
