import java.io.*;
import java.util.ArrayList;


public class mainClass {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static File file;

    public static void main(String[] args) throws IOException {
        takeUser();
        dataEntry();
        changeEmployee("John", "Sers", "manager", 21, 1);
        deleteE("John", "Sers", "manager", 21, 1);
        searchByLastNameOrAge();
        searchByLastName();
        


    }

    private static void searchByLastName() throws IOException {
        Employees employees = inputE();
        Employees employees1 = employees.searchByLastName();
        System.out.println("Enter 1 if you want to save:");
        if (Integer.parseInt(reader.readLine()) == 1) {
            saveInfo(employees1);
            System.out.println("File saved!");
        }
    }

    public static void saveInfo(Employees employees) {
        File fileSearchEmpl;
        System.out.println("Enter the location where you want to save:");
        try {
            fileSearchEmpl = new File(reader.readLine());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileSearchEmpl));
            objectOutputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeUser() {
        try {
            System.out.println("Enter the path to the file:");
            file = new File(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    private static void searchByLastNameOrAge() throws IOException {
//        Employees employees = inputE();
//        employees.searchByAgeOrLastName();
//    }

//    private static Employee searchEmpl(String lastName) {
//        Employees employees = inputE();
//        return employees.searchLastName(lastName);
//    }
    
    

    private static void searchByLastNameOrAge() throws IOException {
        Employees employees = inputE();
        Employees employees1 = employees.searchByAgeOrLastName1();
        System.out.println(employees1);
        System.out.println("Enter 1 if you want to save:");
        if (Integer.parseInt(reader.readLine()) == 1) {
            saveInfo(employees1);
            System.out.println("File saved!");
        }

    }


    private static void deleteE(String name, String lastName, String post, int age, int exp) {
        Employees employees = inputE();
        employees.deleteEmployee(name, lastName, post, age, exp);
        System.out.println(employees);
        saveEmployee(employees);
    }

    private static Employees inputE() {
        Employees employees = null;
        try (FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            employees = (Employees) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    private static void dataEntry() throws IOException {
        if (file.exists()) {
            System.out.println("User info upload!");
        } else {
            Employee employee = new Employee("John", "Sers", "manager", 21, 1);
            Employee employee2 = new Employee("Piter", "Six", "manager", 21, 2);
            Employee employee1 = new Employee("Elsa", "Poth", "seller", 33, 3);

            ArrayList<Employee> employeeList = new ArrayList<>();
            employeeList.add(employee);
            employeeList.add(employee1);
            employeeList.add(employee2);

            Employees employees = new Employees(employeeList);
            System.out.println(employees);

            saveEmployee(employees);
            System.out.println("2");
        }
    }


    protected static void saveEmployee(Employees employees) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void changeEmployee(String name, String lastName, String post, int age, int exp) {
        try (FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Employees employees1 = (Employees) objectInputStream.readObject();
            employees1.changeEmployeeInformation(name, lastName, post, age, exp);
            System.out.println(employees1);
            saveEmployee(employees1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
