package com.book.effectivejava.yeon.chapter2.item7.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        BigObject strong = new BigObject();
        ReferenceQueue<BigObject> rq = new ReferenceQueue<>();//팬텀 레퍼런스는 큐가 필요. 자원이 언제 반납되는지 파악하기 위해 사용

        /*BigObjectReference<BigObject> phantom = new BigObjectReference<>(strong, rq);*/
        PhantomReference<BigObject> phantom = new PhantomReference<>(strong, rq);
        /*
        phantom은
        strong reference 참조를 끊고나서 gc가 동작할 때
        끊긴 strong은 사라지고
        레퍼런스큐에 phantom 레퍼런스가 들어간다.
        나중에 레퍼런스큐에서 꺼내서 정리한다.

        레퍼런스큐
        1. 자원정리를 위해 사용. 자바의 finalize 메서드가 있는데, 이거 사용권장하지 않고 그보다 나은 방법이 레퍼런스큐. 근데 사실 이보다 좋은 방법 있음(try resource)
        2. 이 큰 객체가 언제 메모리에서 해제되는지 파악하기 위해 사용. 언제 사라졌는가. 사라짐과 동시에 레퍼런스큐에 들어가기 때문에 거기 있나? 라는걸 보고 아 다음 큰작업 해도 되겠네 라고 판단.
         */
        strong = null;

        System.gc();
        Thread.sleep(3000L);

        System.out.println(phantom.isEnqueued());

        Reference<? extends BigObject> reference = rq.poll();
        /*BigObjectReference bigObjectCleaner = (BigObjectReference) reference;
        bigObjectCleaner.cleanUp();*/
        reference.clear();//최종적으로 팬텀 레퍼런스가 사라진다.
    }
}
