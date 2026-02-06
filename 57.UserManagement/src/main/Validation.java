package main;

import java.util.Scanner;

public class Validation {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * validate username: >=5 ký tự, không có space
	 */
	public String checkValidateUsername() {
		while (true) {
			String username = sc.nextLine().trim();
			if (username.length() >= 5 && !username.contains(" ")) {
				return username;
			}
			System.out.print("Username must be >=5 characters, no spaces. Re-enter: ");
		}
	}

	/**
	 * validate password: >=6 ký tự, không có space
	 */
	public String checkValidatePassword() {
		while (true) {
			String password = sc.nextLine().trim();
			if (password.length() >= 6 && !password.contains(" ")) {
				return password;
			}
			System.out.print("Password must be >=6 characters, no spaces. Re-enter: ");
		}
	}

	/**
	 * validate số menu
	 */
	public int checkValidateNumberInRange(int min, int max) {
		while (true) {
			try {
				int number = Integer.parseInt(sc.nextLine());
				if (number >= min && number <= max) {
					return number;
				}
			} catch (Exception e) {
			}
			System.out.print("Choose in range " + min + "-" + max + ": ");
		}
	}
}
