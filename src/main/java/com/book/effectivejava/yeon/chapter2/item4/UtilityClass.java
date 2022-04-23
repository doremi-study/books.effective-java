package com.book.effectivejava.yeon.chapter2.item4;

public class UtilityClass {

    /*
    static method
     */
    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        UtilityClass.hello();//static 메서드는 클래스를 통해 접근할 수 있다.

        /*
        클래스의 인스턴스를 생성해서도 static메서드에 접근할 수 있지만, 불필요하다.
        인스턴스로 사용하기 위해 만든 클래스가 아니라면! ex) Util성 클래스
         */
        UtilityClass utilityClass = new UtilityClass();
        utilityClass.hello();//자동완성은 안되지만 문법적으로는 가능한 코드

        /*
        인스턴스 목적으로 사용할 메서드인지, static 목적으로 사용할 메서드인지 헷갈리게 만들 수 있기 때문에
        아예 인스턴스화를 방지하자
         */
    }
}
