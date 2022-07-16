package com.book.effectivejava.yeon.chapter2.item7.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();
        WeakReference<Object> weak = new WeakReference<>(strong);
        strong = null;//strong 참조 삭제

        System.gc();
        Thread.sleep(3000L);

        //무조건 사라진다.
        System.out.println(weak.get());

    }
}
