package main;

import java.util.Scanner;

public class Validation {
	private static Scanner sc = new Scanner(System.in);

	/**
	 * ham validate input dang text
	 * 
	 * @return input text hop le
	 */
	public String checkValidateText() {
		while (true) {
			String input = sc.nextLine().toLowerCase().trim();
			if (input.isEmpty()) {
				System.out.println("Cannot empty");
				continue;
			}
			return input;
		}
	}

	/**
	 * ham validate input dang so
	 * 
	 * @return so nguyen hop le
	 */
	public int checkValidateNumber() {
		while (true) {
			String input = sc.nextLine().toLowerCase().trim();
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.print("Error. Re-enter: ");
			}
		}
	}

	/**
	 * ham validate input so nguyen trong khoang [min,max]
	 * 
	 * @param min gia tri nho nhat duoc chap nhan
	 * @param max gia tri lon nhat duoc chap nhan
	 * @return so nguyen hop le
	 */
	public int checkValidateNumberInRange(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Range is not available");
		}
		while (true) {
			int number = checkValidateNumber();
			if (number < min || number > max) {
				System.out.println("Value must be in range" + min + "-" + max);
			} else {
				return number;
			}
		}
	}

	/**
	 * ham validate input lua chon 1 trong 2
	 * 
	 * @param y lua chon thu nhat
	 * @param n lua chon thu hai
	 * @return lua chon hop le
	 */
	public boolean checkValidateTextOption(String y, String n) {
		while (true) {
			String input = sc.nextLine().toLowerCase().trim();
			if (input.equalsIgnoreCase(y)) {
				return true;
			}
			if (input.equalsIgnoreCase(n)) {
				return false;
			}
			System.out.println("Must choose " + y + " or " + n);
		}
	}

	/**
	 * ham validate input khoa hoc
	 * 
	 * @return khoa hoc hop le
	 */
	public String checkInputCourse() {
		while (true) {
			String result = checkValidateText();
			if (result.equalsIgnoreCase("java") || result.equalsIgnoreCase(".net")
					|| result.equalsIgnoreCase("c/c++")) {
				return result;
			}
			System.err.println("There are only three courses: Java, .Net, C/C++");
			System.out.print("Re-enter: ");
		}
	}
}
