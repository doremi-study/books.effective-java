package com.book.effectivejava.yeon.chapter2.item5.staticUtils;

import com.book.effectivejava.yeon.chapter2.item5.staticUtils.SpellChecker;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpellCheckerTest {

    @Test
    void SpellChecker_사용() {
        assertThat(SpellChecker.isValid("word"));
        /*
        SpellChecker 사용할 때마다,
        SpellChecker의 static 필드인 Dictionary를 매번 생성하게 된다. -> 자원을 직접 명시하고 있기 때문에.
         */
        /*
        가짜 Dictionary를 사용하고 싶다. Mocking하고 싶은데,
        자원을 직접 명시한 Dictionary를 Mocking하기 어렵다(할 수는 있는데 권장 안 함)
         */
    }
}