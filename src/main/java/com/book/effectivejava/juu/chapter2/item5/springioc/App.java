package com.book.effectivejava.juu.chapter2.item5.springioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		// SpellChecker spellChecker = new SpellChecker(); <- spring이 모르는 객체
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		SpellChecker spellChecker = applicationContext.getBean(SpellChecker.class); //스프링이 싱글톤으로 만들어준.. 스프링 라이프 사이클을 거치는 .. bean
		spellChecker.isValid("test");
	}
}
