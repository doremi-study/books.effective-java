package com.book.effectivejava.yeon.chapter2.item5.staticUtils;


import com.book.effectivejava.yeon.chapter2.item5.DefaultDictionary;

import java.util.List;

public class SpellChecker {
    /*
    Dictionary 자원을 직접 명시하고 있다. == 자원을 직접 생성하고 있다.
     */
    private static final DefaultDictionary DEFAULT_DICTIONARY = new DefaultDictionary();

    public SpellChecker() {
    }

    public static boolean isValid(String word) {
        //SpellChecker 로직
        return DEFAULT_DICTIONARY.contains(word);
    }

    public static List<String> suggestions(String typo) {
        //SpellChecker 로직
        return DEFAULT_DICTIONARY.closeWordsTo(typo);
    }
}
