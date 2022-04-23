package com.book.effectivejava.yeon.chapter2.item4;

public class UtilityClass3 {

    /**
     * 이 클래스는 인스턴스를 만들 수 없습니다. (문서화해서 굳이 왜 못 쓰는 생성자를 뒀나 설명해둘 것)
     */
    private UtilityClass3() {
        /*
        외부에서 인스턴스 생성하는 것을 막는다.
        내부에서 생성하는 것은 가능
         */
        System.out.println("Constructor");
        throw new AssertionError();
        /*
        Exception 계열 아님
        Throwable
            Error   /   Exception
                            CheckedException / UnCheckedException
                                                    RuntimeException
         */
        /*
        Error
        예외를 처리하기 위해, try-catch를 하라고 만든 것이 아님.
        만나면 안되는 상황을 표현!
        이건 무조건 에러다. 이건 무조건 잘못된 거다!라고 에러를 던지는 것!
         */
    }

    public static String hello() {
        return "hello";
    }

    public static void main(String[] args) {
        String hello = UtilityClass3.hello();

        UtilityClass3 utilityClass = new UtilityClass3();
    }
}
