package com.du.serialnumber.service;

import java.security.SecureRandom;

public class SerialGenerator {
    private static final String CHAR_POOL = "abcdefghij0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int idx = RANDOM.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(idx));
        }
        return sb.toString();
    }

    // 간편 호출용
    public static String generate8() {
        return generate(8);
    }
}