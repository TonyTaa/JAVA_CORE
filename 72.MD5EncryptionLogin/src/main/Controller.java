package main;

public class Controller {

	private final Service service = new Service();
	private final Validation validation = new Validation();

	public void run() {
		while (true) {
			int choice = menu();

			switch (choice) {
			case 1:
				addAccount();
				break;
			case 2:
				login();
				break;
			case 3:
				System.out.println("Exit program.");
				return;
			}
		}
	}

	private int menu() {
		System.out.println("\n===== ACCOUNT SYSTEM =====");
		System.out.println("1. Add account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.print("Choose: ");
		return validation.checkValidateNumberInRange(1, 3);
	}

	// ================= ADD ACCOUNT =================
	private void addAccount() {
		try {
			System.out.print("Username: ");
			String username = validation.checkValidateUsername();

			System.out.print("Password: ");
			String password = validation.checkValidatePassword();

			System.out.print("Name: ");
			String name = validation.checkValidateText();

			System.out.print("Phone: ");
			String phone = validation.checkValidatePhone();

			System.out.print("Email: ");
			String email = validation.checkValidateEmail();

			System.out.print("Address: ");
			String address = validation.checkValidateText();

			System.out.print("DOB (dd/MM/yyyy): ");
			String dob = validation.checkValidateDOB();

			int id = service.addAccount(username, password, name, phone, email, address, dob);

			System.out.println(">> Add account successfully. ID = " + id);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	// ================= LOGIN =================
	private void login() {
		try {
			System.out.print("Username: ");
			String username = validation.checkValidateUsername();

			System.out.print("Password: ");
			String password = validation.checkValidatePassword();

			boolean result = service.login(username, password);

			if (result) {
				System.out.println(">> Hello " + username);
			} else {
				System.out.println(">> Login failed");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
