package main;

public class Student {
	private int id;
	private String studentName;
	private int semester;
	private String courseName;

	public Student() {
	}

	public Student(int id, String studentName, int semester, String courseName) {
		setId(id);
		setStudentName(studentName);
		setSemester(semester);
		setCourseName(courseName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID phải > 0");
		}
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		if (studentName == null || studentName.trim().isEmpty()) {
			throw new IllegalArgumentException("Tên sinh viên không được để trống");
		}
		this.studentName = studentName.trim();
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		if (semester < 1 || semester > 10) { // giới hạn ví dụ: từ 1-10
			throw new IllegalArgumentException("Semester phải từ 1 đến 10");
		}
		this.semester = semester;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		if (courseName == null || courseName.trim().isEmpty()) {
			throw new IllegalArgumentException("Tên khóa học không được để trống");
		}
		this.courseName = courseName.trim();
	}
}
