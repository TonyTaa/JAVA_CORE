package main;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(int id, String fname, String lname, int birthYear, String address, 
                      String phone, String email, int type, int expInYear, String proSkill) {
        super(id, fname, lname, birthYear, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.printf("Experience: %s | %d | %s | %s | %s | %d | %s\n",
                getFullName(), birthYear, address, phone, email, expInYear, proSkill);
    }
}