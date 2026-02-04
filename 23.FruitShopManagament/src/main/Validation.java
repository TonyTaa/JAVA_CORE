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

	public int checkValidateNumber() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.print("Invalid number. Re-enter: ");
			}
		}
	}

	public int checkValidateNumberInRange(int min, int max) {
		while (true) {
			int num = checkValidateNumber();
			if (num >= min && num <= max)
				return num;
			System.out.print("Value must be between " + min + " and " + max + ": ");
		}
	}

	public double checkValidateDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.print("Invalid number. Re-enter: ");
			}
		}
	}

	public boolean checkYesNo() {
		while (true) {
			String input = sc.nextLine().trim();
			if (input.equalsIgnoreCase("y"))
				return true;
			if (input.equalsIgnoreCase("n"))
				return false;
			System.out.print("Must be Y or N: ");
		}
	}
}
