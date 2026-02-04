package main;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * validate input text khong duoc rong
	 */
	public String checkValidateText() {
		while (true) {
			String input = sc.nextLine().trim();
			if (input.isEmpty()) {
				System.out.print("Cannot empty. Re-enter: ");
				continue;
			}
			return input;
		}
	}

	/**
	 * validate so nguyen
	 */
	public int checkValidateNumber() {
		while (true) {
			String input = sc.nextLine().trim();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.print("Error. Re-enter: ");
			}
		}
	}

	/**
	 * validate so trong khoang [min, max]
	 */
	public int checkValidateNumberInRange(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Range is not available");
		}
		while (true) {
			int number = checkValidateNumber();
			if (number < min || number > max) {
				System.out.print("Value must be in range " + min + "-" + max + ". Re-enter: ");
			} else {
				return number;
			}
		}
	}

	/**
	 * validate so dien thoai (toi thieu 10 so)
	 */
	public String checkValidatePhone() {
		while (true) {
			String phone = sc.nextLine().trim();
			if (Pattern.matches("^\\d{10}$", phone)) {
				return phone;
			}
			System.out.print("Invalid phone. Re-enter: ");
		}
	}

	/**
	 * validate email
	 */
	public String checkValidateEmail() {
		while (true) {
			String email = sc.nextLine().trim();
			if (Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email)) {
				return email;
			}
			System.out.print("Invalid email. Re-enter: ");
		}
	}

	/**
	 * validate nam sinh (1900 -> hien tai)
	 */
	public int checkValidateBirthYear() {
		int current = Calendar.getInstance().get(Calendar.YEAR);
		while (true) {
			int year = checkValidateNumber();
			if (year >= 1900 && year <= current) {
				return year;
			}
			System.out.print("Year must be between 1900 and " + current + ". Re-enter: ");
		}
	}

	/**
	 * validate xep loai tot nghiep
	 */
	public String checkValidateGraduationRank() {
		while (true) {
			String rank = sc.nextLine().trim();
			if (rank.matches("(?i)Excellence|Good|Fair|Poor")) {
				return rank;
			}
			System.out.print("Rank must be Excellence, Good, Fair or Poor. Re-enter: ");
		}
	}

	/**
	 * validate type trong khoang [0,2]
	 */
	public int checkValidateType() {
		return checkValidateNumberInRange(0, 2);
	}
}
