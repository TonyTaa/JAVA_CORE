package main;

import java.util.ArrayList;

public class Controller {

    private Service service = new Service();
    private Validation validation = new Validation();

    public void run() {
        while (true) {
            menu();
            int choice = validation.checkValidateNumberInRange(1, 5);

            switch (choice) {
                case 1:
                    inputCountry();
                    break;
                case 2:
                    displayCountries();
                    break;
                case 3:
                    searchCountry();
                    break;
                case 4:
                    sortCountries();
                    break;
                case 5:
                    System.out.println("Exit program.");
                    return;
            }
        }
    }

    private void menu() {
        System.out.println("\n===== EAST ASIA COUNTRIES =====");
        System.out.println("1. Input country");
        System.out.println("2. Display countries");
        System.out.println("3. Search by name");
        System.out.println("4. Sort by name");
        System.out.println("5. Exit");
        System.out.print("Choose: ");
    }

    // Option 1
    private void inputCountry() {
        try {
            System.out.print("Country code: ");
            String code = validation.checkValidateText();

            System.out.print("Country name: ");
            String name = validation.checkValidateText();

            System.out.print("Total area: ");
            float area = validation.checkValidateArea();

            System.out.print("Terrain: ");
            String terrain = validation.checkValidateText();

            EastAsiaCountries country =
                    new EastAsiaCountries(code, name, area, terrain);

            service.addCountryInformation(country);

            System.out.println(">> Add country successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Option 2
    private void displayCountries() {
        try {
            ArrayList<EastAsiaCountries> list =
                    service.getRecentlyEnteredInformation();

            System.out.printf("%-10s %-20s %-15s %-20s\n",
                    "Code", "Name", "Area", "Terrain");

            for (EastAsiaCountries c : list) {
                c.display();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Option 3
    private void searchCountry() {
        try {
            System.out.print("Enter country name: ");
            String name = validation.checkValidateText();

            ArrayList<EastAsiaCountries> result =
                    service.searchInformationByName(name);

            for (EastAsiaCountries c : result) {
                c.display();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Option 4
    private void sortCountries() {
        try {
            ArrayList<EastAsiaCountries> sorted =
                    service.sortInformationByAscendingOrder();

            for (EastAsiaCountries c : sorted) {
                c.display();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
