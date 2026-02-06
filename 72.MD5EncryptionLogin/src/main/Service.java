package main;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {

    private final List<Account> accounts = new ArrayList<>();

    public int addAccount(String username, String password,
                          String name, String phone,
                          String email, String address,
                          String dob) throws Exception {

        if (username == null || username.isEmpty()) {
            throw new Exception("Username cannot be empty");
        }

        if (password == null || password.isEmpty()) {
            throw new Exception("Password cannot be empty");
        }

        if (isUsernameExist(username)) {
            throw new Exception("Username already exists");
        }

        if (!phone.matches("\\d{10,11}")) {
            throw new Exception("Phone must be 10 or 11 digits");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new Exception("Invalid email format");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(dob);

        String encryptedPassword = MD5Util.encrypt(password);

        Account account = new Account(
                username,
                encryptedPassword,
                name,
                phone,
                email,
                address,
                date
        );

        accounts.add(account);
        return accounts.size();
    }

    public boolean login(String username, String password) throws Exception {
        String encrypted = MD5Util.encrypt(password);

        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)
                    && acc.getPassword().equals(encrypted)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameExist(String username) {
        for (Account acc : accounts) {
            if (acc.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}
