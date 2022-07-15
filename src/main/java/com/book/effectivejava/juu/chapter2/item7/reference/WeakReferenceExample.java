package com.book.effectivejava.juu.chapter2.item7.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
	public static void main(String[] args) throws InterruptedException {
		MyClass myClass = new MyClass();
		//strong 변수가 참조를 가지고 있는 한, Object 객체는 GC의 대상이 되지 않습니다.
		WeakReference<MyClass> weakReference = new WeakReference<>(myClass); //reference object
		myClass = null;

		System.gc();
		Thread.sleep(3000L);

		// TODO 거의 없어집니다.
		//  왜냐면 약하니까(?)...
		System.out.println("weak = " +  weakReference.get()); // referent
	}
}
