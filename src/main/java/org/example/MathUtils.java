package org.example;

import java.nio.file.Path;

public class MathUtils {
    public static int max(int a, int b) {
        if (a >= b) return a;
        return b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider must not be zero");
        }
        return a / b;
    }

    public static String getFilePath(String folder, String fileName) {
        //Sử dụng Path.of để tự động chọn dấu gạch chéo đúng theo OS
        return Path.of(folder, fileName).toString();
    }
}


