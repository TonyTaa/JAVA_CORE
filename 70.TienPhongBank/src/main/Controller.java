package main;

import java.util.Locale;
import java.util.Scanner;

public class Controller {

    private final Service service = new Service();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
        	System.out.println("------- Login program ------");
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Select: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    service.setLocate(Locale.of("vn"));
                    login();
                    break;
                case "2":
                    service.setLocate(Locale.of("en"));
                    login();
                    break;
                case "3":
                    System.out.println("Exit.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void login() {

        // Account number
        String acc;
        while (true) {
            System.out.print(service.getMessage("input.account"));
            acc = sc.nextLine();
            String msg = service.checkAccountNumber(acc);
            if (msg.equals(service.getMessage("account.valid"))) {
                break;
            }
            System.out.println(msg);
        }

        // Password
        String pass;
        while (true) {
            System.out.print(service.getMessage("input.password"));
            pass = sc.nextLine();
            String msg = service.checkPassword(pass);
            if (msg.equals(service.getMessage("password.valid"))) {
                break;
            }
            System.out.println(msg);
        }

        // Captcha
        String captcha = service.generateCaptcha();
        System.out.println(service.getMessage("captcha.code") + captcha);

        while (true) {
            System.out.print(service.getMessage("input.captcha"));
            String input = sc.nextLine();
            String msg = service.checkCaptcha(input, captcha);
            if (msg.equals(service.getMessage("captcha.valid"))) {
                System.out.println(service.getMessage("login.success"));
                break;
            }
            System.out.println(msg);
        }
    }
}
