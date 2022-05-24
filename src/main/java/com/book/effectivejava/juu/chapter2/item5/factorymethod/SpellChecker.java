package com.book.effectivejava.juu.chapter2.item5.factorymethod;

import java.util.List;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;

public class SpellChecker {
	private final Dictionary dictionary;

	//확장에 열려있고(어느 dictionary든 가능)
	//변경에 닫혀있다.(클라이언트는 변경 안해도 된다)
	public SpellChecker(DictionaryFactory dictionaryFactory) {
		this.dictionary = dictionaryFactory.getDictionary();
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
