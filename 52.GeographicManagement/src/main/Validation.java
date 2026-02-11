package main;

import java.util.Scanner;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public String checkValidateText() {
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.print("Cannot empty. Re-enter: ");
            } else {
                return input;
            }
        }
    }

    public float checkValidateArea() {
        while (true) {
            try {
                float area = Float.parseFloat(sc.nextLine());
                if (area > 0) {
                    return area;
                }
                System.out.print("Area must be > 0. Re-enter: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Re-enter: ");
            }
        }
    }

    public int checkValidateNumberInRange(int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.print("Value must be in range "
                        + min + "-" + max + ". Re-enter: ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Re-enter: ");
            }
        }
    }
}
