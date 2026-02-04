package main;

public class Intern extends Candidate {
	private String major;
	private int semester;
	private String universityName;

	public Intern(int id, String fname, String lname, int birthYear, String address, String phone, String email,
			int type, String major, int semester, String universityName) {
		super(id, fname, lname, birthYear, address, phone, email, type);
		this.major = major;
		this.semester = semester;
		this.universityName = universityName;
	}

	@Override
	public void showInfo() {
		System.out.printf("Intern: %s | %d | %s | %s | %s | %s | %d | %s\n", getFullName(), birthYear, address, phone,
				email, major, semester, universityName);
	}
}