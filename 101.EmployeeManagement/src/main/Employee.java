package main;

import java.util.Date;
import java.util.regex.Pattern;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private Date dob;
	private boolean sex;
	private double salary;
	private String agency;

	private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	private static final Pattern PHONE_REGEX = Pattern.compile("^0\\d{9,10}$");

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String phone, String email, String address, Date dob,
			boolean sex, double salary, String agency) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setEmail(email);
		setAddress(address);
		setDob(dob);
		setSex(sex);
		setSalary(salary);
		setAgency(agency);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("ID must be positive");
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty())
			throw new IllegalArgumentException("First name cannot be empty");
		this.firstName = firstName.trim();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.trim().isEmpty())
			throw new IllegalArgumentException("Last name cannot be empty");
		this.lastName = lastName.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone == null || !PHONE_REGEX.matcher(phone).matches())
			throw new IllegalArgumentException("Invalid phone number (must start with 0 and contain 10–11 digits)");
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || !EMAIL_REGEX.matcher(email).matches())
			throw new IllegalArgumentException("Invalid email format");
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.trim().isEmpty())
			throw new IllegalArgumentException("Address cannot be empty");
		this.address = address.trim();
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		if (dob == null)
			throw new IllegalArgumentException("Date of birth cannot be null");
		if (dob.after(new Date()))
			throw new IllegalArgumentException("Date of birth cannot be in the future");
		this.dob = dob;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex; // true = male, false = female (có thể dùng enum sau)
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary < 0)
			throw new IllegalArgumentException("Salary must be non-negative");
		this.salary = salary;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		if (agency == null || agency.trim().isEmpty())
			throw new IllegalArgumentException("Agency cannot be empty");
		this.agency = agency.trim();
	}

	@Override
	public String toString() {
		return String.format("%-5d %-10s %-10s %-12s %-20s %-20s %-10s %-6s %-10.2f %-10s", id, firstName, lastName,
				phone, email, address, dob, (sex ? "Male" : "Female"), salary, agency);
	}
}
