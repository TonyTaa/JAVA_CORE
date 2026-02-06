package main;

import java.util.Date;

public class Account {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Date dob;

    public Account(String username, String password, String name,
                   String phone, String email, String address, Date dob) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getName() { return name; }
}
