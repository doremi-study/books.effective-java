package com.book.effectivejava.yeon.chapter2.item9.trycatchfinally;

import java.io.*;

public class CopyDanger {
    private static final int BUFFER_SIZE = 8 * 1024;

    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);//반환해야 할 자원1
        OutputStream out = new FileOutputStream(dst);//반환해야 할 자원2

        try {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }

        } finally {
            in.close();//자원1 반납하다 오류 발생할 경우 자원2 반납 안될 수 있음
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String src = args[0];
        String dst = args[1];
        copy(src, dst);
    }
}
