package main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Controller {
	private Service ser = new Service();
	private Validation val = new Validation();
	private Scanner sc = new Scanner(System.in);

	public void start() {
		while (true) {
			System.out.println("======== EMPLOYEE MANAGEMENT SYSTEM =======");
			System.out.println("1. Create Employee");
			System.out.println("2. Find and Sort");
			System.out.println("3. Update/Delete");
			System.out.println("4. Display All");
			System.out.println("5. Exit");
			System.out.print("Select your choice: ");
			int choice = val.checkValidateNumberInRange(1, 5);

			switch (choice) {
			case 1:
				handleCreate();
				break;
			case 2:
				handleFindAndSort();
				break;
			case 3:
				handleDeleteNUpdate();
				break;
			case 4:
				displayAllEmployees();
				break;
			case 5:
				return;
			}
		}
	}

	private void handleCreate() {
		while (true) {
			try {
				System.out.println("----- Create Employee -----");
				System.out.print("ID: ");
				int id = val.checkValidateNumber();

				System.out.print("First name: ");
				String firstName = val.checkValidateText();

				System.out.print("Last name: ");
				String lastName = val.checkValidateText();

				System.out.print("Phone (10 digits, start with 0): ");
				String phone = val.checkValidatePhoneNumber();

				System.out.print("Email: ");
				String email = val.checkValidateEmail();

				System.out.print("Address: ");
				String address = val.checkValidateText();

				System.out.print("Date of Birth (dd/MM/yyyy): ");
				LocalDate localDob = val.checkValidateDOB();
				Date dob = Date.from(localDob.atStartOfDay(ZoneId.systemDefault()).toInstant());

				System.out.print("Sex (M/F): ");
				boolean sex = val.checkValidateTextOption("m", "f");

				System.out.print("Salary: ");
				double salary = val.checkValidateSalary();

				System.out.print("Agency: ");
				String agency = val.checkValidateText();

				Employee emp = new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
				ser.addEmployee(emp);
				System.out.println("Employee added successfully!");
				break;

			} catch (RuntimeException e) {
				System.err.println(e.getMessage());
				System.out.println("Re-enter employee infor: ");
			}
		}
	}

	private void handleFindAndSort() {
		System.out.println("----- Find and Sort -----");
		System.out.println("1. Search by name");
		System.out.println("2. Sort by name (A-Z)");
		System.out.println("3. Sort by salary (High → Low)");
		System.out.print("Choose option: ");
		int option = val.checkValidateNumberInRange(1, 3);

		List<Employee> list = new ArrayList<>();

		switch (option) {
		case 1:
			System.out.print("Enter name keyword: ");
			String keyword = sc.nextLine().trim();
			list = ser.searchEmployeesByName(keyword);
			break;
		case 2:
			list = ser.sortEmployeesByName();
			break;
		case 3:
			list = ser.sortEmployeesBySalaryDesc();
			break;
		}

		if (list.isEmpty()) {
			System.out.println("No matching employees found.");
			return;
		}

		displayEmployeeList(list);
	}

	private void handleDeleteNUpdate() {
		while (true) {
			try {
				System.out.println("----- Update/Delete Employee -----");
				System.out.print("Enter Employee ID: ");
				int id = val.checkValidateNumber();

				Employee emp = ser.findEmployeeByIdSingle(id);
				if (emp == null) {
					System.out.println("Employee not found.");
					return;
				}

				System.out.println("Employee found: " + emp.getFirstName() + " " + emp.getLastName());
				System.out.print("Do you want to update (U) or delete (D)? ");
				String option = sc.nextLine().trim().toLowerCase();

				if (option.equals("u")) {
					System.out.println("----- Update Employee -----");

					System.out.print("First name (leave blank to keep current): ");
					String fn = sc.nextLine().trim();

					System.out.print("Last name (leave blank to keep current): ");
					String ln = sc.nextLine().trim();

					System.out.print("Phone (leave blank to keep current): ");
					String ph = sc.nextLine().trim();

					System.out.print("Email (leave blank to keep current): ");
					String em = sc.nextLine().trim();

					System.out.print("Address (leave blank to keep current): ");
					String addr = sc.nextLine().trim();

					System.out.print("Date of Birth (dd/MM/yyyy) (leave blank to keep current): ");
					String dobStr = sc.nextLine().trim();
					Date dob = null;
					if (!dobStr.isEmpty()) {
						try {
							LocalDate localDob = val.checkValidateDOB();
							dob = Date.from(localDob.atStartOfDay(ZoneId.systemDefault()).toInstant());
						} catch (Exception e) {
							System.out.println("Invalid date format, ignored.");
						}
					}

					System.out.print("Sex (M/F) (leave blank to keep current): ");
					String sexStr = sc.nextLine().trim();
					Boolean sex = null;
					if (!sexStr.isEmpty()) {
						sex = sexStr.equalsIgnoreCase("m");
					}

					System.out.print("Salary (leave blank to keep current): ");
					String salStr = sc.nextLine().trim();
					Double salary = null;
					if (!salStr.isEmpty()) {
						try {
							salary = Double.parseDouble(salStr);
						} catch (NumberFormatException e) {
							System.out.println("Invalid number, ignored.");
						}
					}

					System.out.print("Agency (leave blank to keep current): ");
					String agency = sc.nextLine().trim();

					ser.updateEmployee(id, fn, ln, ph, em, addr, dob, sex, salary, agency);
					System.out.println("Update successful!");
				} else if (option.equals("d")) {
					ser.removeEmployee(id);
					System.out.println("Delete successful!");
				} else {
					System.out.println("Invalid choice.");
				}
				break;
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.print("Try again? (Y/N): ");
				String retry = sc.nextLine().trim().toLowerCase();
				if (!retry.equals("y"))
					return;
			}
		}
	}

	private void displayAllEmployees() {
		List<Employee> list = ser.getAllEmployees();
		if (list.isEmpty()) {
			System.out.println("No employees in the system.");
			return;
		}
		displayEmployeeList(list);
	}

	private void displayEmployeeList(List<Employee> list) {
		System.out.printf("%-5s %-10s %-10s %-12s %-20s %-8s %-10s %-12s %-15s%n", "ID", "FirstName", "LastName",
				"Phone", "Email", "Sex", "Salary", "Agency", "DOB");
		for (Employee e : list) {
			String dobStr = e.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
			System.out.printf("%-5d %-10s %-10s %-12s %-20s %-8s %-10.2f %-12s %-15s%n", e.getId(), e.getFirstName(),
					e.getLastName(), e.getPhone(), e.getEmail(), e.isSex() ? "Male" : "Female", e.getSalary(),
					e.getAgency(), dobStr);
		}
	}

}
