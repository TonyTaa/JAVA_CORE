package main;

public class Fresher extends Candidate {
	private int graduationDate;
	private String graduationRank;
	private String education;

	public Fresher(int id, String fname, String lname, int birthYear, String address, String phone, String email,
			int type, int graduationDate, String graduationRank, String education) {
		super(id, fname, lname, birthYear, address, phone, email, type);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	@Override
	public void showInfo() {
		System.out.printf("Fresher: %s | %d | %s | %s | %s | %d | %s | %s\n", getFullName(), birthYear, address, phone,
				email, graduationDate, graduationRank, education);
	}
}