package com.book.effectivejava.yeon.chapter2.item4;

public abstract class UtilityClass2 {

    public UtilityClass2() {
        //Default Constructors
        System.out.println("Constructors");
        /*
        자식 클래스의 인스턴스를 생성할 때, 기본 생성자에서 부모 생성자를 호출하기 때문에
        부모 클래스를 abstract으로 둔다 해도 생성자가 호출되어 인스턴스가 만들어질 수 있다.
         */
    }

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        UtilityClass2.hello();

//        UtilityClass2 utilityClass = new UtilityClass2();
        /*
        인스턴스 생성을 막기 위해 abstrct 클래스로 둘 경우, 상속을 해서 사용하는 클래스인가?라고 착각하게 만들 수 있다.
         */
    }
}
