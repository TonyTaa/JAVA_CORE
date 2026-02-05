package main;

import java.util.Locale;
import java.util.ResourceBundle;

public class Service {

    private ResourceBundle bundle;

    // Function 1: setLocate
    public void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("main.messages", locale);
    }

    public String getMessage(String key) {
        return bundle.getString(key);
    }

    // Function 2: checkAccountNumber
    public String checkAccountNumber(String accountNumber) {
        if (Validation.isValidAccountNumber(accountNumber)) {
            return getMessage("account.valid");
        }
        return getMessage("account.invalid");
    }

    // Function 3: checkPassword
    public String checkPassword(String password) {
        if (Validation.isValidPassword(password)) {
            return getMessage("password.valid");
        }
        return getMessage("password.invalid");
    }

    // Function 4: generate captcha
    public String generateCaptcha() {
        return Validation.generateCaptcha();
    }

    // Function 5: check captcha
    public String checkCaptcha(String input, String captcha) {
        if (Validation.isValidCaptcha(input, captcha)) {
            return getMessage("captcha.valid");
        }
        return getMessage("captcha.invalid");
    }
}
