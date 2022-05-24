package com.book.effectivejava.juu.chapter2.item5.factorymethod;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;
import com.book.effectivejava.juu.chapter2.item5.KoreanDictionary;

public class KoreanDictionaryFactory implements DictionaryFactory {
	@Override
	public Dictionary getDictionary() {
		return new KoreanDictionary();
	}
}
