package com.book.effectivejava.juu.chapter2.item5.staticutils;

import java.util.List;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;
import com.book.effectivejava.juu.chapter2.item5.KoreanDictionary;

public class SpellChecker {
	//영어사전인지, 독일어사전인지, 한국어 사전인지 달라질 수가 있다.
	// 이렇게 작성하면 dictonary를 바꿀 수 없다. -> 이건 영어에 관한 spellChecker만 가능
	// (new로 객체 생성) 자원을 직접 명시 ! -> 의존성 주입을 사용하자
	private static final Dictionary dictionary = new KoreanDictionary();
	private SpellChecker() {}

	public static boolean isValid(String word) {
		// TODO 여기 SpellChecker 코드
		return dictionary.contains(word);
	}

	public static List<String> suggestions(String typo) {
		// TODO 여기 SpellChecker 코드
		return dictionary.closeWordTo(typo);
	}
}
