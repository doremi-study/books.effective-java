package com.book.effectivejava.yeon.chapter2.item9.suppress;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BadBufferedReader(new FileReader(path));
        try {
            return br.readLine();//CharConversionException 발생
        } finally {
            br.close();//StreamCorruptedException 발생
        }

        //TODO 둘 중에 어떤 Exception이 발생할까?
    }

    static String firstLineOfFile2(String path) throws IOException {
        try (BufferedReader br = new BadBufferedReader(new FileReader(path));) {
            return br.readLine();
        }
        /*
        예외 하나가 먹히지 않고 전부 나온다.
        순서대로.
        이게 try-with-resource의 장점!
         */
    }

    public static void main(String[] args) throws IOException {
        System.out.println(firstLineOfFile("build.gradle"));

        //StreamCorruptedException만 보인다. 가장 나중에 발생한 예외니까.

        /*디버깅을 하다보면 가장 처음에 발생한 예외가 중요할 수 있다.
        연쇄작용이 일어나서 예외가 타고타고 발생할 수 있으니까.*/
        System.out.println("\n");

        System.out.println(firstLineOfFile2("build.gradle"));
    }
}
