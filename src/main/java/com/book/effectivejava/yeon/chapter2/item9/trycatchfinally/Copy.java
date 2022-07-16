package com.book.effectivejava.yeon.chapter2.item9.trycatchfinally;

import java.io.*;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);//반환해야 할 자원1

        try {
            OutputStream out = new FileOutputStream(dst);//반환해야 할 자원2
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();//자원2 닫다가 에러가 발생해도 자원1 닫는 시도할 것이다.
            }
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
