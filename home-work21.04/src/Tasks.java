import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tasks {

    public static void main(String[] args) {
        t1();
        t2();
        t3();
        t4();
        t5();


    }

    private static void t1() {
        ArrayList<Integer> list = (ArrayList<Integer>) new Random().ints(10, 1, 50)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
        OptionalDouble a = list.stream().mapToInt(value -> value)
                .average();
        System.out.println(a);
    }

    private static void t2() {
        ArrayList<Double> listDouble = new ArrayList<>(Arrays.asList(1.0, 50.0, 6.0, 6.0, 6.0, 6.0, 10.0, 10.0, 10.0));
        // Среднее арифметическое
        OptionalDouble avg = listDouble.stream()
                .mapToDouble(value -> value)
                .average();
        System.out.println(avg);
        // Сортировка
        List<Integer> a = listDouble.stream()
                .mapToInt(Double::intValue)
                .distinct()
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(a);
        // Сохранение в Set
        Set<Integer> b = new HashSet<>(a);
        System.out.println(b);


    }

    private static void t3() {
        TreeSet<Animal> anim = new TreeSet<>();
        Animal a1 = new Animal("Zebra", 3, "April");
        Animal a2 = new Animal("Hyaena", 6, "September");
        Animal a3 = new Animal("Bear", 13, "June");
        Animal a4 = new Animal("Cat", 12, "January");
        anim.add(a1);
        anim.add(a2);
        anim.add(a3);
        anim.add(a4);
        anim.forEach(System.out::println);
        System.out.println();
        anim.stream()
                .filter(animal -> animal.getMonth().equals("April"))
                .forEach(animal -> animal.setYear(animal.getYear() + 1));
        anim.forEach(System.out::println);
    }


    private static void t4() {
        HashMap<String, Product> productHashMap = new HashMap<>();
        productHashMap.put("teddy", new Product("Bear", 2011));
        productHashMap.put("USSR", new Product("Tank", 2009));
        productHashMap.put("Henry", new Product("Wolf", 2012));
        productHashMap.put("Monica", new Product("Barbie", 2009));
        productHashMap.put("Storm", new Product("Car", 2004));
        productHashMap.put("Gun", new Product("AK-47", 2002));
        productHashMap.put("Airplane", new Product("Boeing", 2001));
        productHashMap.put("Rat", new Product("Rat", 1999));

        Map<String, Product> temp = productHashMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getYear() > 2010)
                .collect(Collectors.toMap(
                        phm -> phm.getKey(),
                        phm -> phm.getValue()
                ));
        productHashMap.clear();
        productHashMap.putAll(temp);


        System.out.println(productHashMap);


    }

    private static void t5() {
        List<Student> studentList = new ArrayList<>();
        List<String> goodStu = new ArrayList<>();
        studentList.add(new Student("Nikolay", "Eng", 3, new ArrayList<>(Arrays.asList(8, 2, 3))));
        studentList.add(new Student("Genadi", "Eng", 1, new ArrayList<>(Arrays.asList(10, 10, 10))));
        studentList.add(new Student("Anatoliy", "Eng", 2, new ArrayList<>(Arrays.asList(6, 2, 1))));
        studentList.add(new Student("Mark", "Eng", 4, new ArrayList<>(Arrays.asList(3, 2, 3))));
        for (int i = 0; i < studentList.size(); i++) {
            double avg = studentList.get(i).getMarks().stream()
                    .mapToInt(s -> s)
                    .average()
                    .getAsDouble();
            if (avg >= 3) {
                goodStu.add(studentList.get(i).getName());
            }

        }
        for (String s :
                goodStu) {
            System.out.println(s);
        }

    }


}
