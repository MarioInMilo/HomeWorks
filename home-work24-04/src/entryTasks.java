import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entryTasks {
    public static void main(String[] args) throws IOException {
        t1();
        t2();
        t3();

    }


    private static void t1() {
        System.out.println("////////////////////Task №1////////////////////");
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("1", 1);
        stringIntegerHashMap.put("2", 2);
        stringIntegerHashMap.put("3", 3);
        System.out.println("While");
        Iterator iterator = stringIntegerHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Улучшенный цикл for");
        for (Map.Entry<String, Integer> pair : stringIntegerHashMap.entrySet()) {
            System.out.println(pair);
        }
        System.out.println("//////////////////////////////////////");
    }


    private static void t2() {
        System.out.println("////////////////////Task №2////////////////////");
        HashMap<String, Product> productHashMap = new HashMap<>();
        productHashMap.put("Teddy", new Product("Dear"));
        productHashMap.put("Clara", new Product("Barbie"));
        productHashMap.put("Thunder", new Product("Car"));
        productHashMap.put("PM", new Product("gun"));

        System.out.println("""
                                
                Перебрать и распечатать пары значений - entrySet()
                """);
        for (Map.Entry<String, Product> pair :
                productHashMap.entrySet()) {
            System.out.printf("%s %s %n", pair.getKey(), pair.getValue());
        }
        System.out.println("""
                                
                Перебрать и распечатать набор из имен продуктов  - keySet()
                """);
        for (String keySetPrint :
                productHashMap.keySet()) {
            System.out.println(keySetPrint);
        }
        System.out.println("""
                                
                Перебрать и распечатать значения продуктов - values()
                """);
        for (Product valuesPrint :
                productHashMap.values()) {
            System.out.println(valuesPrint);
        }
        System.out.println("//////////////////////////////////////");
    }

    private static void t3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nikolay", "Eng", 3, new ArrayList<>(Arrays.asList(8, 2, 3))));
        studentList.add(new Student("Genadi", "Eng", 1, new ArrayList<>(Arrays.asList(10, 10, 10))));
        studentList.add(new Student("Anatoliy", "Eng", 2, new ArrayList<>(Arrays.asList(6, 2, 1))));
        studentList.add(new Student("Mark", "Eng", 4, new ArrayList<>(Arrays.asList(3, 2, 3))));
        for (int i = 0; i < studentList.size(); i++) {
            double avg = studentList.get(i).getMarks().stream()
                    .mapToInt(s -> s)
                    .average()
                    .getAsDouble();
            if (avg < 3) {
                studentList.remove(i);
            }
            if (avg >= 3) {
                int tempCourse = studentList.get(i).getCourse();
                studentList.get(i).setCourse(++tempCourse);
            }
        }
        System.out.println("Введите номер курса который хотите распечатать:");
        printStudents(studentList, Integer.parseInt(reader.readLine()));
    }

    private static void printStudents(List<Student> students, int course) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse() == course) {
                studentList.add(student);
            }
        }
        for (Student s :
                studentList) {
            System.out.println(s);
        }
    }


    private static class Student {
        private final String name;
        private final String group;
        private int course;
        private final List<Integer> marks;

        public Student(String name, String group, int course, List<Integer> marks) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.marks = marks;
        }

        public void setCourse(int course) {
            this.course = course;
        }


        public int getCourse() {
            return course;
        }

        public List<Integer> getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", group='" + group + '\'' +
                    ", course=" + course +
                    ", marks=" + marks +
                    '}';
        }
    }


    private record Product(String name) {

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
