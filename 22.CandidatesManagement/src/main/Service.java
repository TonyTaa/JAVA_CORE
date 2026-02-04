package main;

import java.util.ArrayList;
import java.util.List;

public class Service {

	// Danh sách lưu trữ tất cả candidate trong hệ thống
	private final List<Candidate> list = new ArrayList<>();

	/**
	 * Sinh ID tự động cho candidate mới ID = size hiện tại + 1
	 */
	public int nextId() {
		return list.size() + 1;
	}

	/**
	 * Thêm candidate loại Experience vào danh sách
	 */
	public void addExperience(int id, String fname, String lname, int birthYear, String address, String phone,
			String email, int exp, String skill) {

		// Tạo đối tượng Experience
		Candidate c = new Experience(id, fname, lname, birthYear, address, phone, email, 0, exp, skill);

		// Thêm vào list
		list.add(c);
	}

	/**
	 * Thêm candidate loại Fresher vào danh sách
	 */
	public void addFresher(int id, String fname, String lname, int birthYear, String address, String phone,
			String email, int graduationYear, String rank, String edu) {

		// Tạo đối tượng Fresher
		Candidate c = new Fresher(id, fname, lname, birthYear, address, phone, email, 1, graduationYear, rank, edu);

		// Thêm vào list
		list.add(c);
	}

	/**
	 * Thêm candidate loại Intern vào danh sách
	 */
	public void addIntern(int id, String fname, String lname, int birthYear, String address, String phone, String email,
			String major, int semester, String university) {

		// Tạo đối tượng Intern
		Candidate c = new Intern(id, fname, lname, birthYear, address, phone, email, 2, major, semester, university);

		// Thêm vào list
		list.add(c);
	}

	/**
	 * Hiển thị toàn bộ danh sách candidate
	 */
	public void showAllCandidates() {

		if (list.isEmpty()) {
			System.out.println("No candidates available.");
			return;
		}

		showByType(0, "===========EXPERIENCE CANDIDATE============");
		showByType(1, "==========FRESHER CANDIDATE==============");
		showByType(2, "===========INTERN CANDIDATE==============");
	}

	private void showByType(int type, String title) {
		System.out.println(title);
		for (Candidate c : list) {
			if (c.getType() == type) {
				System.out.println(c.getFullName());
			}
		}
	}

	/**
	 * Tìm kiếm candidate theo: - Từ khóa trong tên - Loại candidate (type)
	 */
	public void searchCandidate(String keyword, int type) {
		boolean found = false;

		System.out.println("\nThe candidates found:");

		// Duyệt danh sách và tìm candidate phù hợp
		for (Candidate c : list) {
			if (c.getType() == type && c.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
				c.showInfo();
				found = true;
			}
		}

		// Nếu không tìm thấy
		if (!found) {
			System.out.println("No candidates found!");
		}
	}
}
