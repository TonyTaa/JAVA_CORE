package main;

import java.util.Random;
import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidAccountNumber(String acc) {
        return acc != null && Pattern.matches("\\d{10}", acc);
    }

    public static boolean isValidPassword(String pass) {
        return pass != null && Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", pass);
    }

    public static String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();

        for (int i = 0; i < 5; i++) {
            sb.append(chars.charAt(rd.nextInt(chars.length())));
        }
        return sb.toString();
    }

    public static boolean isValidCaptcha(String input, String captcha) {
        return captcha.contains(input);
    }
}
