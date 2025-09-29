package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.StudentService.ReportKey;

public class StudentController {
	private StudentService ser = new StudentService();
	private Validation val = new Validation();
	private Scanner sc = new Scanner(System.in);

	public void start() {
		while (true) {
			System.out.println("======== WELCOME TO STUDENT MANAGEMENT =======");
			System.out.println("1. Create");
			System.out.println("2. Find and Sort");
			System.out.println("3. Update/Delete");
			System.out.println("4. Report");
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
				displayStudentReport();
				break;
			case 5:
				return;
			}

		}
	}

	/**
	 * Ham nhap lieu tao sinh vien moi
	 */
	private void handleCreate() {
		while (true) {
			try {
				System.out.println("----- Create -----");
				System.out.print("Id: ");
				int id = val.checkValidateNumber();
				System.out.print("Student Name: ");
				String name = val.checkValidateText();
				System.out.print("Semester: ");
				int semester = val.checkValidateNumber();
				System.out.print("Course Name: ");
				String crs = val.checkInputCourse();

				ser.createNewStudent(id, name, semester, crs);
				System.out.println("Create successful");

				// Nếu số lượng > 5 thì hỏi tiếp tục
				if (ser.getStudentListSize() >= 5) {
					System.out.println("The student list has reached the limit of 5");
					System.out.print("Do you want to continue (Y/N)? ");
					boolean check = val.checkValidateTextOption("y", "n");
					if (!check) {
						return; // quay lại menu chính
					}
				}
				// nếu tạo thành công và không gặp lỗi thì break vòng while
				break;

			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.print("Do you want to re-enter student info? (Y/N): ");
				boolean retry = val.checkValidateTextOption("y", "n");
				if (!retry) {
					return; // quay lại menu chính
				}
			}
		}
	}

	/**
	 * Ham xu li tim va sap xep sinh vien
	 */
	private void handleFindAndSort() {
		System.out.println("-----Find and Sort-----");
		System.out.print("Name: ");
		String name = val.checkValidateText();
		List<Student> stdlist = ser.findAndSortStudentList(name);
		if (!stdlist.isEmpty()) {
			System.out.printf("%-15s%-15s%-15s\n", "StudentName", "Semester", "CourseName");
			for (Student std : stdlist) {
				System.out.printf("%-15s%-15s%-15s\n", std.getStudentName(), std.getSemester(), std.getCourseName());
			}
		} else {
			System.out.println("Not found any student name: " + name);
		}

	}

	/**
	 ** Handle the process of updating or deleting a student.
	 * 
	 * Steps:
	 * 
	 * Ask user to input student ID. Find all students with the given ID (since one
	 * ID may appear in different semesters/courses). If multiple students are
	 * found, display the list and allow user to choose one. Ask user whether to
	 * update (U) or delete (D). If update:
	 * 
	 * Allow user to enter new values for Name, Semester, Course. If input is empty,
	 * keep the old value. Validate semester (must be an integer) and course (must
	 * be Java, .Net, or C/C++).
	 *
	 * If delete:
	 * 
	 * Delete the selected student from the list.
	 */
	private void handleDeleteNUpdate() {
		while (true) {
			try {
				System.out.println("--------Update/Delete--------");
				System.out.print("Enter Student ID: ");
				int id = val.checkValidateNumber();

				List<Student> foundList = ser.findStudentById(id);
				if (foundList.isEmpty()) {
					System.out.println("No student found with ID: " + id);
					return;
				}

				// Hiển thị danh sách student
				System.out.println("Found students:");
				System.out.printf("%-5s %-15s %-10s %-10s%n", "No.", "Student", "Semester", "Course");
				for (int i = 0; i < foundList.size(); i++) {
					Student std = foundList.get(i);
					System.out.printf("%-5d %-15s %-10d %-10s%n", i + 1, std.getStudentName(), std.getSemester(),
							std.getCourseName());
				}

				// User chọn student cụ thể
				System.out.print("Choose student (1-" + foundList.size() + "): ");
				int choice = val.checkValidateNumberInRange(1, foundList.size());
				Student selectedStd = foundList.get(choice - 1);

				// Hỏi update hay delete
				System.out.println("Do you want to update (U) or delete (D) student?");
				boolean isUpdate = val.checkValidateTextOption("u", "d");

				if (isUpdate) {
					// Update
					System.out.println("-----Update-----");

					System.out.print("Enter name (leave empty to keep current): ");
					String newName = sc.nextLine().trim();
					if (newName.isEmpty()) {
						newName = selectedStd.getStudentName();
					} else {
						newName = val.checkValidateText();
					}

					System.out.print("Enter semester (leave empty to keep current): ");
					String semesterInput = sc.nextLine().trim();
					int newSemester;
					if (semesterInput.isEmpty()) {
						newSemester = selectedStd.getSemester();
					} else {
						try {
							newSemester = Integer.parseInt(semesterInput);
						} catch (NumberFormatException e) {
							System.out.print("Invalid number. Re-enter: ");
							newSemester = val.checkValidateNumber();
						}
					}

					System.out.print("Course Name (leave empty to keep current): ");
					String newCourse = sc.nextLine().trim();
					if (!newCourse.isEmpty()) {
						newCourse = val.checkInputCourse();
					} else {
						newCourse = selectedStd.getCourseName();
					}

					// Gọi service update (có check duplicate/conflict)
					ser.updateStudent(selectedStd, newName, newSemester, newCourse);
					System.out.println("Update successful!");
				} else {
					// Delete
					System.out.println("-----Delete-----");
					ser.deleteStudent(selectedStd);
					System.out.println("Delete successful!");
				}

				break; // thành công thì thoát while

			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.print("Do you want to try again? (Y/N): ");
				boolean retry = val.checkValidateTextOption("y", "n");
				if (!retry) {
					return; // quay lại menu chính
				}
			}
		}
	}

	/**
	 * Hiển thị báo cáo số lượng môn học của từng sinh viên ra console.
	 */
	public void displayStudentReport() {
		Map<ReportKey, Integer> report = ser.generateStudentReport();

		if (report.isEmpty()) {
			System.out.println("No data for report.");
			return;
		}

		System.out.printf("%-15s %-15s %-15s%n", "Student Name", "Course", "Total");

		for (Map.Entry<ReportKey, Integer> entry : report.entrySet()) {
			ReportKey key = entry.getKey();
			System.out.printf("%-15s %-15s %-15d%n", key.studentName(), key.courseName(), entry.getValue());
		}
	}
}
