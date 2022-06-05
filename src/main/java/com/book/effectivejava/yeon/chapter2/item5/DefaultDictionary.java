package com.book.effectivejava.yeon.chapter2.item5;

import lombok.Builder;

import java.util.List;

public class DefaultDictionary implements Dictionary {

    @Override
    public boolean contains(String word) {
        return false;
    }

    @Override
    public List<String> closeWordsTo(String typo) {
        return null;
    }
}
