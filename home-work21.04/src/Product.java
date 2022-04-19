public class Product {
    private String name;
    private int year;

    public Product(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
