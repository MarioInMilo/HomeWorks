import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;


public class Employees implements Serializable {
    transient private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ArrayList<Employee> employees;

    public Employees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Employees() {

    }

    public static BufferedReader getReader() {
        return reader;
    }

    public static void setReader(BufferedReader reader) {
        Employees.reader = reader;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }


//    public void searchByAgeOrLastName() throws IOException {
//        System.out.println("""
//                Фильтр по возрасту - 1
//                Фильтр по первой букву фамилии - 2
//                """);
//        int choice = Integer.parseInt(reader.readLine());
//        if (choice == 1) {
//            System.out.println("Введите возраст:");
//            int ageTemp = Integer.parseInt(reader.readLine());
//            for (Employee employee :
//                    employees) {
//                if (employee.getAge() == ageTemp) {
//                    System.out.println(employee);
//                }
//            }
//        } else if (choice == 2) {
//            System.out.println("Введите букву:");
//            String lastNameTemp = reader.readLine();
//            for (Employee employee :
//                    employees) {
//                String temp = String.valueOf(employee.getLastName().charAt(0));
//                if (temp.equalsIgnoreCase(lastNameTemp)) {
//                    System.out.println(employee);
//                }
//            }
//        }
//    }

    public Employees searchByAgeOrLastName1() throws IOException {
        Employees employe = new Employees();
        ArrayList<Employee> eList = new ArrayList<>();
        System.out.println("""
                Фильтр по возрасту - 1
                Фильтр по первой букву фамилии - 2
                """);
        int choice = Integer.parseInt(reader.readLine());
        if (choice == 1) {
            System.out.println("Введите возраст:");
            int ageTemp = Integer.parseInt(reader.readLine());
            for (Employee employee :
                    employees) {
                if (employee.getAge() == ageTemp) {
                    eList.add(employee);
                }
            }
        } else if (choice == 2) {
            System.out.println("Введите букву:");
            String lastNameTemp = reader.readLine();
            for (Employee employee2 :
                    employees) {
                String temp = String.valueOf(employee2.getLastName().charAt(0));
                if (temp.equalsIgnoreCase(lastNameTemp)) {
                    eList.add(employee2);
                }
            }
        }
        employe.setEmployees(eList);
        return employe;
    }

    public void changeEmployeeInformation(String name, String lastName, String post, int age, int exp) throws
            IOException {
        boolean flag = true;
        for (Employee employee :
                employees) {
            if (employee.getName().equals(name) && employee.getLastName().equals(lastName)
                    && employee.getPost().equals(post) && employee.getAge() == age && employee.getExp() == exp) {
                while (flag) {
                    System.out.println("""
                            Введите в консоль:
                            1 - Изменить имя
                            2 - Изменить фамилию
                            3 - Изменить должность
                            4 - Изменить возраст
                            5 - Изменить стаж
                            6 - Выйти
                            """);
                    int choice = Integer.parseInt(reader.readLine());
                    if (choice == 1) {
                        System.out.println("Введите новое имя:");
                        employee.setName(reader.readLine());
                    } else if (choice == 2) {
                        System.out.println("Введите новую фамилию:");
                        employee.setLastName(reader.readLine());
                    } else if (choice == 3) {
                        System.out.println("Выберите новую должность");
                        String[] postList = {"seller", "courier", "manager", "director"};
                        System.out.println("""
                                1 - seller
                                2 - courier
                                3 - manager
                                4 - director
                                """);
                        employee.setPost(postList[Integer.parseInt(reader.readLine())]);
                    } else if (choice == 4) {
                        System.out.println("Введите новый возраст:");
                        employee.setAge(Integer.parseInt(reader.readLine()));
                    } else if (choice == 5) {
                        System.out.println("Введите новый стаж:");
                        employee.setExp(Integer.parseInt(reader.readLine()));
                    } else {
                        flag = false;

                    }
                }
            }
        }
    }

    public void deleteEmployee(String name, String lastName, String post, int age, int exp) {
        employees.removeIf(employee -> employee.getName().equals(name) && employee.getLastName().equals(lastName)
                && employee.getPost().equals(post) && employee.getAge() == age && employee.getExp() == exp);
    }


    //    public Employee searchLastName(String lastName) {
//        for (Employee employee :
//                employees) {
//            if (employee.getLastName().equals(lastName)) {
//                return employee;
//            }
//        }
//        return null;
//    }
    public Employees searchByLastName() throws IOException {
        Employees employe = new Employees();
        ArrayList<Employee> eList = new ArrayList<>();
        System.out.println("Введите фамилию:");
        String userChoice = reader.readLine();
        for (Employee employee :
                employees) {
            if (userChoice.equalsIgnoreCase(employee.getLastName())) {
                eList.add(employee);
            }
        }
        employe.setEmployees(eList);
        System.out.println(employe);
        return employe;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + employees +
                '}';
    }
}
