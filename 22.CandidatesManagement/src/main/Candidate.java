package main;

import java.util.Calendar;
import java.util.regex.Pattern;

public abstract class Candidate {
    protected int id;
    protected String fname;
    protected String lname;
    protected int birthYear;
    protected String address;
    protected String phone;
    protected String email;
    protected int type;

    // ================== CONSTRUCTORS ==================
    public Candidate() {}

    public Candidate(int id, String fname, String lname, int birthYear,
                     String address, String phone, String email, int type) {
        setId(id);
        setFname(fname);
        setLname(lname);
        setBirthYear(birthYear);
        setAddress(address);
        setPhone(phone);
        setEmail(email);
        setType(type);
    }

    // ================== GETTER / SETTER ==================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be greater than 0.");
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        if (fname == null || fname.trim().isEmpty())
            throw new IllegalArgumentException("First name cannot be empty.");
        this.fname = fname.trim();
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        if (lname == null || lname.trim().isEmpty())
            throw new IllegalArgumentException("Last name cannot be empty.");
        this.lname = lname.trim();
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (birthYear < 1900 || birthYear > currentYear)
            throw new IllegalArgumentException("Birth year must be between 1900 and " + currentYear + ".");
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty())
            throw new IllegalArgumentException("Address cannot be empty.");
        this.address = address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone == null || !Pattern.matches("^0\\d{9}$", phone))
            throw new IllegalArgumentException("Phone number must start with 0 and have 10 digits.");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", email))
            throw new IllegalArgumentException("Invalid email format.");
        this.email = email.trim();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        if (type < 0)
            throw new IllegalArgumentException("Candidate type must be >= 0.");
        this.type = type;
    }

    public String getFullName() {
        return fname + " " + lname;
    }

    // Abstract method
    public abstract void showInfo();
}
