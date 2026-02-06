package main;

import java.util.Scanner;

public class Controller {

    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\nBASE NUMBER CONVERTER");
            System.out.println("1. Binary (2)");
            System.out.println("2. Decimal (10)");
            System.out.println("3. Hexadecimal (16)");
            System.out.println("4. Exit");
            System.out.print("Choose input base: ");

            int inChoice = Integer.parseInt(sc.nextLine());
            if (inChoice == 4)
                return;

            int inBase = getBase(inChoice);

            System.out.print("Choose output base: ");
            int outBase = getBase(Integer.parseInt(sc.nextLine()));

            String value;
            do {
                System.out.print("Enter value: ");
                value = sc.nextLine();
            } while (!Validation.isValidNumber(value, inBase));

            // Tạo đối tượng số
            BaseNumber number = new BaseNumber(value, inBase);

            // Gọi logic của đối tượng
            String result = number.convertTo(outBase);

            System.out.println("Result: " + result);
        }
    }

    private int getBase(int choice) {
        switch (choice) {
            case 1: return 2;
            case 2: return 10;
            case 3: return 16;
            default: return 10;
        }
    }
}
