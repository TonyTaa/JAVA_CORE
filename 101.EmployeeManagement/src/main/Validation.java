package main;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
	private static Scanner sc = new Scanner(System.in);
	private static final String PHONE_REGEX = "^(0\\d{9})$";
	private static final String EMAIL_REGEX = "^[a-z0-9]+@[a-z0-9.-]+\\.[a-z]{2,}$";

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
	 * Ham validate phone number input
	 * 
	 * @return
	 */
	public String checkValidatePhoneNumber() {
		while (true) {
			String phone = sc.nextLine().trim();
			if (phone.isEmpty()) {
				System.out.println("Không được để trống");
				continue;
			}
			if (!Pattern.matches(PHONE_REGEX, phone)) {
				System.out.println("Sai định dạng (phải có 10 số và bắt đầu bằng 0)");
				continue;
			}
			return phone; // ✅ trả về chuỗi hợp lệ
		}
	}

	/**
	 * Ham validate email input
	 * 
	 * @return
	 */

	public String checkValidateEmail() {
		while (true) {
			String email = sc.nextLine().trim();
			if (email.isEmpty()) {
				System.out.println("Không được để trống");
				continue;
			}
			if (!Pattern.matches(EMAIL_REGEX, email)) {
				System.out.println("Sai định dạng email");
				continue;
			}
			return email; // ✅ trả về chuỗi hợp lệ
		}
	}

	/**
	 * ham validate dob input
	 * 
	 * @return
	 */
	public LocalDate checkValidateDOB() {
		while (true) {
			String dob = sc.nextLine().trim();
			if (dob == null || dob.isEmpty()) {
				System.out.println("Khong duoc trong");
				continue;
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
					.withResolverStyle(ResolverStyle.STRICT);

			try {
				LocalDate date = LocalDate.parse(dob, formatter);
				if (date.isAfter(LocalDate.now())) {
					System.out.println("Khong the lon hon hom nay");
					continue;
				}
				return date;
			} catch (DateTimeException e) {
				System.out.println("Sai dinh dang");
			}
		}
	}

	/**
	 * Ham validate luong nhan vien
	 * 
	 * @return salary hop le (double > 0)
	 */
	public double checkValidateSalary() {
		while (true) {
			String input = sc.nextLine().trim();
			if (input.isEmpty()) {
				System.out.print("Khong duoc de trong. Nhap lai: ");
				continue;
			}

			try {
				double salary = Double.parseDouble(input);
				if (salary <= 0) {
					System.out.print("Luong phai lon hon 0. Nhap lai: ");
					continue;
				}
				return salary;
			} catch (NumberFormatException e) {
				System.out.print("Sai dinh dang so. Nhap lai: ");
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
}
