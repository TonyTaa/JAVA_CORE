package main;

import java.security.MessageDigest;

public class MD5Util {

    public static String encrypt(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
