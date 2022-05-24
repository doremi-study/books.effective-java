package com.book.effectivejava.juu.chapter2.item5.dependencyinjection;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.book.effectivejava.juu.chapter2.item5.MockDictionary;

class SpellCheckerTest {

	@Test
	void isValid() {
		//given
		SpellChecker spellChecker = new SpellChecker(new MockDictionary());

		//when
		boolean test = spellChecker.isValid("apple");

		//then
		assertThat(test).isTrue();
	}
}