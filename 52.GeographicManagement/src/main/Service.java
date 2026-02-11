package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Service {

    private ArrayList<EastAsiaCountries> list = new ArrayList<>();
    private static final int MAX = 11;

    // Function 1
    public void addCountryInformation(EastAsiaCountries country) throws Exception {
        if (list.size() >= MAX) {
            throw new Exception("Cannot add more than 11 countries.");
        }

        // check duplicate code
        for (EastAsiaCountries c : list) {
            if (c.getCountryCode().equalsIgnoreCase(country.getCountryCode())) {
                throw new Exception("Country code already exists.");
            }
        }

        list.add(country);
    }

    // Function 2
    public ArrayList<EastAsiaCountries> getRecentlyEnteredInformation() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("List is empty.");
        }
        return list;
    }

    // Function 3
    public ArrayList<EastAsiaCountries> searchInformationByName(String name)
            throws Exception {

        ArrayList<EastAsiaCountries> result = new ArrayList<>();

        for (EastAsiaCountries c : list) {
            if (c.getCountryName().toLowerCase()
                    .contains(name.toLowerCase())) {
                result.add(c);
            }
        }

        if (result.isEmpty()) {
            throw new Exception("No country found.");
        }

        return result;
    }

    // Function 4
    public ArrayList<EastAsiaCountries> sortInformationByAscendingOrder()
            throws Exception {

        if (list.isEmpty()) {
            throw new Exception("List is empty.");
        }

        ArrayList<EastAsiaCountries> sorted = new ArrayList<>(list);

        Collections.sort(sorted, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName()
                        .compareToIgnoreCase(o2.getCountryName());
            }
        });

        return sorted;
    }
}
