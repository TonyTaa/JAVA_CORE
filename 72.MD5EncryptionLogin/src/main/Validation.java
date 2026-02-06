package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    /**
     * validate text khong duoc rong
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
     * validate username (khong rong)
     */
    public String checkValidateUsername() {
        while (true) {
            String username = sc.nextLine().trim();
            if (username.isEmpty()) {
                System.out.print("Username cannot be empty. Re-enter: ");
                continue;
            }
            return username;
        }
    }

    /**
     * validate password (khong rong)
     */
    public String checkValidatePassword() {
        while (true) {
            String password = sc.nextLine().trim();
            if (password.isEmpty()) {
                System.out.print("Password cannot be empty. Re-enter: ");
                continue;
            }
            return password;
        }
    }

    /**
     * validate so dien thoai (10 hoac 11 so)
     */
    public String checkValidatePhone() {
        while (true) {
            String phone = sc.nextLine().trim();
            if (Pattern.matches("^\\d{10,11}$", phone)) {
                return phone;
            }
            System.out.print("Phone must be 10 or 11 digits. Re-enter: ");
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
     * validate ngay sinh dd/MM/yyyy
     */
    public String checkValidateDOB() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        while (true) {
            String dob = sc.nextLine().trim();
            try {
                sdf.parse(dob);
                return dob;
            } catch (ParseException e) {
                System.out.print("Invalid date (dd/MM/yyyy). Re-enter: ");
            }
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
}
