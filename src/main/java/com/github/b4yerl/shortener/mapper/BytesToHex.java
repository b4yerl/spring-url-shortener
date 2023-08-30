package com.github.b4yerl.shortener.mapper;

public class BytesToHex {
    public static String convert(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for(byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
