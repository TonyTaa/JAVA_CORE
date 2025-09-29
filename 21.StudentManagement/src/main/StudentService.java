package main;

import java.util.*;

public class StudentService {
    private List<Student> stdList = new ArrayList<>();

    // ====== VALIDATION ======
    private boolean isExactDuplicate(Student newStd) {
        for (Student s : stdList) {
            if (s.getId() == newStd.getId()
                && s.getStudentName().equalsIgnoreCase(newStd.getStudentName())
                && s.getSemester() == newStd.getSemester()
                && s.getCourseName().equalsIgnoreCase(newStd.getCourseName())) {
                return true;
            }
        }
        return false;
    }

    private void validateIdNameConflict(Student newStd) {
        for (Student s : stdList) {
            if (s.getId() == newStd.getId()
                && !s.getStudentName().equalsIgnoreCase(newStd.getStudentName())) {
                throw new RuntimeException("Conflict: same ID but different name!");
            }
        }
    }

    // ====== CREATE ======
    public boolean createNewStudent(int id, String stdname, int semester, String crsname) {
        Student newstd = new Student(id, stdname, semester, crsname);

        validateIdNameConflict(newstd);
        if (isExactDuplicate(newstd)) {
            throw new RuntimeException("This student record already exists!");
        }

        stdList.add(newstd);
        return true;
    }

    // ====== FIND & SORT ======
    public List<Student> findAndSortStudentList(String name) {
        List<Student> selectedList = new ArrayList<>();
        for (Student std : stdList) {
            if (std.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                selectedList.add(std);
            }
        }
        selectedList.sort(Comparator.comparing(Student::getStudentName, String.CASE_INSENSITIVE_ORDER));
        return selectedList;
    }

    // ====== FIND BY ID ======
    public List<Student> findStudentById(int id) {
        List<Student> foundList = new ArrayList<>();
        for (Student std : stdList) {
            if (std.getId() == id) {
                foundList.add(std);
            }
        }
        return foundList;
    }

    // ====== DELETE ======
    public void deleteStudent(Student std) {
        stdList.remove(std);
    }

    // ====== UPDATE ======
    public void updateStudent(Student target, String name, Integer semester, String crs) {
        Student updated = new Student(
                target.getId(),
                name != null && !name.trim().isEmpty() ? name : target.getStudentName(),
                semester != null ? semester : target.getSemester(),
                crs != null && !crs.trim().isEmpty() ? crs : target.getCourseName()
        );

        validateIdNameConflict(updated);
        if (isExactDuplicate(updated)) {
            throw new RuntimeException("Update failed: record already exists!");
        }

        target.setStudentName(updated.getStudentName());
        target.setSemester(updated.getSemester());
        target.setCourseName(updated.getCourseName());
    }

    // ====== UTILS ======
    public int getStudentListSize() {
        return stdList.size();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(stdList);
    }

    // ====== REPORT ======
    public record ReportKey(int id, String studentName, String courseName) {}

    public Map<ReportKey, Integer> generateStudentReport() {
        Map<ReportKey, Integer> reportMap = new HashMap<>();
        for (Student s : stdList) {
            ReportKey key = new ReportKey(s.getId(), s.getStudentName(), s.getCourseName());
            reportMap.put(key, reportMap.getOrDefault(key, 0) + 1);
        }
        return reportMap;
    }
}
