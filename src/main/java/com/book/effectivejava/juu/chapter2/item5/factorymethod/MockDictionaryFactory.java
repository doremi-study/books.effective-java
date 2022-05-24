package com.book.effectivejava.juu.chapter2.item5.factorymethod;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;
import com.book.effectivejava.juu.chapter2.item5.KoreanDictionary;
import com.book.effectivejava.juu.chapter2.item5.MockDictionary;

public class MockDictionaryFactory implements DictionaryFactory {
	@Override
	public Dictionary getDictionary() {
		return new MockDictionary();
	}
}
