package main;

public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String code, String name,
                             float area, String terrain) {
        super(code, name, area);
        this.countryTerrain = terrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s %-20s %-15.2f %-20s\n",
                countryCode, countryName, totalArea, countryTerrain);
    }
}
