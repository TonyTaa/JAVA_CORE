package main;

import java.util.*;
import java.util.stream.Collectors;

public class Service {
    private List<Employee> empList = new ArrayList<>();

    // ====== VALIDATION ======
    private void validateDuplicateId(Employee newEmp) {
        for (Employee e : empList) {
            if (e.getId() == newEmp.getId()) {
                throw new RuntimeException("Duplicate ID: Employee with ID " + e.getId() + " already exists!");
            }
        }
    }

    // ====== CREATE ======
    public boolean addEmployee(Employee emp) {
        validateDuplicateId(emp);
        empList.add(emp);
        return true;
    }

    // ====== UPDATE ======
    public void updateEmployee(int id, String firstName, String lastName, String phone, String email,
                               String address, Date dob, Boolean sex, Double salary, String agency) {
        Employee target = findEmployeeByIdSingle(id);
        if (target == null) {
            throw new RuntimeException("Employee with ID " + id + " not found!");
        }

        // Tạo đối tượng tạm để kiểm tra trùng ID nếu cần
        Employee updated = new Employee(
                target.getId(),
                firstName != null && !firstName.trim().isEmpty() ? firstName : target.getFirstName(),
                lastName != null && !lastName.trim().isEmpty() ? lastName : target.getLastName(),
                phone != null && !phone.trim().isEmpty() ? phone : target.getPhone(),
                email != null && !email.trim().isEmpty() ? email : target.getEmail(),
                address != null && !address.trim().isEmpty() ? address : target.getAddress(),
                dob != null ? dob : target.getDob(),
                sex != null ? sex : target.isSex(),
                salary != null ? salary : target.getSalary(),
                agency != null && !agency.trim().isEmpty() ? agency : target.getAgency()
        );

        // Cập nhật thông tin
        target.setFirstName(updated.getFirstName());
        target.setLastName(updated.getLastName());
        target.setPhone(updated.getPhone());
        target.setEmail(updated.getEmail());
        target.setAddress(updated.getAddress());
        target.setDob(updated.getDob());
        target.setSex(updated.isSex());
        target.setSalary(updated.getSalary());
        target.setAgency(updated.getAgency());
    }

    // ====== REMOVE ======
    public void removeEmployee(int id) {
        Employee target = findEmployeeByIdSingle(id);
        if (target == null) {
            throw new RuntimeException("Cannot remove: Employee with ID " + id + " not found!");
        }
        empList.remove(target);
    }

    // ====== FIND BY ID ======
    public Employee findEmployeeByIdSingle(int id) {
        for (Employee e : empList) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public List<Employee> findEmployeeById(int id) {
        return empList.stream()
                .filter(e -> e.getId() == id)
                .collect(Collectors.toList());
    }

    // ====== SEARCH BY NAME ======
    public List<Employee> searchEmployeesByName(String keyword) {
        return empList.stream()
                .filter(e -> (e.getFirstName() + " " + e.getLastName())
                        .toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // ====== SORT ======
    public List<Employee> sortEmployeesByName() {
        return empList.stream()
                .sorted(Comparator.comparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    public List<Employee> sortEmployeesBySalaryDesc() {
        return empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    // ====== UTILS ======
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(empList);
    }

    public int getEmployeeCount() {
        return empList.size();
    }
}
