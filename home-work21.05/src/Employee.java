import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private String name, lastName, post;
    private int age, exp;

    public Employee(String name, String lastName, String post, int age, int exp) {
        this.name = name;
        this.lastName = lastName;
        this.post = post;
        this.age = age;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", post='" + post + '\'' +
                ", age=" + age +
                ", exp=" + exp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && exp == employee.exp && Objects.equals(name, employee.name) && Objects.equals(lastName, employee.lastName) && Objects.equals(post, employee.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, post, age, exp);
    }
}
