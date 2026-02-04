package main;

public class Controller {

	private final Service service = new Service();
	private final Validation validation = new Validation();

	public void run() {
		while (true) {
			System.out.println("\n===== CANDIDATE MANAGEMENT SYSTEM =====");
			System.out.println("1. Experience");
			System.out.println("2. Fresher");
			System.out.println("3. Internship");
			System.out.println("4. Searching");
			System.out.println("5. Exit");
			System.out.print("Please choose: ");

			int choice = validation.checkValidateNumberInRange(1, 5);

			switch (choice) {
			case 1:
				createExperience();
				break;
			case 2:
				createFresher();
				break;
			case 3:
				createIntern();
				break;
			case 4:
				searchCandidate();
				break;
			case 5:
				System.out.println("Exit program.");
				return;
			}
		}
	}

	/**
	 * Tạo candidate loại Experience
	 */
	private void createExperience() {
		System.out.println("===== Create Experience Candidate =====");

		int id = service.nextId();

		System.out.print("First name: ");
		String fname = validation.checkValidateText();

		System.out.print("Last name: ");
		String lname = validation.checkValidateText();

		System.out.print("Birth year (1900-current): ");
		int year = validation.checkValidateBirthYear();

		System.out.print("Address: ");
		String address = validation.checkValidateText();

		System.out.print("Phone: ");
		String phone = validation.checkValidatePhone();

		System.out.print("Email: ");
		String email = validation.checkValidateEmail();

		System.out.print("Years of experience (0-100): ");
		int exp = validation.checkValidateNumberInRange(0, 100);

		System.out.print("Professional skill: ");
		String skill = validation.checkValidateText();

		service.addExperience(id, fname, lname, year, address, phone, email, exp, skill);
		System.out.println("Experience candidate added successfully!");
	}

	/**
	 * Tạo candidate loại Fresher
	 */
	private void createFresher() {
		System.out.println("===== Create Fresher Candidate =====");

		int id = service.nextId();

		System.out.print("First name: ");
		String fname = validation.checkValidateText();

		System.out.print("Last name: ");
		String lname = validation.checkValidateText();

		System.out.print("Birth year (1900-current): ");
		int year = validation.checkValidateBirthYear();

		System.out.print("Address: ");
		String address = validation.checkValidateText();

		System.out.print("Phone: ");
		String phone = validation.checkValidatePhone();

		System.out.print("Email: ");
		String email = validation.checkValidateEmail();

		System.out.print("Graduation year (1900-current): ");
		int gradYear = validation.checkValidateBirthYear();

		System.out.print("Graduation rank (Excellence/Good/Fair/Poor): ");
		String rank = validation.checkValidateGraduationRank();

		System.out.print("University: ");
		String edu = validation.checkValidateText();

		service.addFresher(id, fname, lname, year, address, phone, email, gradYear, rank, edu);
		System.out.println("Fresher candidate added successfully!");
	}

	/**
	 * Tạo candidate loại Intern
	 */
	private void createIntern() {
		System.out.println("===== Create Intern Candidate =====");

		int id = service.nextId();

		System.out.print("First name: ");
		String fname = validation.checkValidateText();

		System.out.print("Last name: ");
		String lname = validation.checkValidateText();

		System.out.print("Birth year (1900-current): ");
		int year = validation.checkValidateBirthYear();

		System.out.print("Address: ");
		String address = validation.checkValidateText();

		System.out.print("Phone: ");
		String phone = validation.checkValidatePhone();

		System.out.print("Email: ");
		String email = validation.checkValidateEmail();

		System.out.print("Major: ");
		String major = validation.checkValidateText();

		System.out.print("Semester (1-9): ");
		int semester = validation.checkValidateNumberInRange(1, 9);

		System.out.print("University: ");
		String university = validation.checkValidateText();

		service.addIntern(id, fname, lname, year, address, phone, email, major, semester, university);
		System.out.println("Intern candidate added successfully!");
	}

	/**
	 * Tìm kiếm candidate
	 */
	private void searchCandidate() {
		service.showAllCandidates();

		System.out.print("\nEnter name to search: ");
		String keyword = validation.checkValidateText();

		System.out.print("Enter candidate type (0-Experience, 1-Fresher, 2-Intern): ");
		int type = validation.checkValidateType();

		service.searchCandidate(keyword, type);
	}
}
