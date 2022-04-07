package taskNumThree;

import java.util.ArrayList;
import java.util.Arrays;

public class fineBase {
    private String city;
    private ArrayList<String> fine;
    private String name;

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFine(ArrayList<String> fine) {
        this.fine = fine;
    }

    public fineBase(String city, ArrayList<String> fine, String name) {
        this.city = city;
        this.fine = fine;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<String> getFine() {
        return fine;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "\nName: " + name + " | City: " + city + " | Fine: " + fine + "\n";

    }
}
