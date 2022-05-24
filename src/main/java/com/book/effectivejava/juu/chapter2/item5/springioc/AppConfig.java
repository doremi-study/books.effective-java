package com.book.effectivejava.juu.chapter2.item5.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.book.effectivejava.juu.chapter2.item5.Dictionary;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class) //AppConfig.class 가 있는 패키지 부터 스캔하겠다~
public class AppConfig {

	// 컴포넌트 스캔 사용할 경우
	// @Bean
	// public SpellChecker spellChecker(Dictionary dictionary) {
	// 	return new SpellChecker(dictionary);
	// }
	//
	// @Bean
	// public Dictionary dictionary() {
	// 	return new SpringDictionary();
	// }
}
