package com.book.effectivejava.yeon.chapter2.item5.dependencyInjection;

import com.book.effectivejava.yeon.chapter2.item5.DefaultDictionary;

import java.util.List;

public class SpellChecker {

    private final DefaultDictionary defaultDictionary;

    public SpellChecker(DefaultDictionary defaultDictionary) {
        /*
        Dictionary가 바뀌어도 SpellChecker 로직은 재사용 가능하다.
        이때, Dictionary는 인터페이스이어야 한다.
         */
        this.defaultDictionary = defaultDictionary;
    }

    public boolean isValid(String word) {
        //SpellChecker 로직
        return defaultDictionary.contains(word);
    }

    public List<String> suggestions(String typo) {
        //SpellChecker 로직
        return defaultDictionary.closeWordsTo(typo);
    }
}
