package com.book.effectivejava.juu.chapter2.item5.springioc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;
@Component
public class SpellChecker {

	private Dictionary dictionary;

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

	//스프링이 원하는 모습!! -> non invesible(비침투적인) 본인의 코드를 노출하지 않고, POJO를 유지하면서 본인의 기능을 제공하고 싶다.
}
