package main;

public class Validation {

    public static boolean isValidBase(int base) {
        return base == 2 || base == 10 || base == 16;
    }

    public static boolean isValidNumber(String value, int base) {
        value = value.toUpperCase();

        for (char c : value.toCharArray()) {
            if (base == 2 && (c != '0' && c != '1'))
                return false;

            if (base == 10 && !Character.isDigit(c))
                return false;

            if (base == 16 &&
                    !(Character.isDigit(c) || (c >= 'A' && c <= 'F')))
                return false;
        }
        return true;
    }
}
