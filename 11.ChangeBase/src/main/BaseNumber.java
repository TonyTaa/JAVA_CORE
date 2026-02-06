package main;

public class BaseNumber {

    private String value;
    private int base;

    public BaseNumber(String value, int base) {
        this.value = value.toUpperCase();
        this.base = base;
    }

    // chuyển sang decimal
    private int toDecimal() {
        int result = 0;

        for (char c : value.toCharArray()) {
            int digit;
            if (Character.isDigit(c))
                digit = c - '0';
            else
                digit = c - 'A' + 10;

            result = result * base + digit;
        }
        return result;
    }

    // chuyển từ decimal sang base khác
    private String fromDecimal(int decimal, int newBase) {
        if (decimal == 0)
            return "0";

        String result = "";
        while (decimal > 0) {
            int r = decimal % newBase;
            char c = (r < 10) ? (char) ('0' + r) : (char) ('A' + r - 10);
            result = c + result;
            decimal /= newBase;
        }
        return result;
    }

    // phương thức public để convert
    public String convertTo(int newBase) {
        int decimal = toDecimal();
        return fromDecimal(decimal, newBase);
    }
}
