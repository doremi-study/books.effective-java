package com.book.effectivejava.juu.chapter2.item5.factory;

import java.util.List;
import java.util.function.Supplier;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;

public class SpellChecker {
	// dictionary 가 interface일때! 재사용이 가능하다
	private final Dictionary dictionary;

	//자원을 바로 받는 게 아니라 만들어주는 factory를 통해서 받는다!!!
	// 중간 단계를 한번 더 추상화 시킨다.
	public SpellChecker(DictionaryFactory dictionaryFactory) {
		this.dictionary = dictionaryFactory.get();
	}

	// public SpellChecker(Supplier<Dictionary> dictionarySupplier) {
	// 	this.dictionary = dictionarySupplier.get();
	// }

	//한정적 와일드 카드 타입을 사용헤서 팩터리 타입 매개변수를 제한해야 한다.
	public SpellChecker(Supplier<? extends Dictionary> dictionarySupplier) {
		this.dictionary = dictionarySupplier.get();
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
