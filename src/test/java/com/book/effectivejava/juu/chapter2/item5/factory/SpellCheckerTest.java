package com.book.effectivejava.juu.chapter2.item5.factory;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.book.effectivejava.juu.chapter2.item5.MockDictionary;

class SpellCheckerTest {

	@Test
	void name() {
		//given
		SpellChecker spellChecker1 = new SpellChecker(MockDictionary::new);

		SpellChecker spellChecker2 = new SpellChecker(DictionaryFactory::get);
		//when

		//then
	}
}