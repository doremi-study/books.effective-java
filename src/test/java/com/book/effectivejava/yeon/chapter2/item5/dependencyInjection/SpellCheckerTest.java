package com.book.effectivejava.yeon.chapter2.item5.dependencyInjection;

import com.book.effectivejava.yeon.chapter2.item5.DefaultDictionary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCheckerTest {

    @Test
    void isVaild() {
        SpellChecker spellChecker = new SpellChecker(new DefaultDictionary());
        spellChecker.isValid("test");
        /*
        의존 객체 주입의 장점
        1. 다른 test용 Dictionary로 얼마든지 교체가 가능하다.
        2. 의존성 재사용성이 높다
         */
    }
}