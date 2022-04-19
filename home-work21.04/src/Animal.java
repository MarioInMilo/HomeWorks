public class Animal implements Comparable<Animal> {

    private String name;
    private int year;
    private String month;

    public Animal(String name, int year, String month) {
        this.name = name;
        this.year = year;
        this.month = month;
    }



    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                " | Year: " + year +
                " | Month: " + month;
    }

    @Override
    public int compareTo(Animal o) {
        return this.getName().length() - o.getName().length();
    }

}
