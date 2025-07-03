package javatest;

import java.nio.ByteBuffer;
import java.util.*;

public class TestJava {

    public static String toBase64(String uuidStr) {
        UUID uuid = UUID.fromString(uuidStr);             // Step 1
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.putLong(uuid.getMostSignificantBits());       // Step 2 & 3 (MSB)
        buf.putLong(uuid.getLeastSignificantBits());      // Step 2 & 3 (LSB)
        byte[] bytes = buf.array();                       // 16‑byte array
        return Base64.getEncoder().encodeToString(bytes); // Step 4
    }

    // quick demo
    public static void main(String[] args) {
        String uuid = "518458a8-3607-438a-af60-7ee8b40b8bfe";
        System.out.println(toBase64(uuid)); // -> FC8IpWNRIUeGTJ7K6yFjpw==
    }
}
