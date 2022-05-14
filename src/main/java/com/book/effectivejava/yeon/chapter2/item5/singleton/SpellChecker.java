package com.book.effectivejava.yeon.chapter2.item5.singleton;

import com.book.effectivejava.yeon.chapter2.item5.DefaultDictionary;

import java.util.List;

public class SpellChecker {
    private static final DefaultDictionary DEFAULT_DICTIONARY = new DefaultDictionary();

    public SpellChecker() {
    }
    public static final SpellChecker INSTANCE = new SpellChecker()
;
    public static boolean isValid(String word) {
        //SpellChecker 로직
        return DEFAULT_DICTIONARY.contains(word);
    }

    public static List<String> suggestions(String typo) {
        //SpellChecker 로직
        return DEFAULT_DICTIONARY.closeWordsTo(typo);
    }
}
