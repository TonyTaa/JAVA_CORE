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
		System.out.println("\nUSER MANAGEMENT SYSTEM");
		System.out.println("1. Create a new account");
		System.out.println("2. Login System");
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

			Account acc = new Account(username, password);
			service.addAccount(acc);

			System.out.println(">> Account created successfully.");

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

			Account acc = service.find(new Account(username, password));

			if (acc != null) {
				System.out.println(">> Login successfully");
			} else {
				System.out.println(">> Invalid user name or password");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
