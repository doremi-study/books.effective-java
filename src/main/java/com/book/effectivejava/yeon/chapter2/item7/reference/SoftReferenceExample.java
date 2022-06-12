package com.book.effectivejava.yeon.chapter2.item7.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        Object strong = new Object();//Strong Reference
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;//Soft Reference만 남음

        System.gc();
        Thread.sleep(3000L);

        //  쉡게 사라지지 않는다.
        //  메모리가 충분하기 때문에. 굳이 제거할 필요가 없기 때문에
        System.out.println(soft.get());
    }
}
