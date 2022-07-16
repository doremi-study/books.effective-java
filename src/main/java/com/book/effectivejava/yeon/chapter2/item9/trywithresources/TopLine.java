package com.book.effectivejava.yeon.chapter2.item9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    //  코드 9-3 try-with-resource - 자원을 회수하는 최선책 (48쪽)
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path));) {
            return br.readLine();
        }
        //  close를 직접하지 않는다.
        //  <- 이를 가능하게 해주는 것이 BufferedReader의 상위 클래스인 Reader가 구현하고 있는 Closable 클래스 !
        //  Closable은 곧 AutoClosable
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
