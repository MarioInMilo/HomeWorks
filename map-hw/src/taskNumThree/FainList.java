package taskNumThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class FainList {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<Integer, fineBase> person = new HashMap<>();

    public static void main(String[] args) throws IOException {
        boolean userWhileChoice = true;
        //Test person
        person.put(1, new fineBase("Minsk", new ArrayList<>(Arrays.asList("ПДД", "Скоростный режим")), "John"));
        person.put(2, new fineBase("Minsk", new ArrayList<>(Arrays.asList("ПДД", "Езда без прав")), "John"));
//
        while (userWhileChoice) {
            int listChoice = menu();
            switch (listChoice) {
                case 1 -> System.out.println(person);
                case 2 -> printByCode();
                case 3 -> byFair();
                case 4 -> byCity();
                case 5 -> createNewPerson();
                case 6 -> addNewFain();
                case 7 -> deleteFain();
                case 8 -> replaceInfo();
                case 9 -> userWhileChoice = false;
            }
        }

    }

    private static void replaceInfo() throws IOException {
        System.out.println("""
                1 - Изменить имя.
                2 - Изменить штраф.
                3 - Изменить город.
                """);
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1:
                System.out.println("Введите ID человека:");
                int tempIDReplace = Integer.parseInt(reader.readLine());
                System.out.println("Введите новое имя:");
                person.get(tempIDReplace).setName(reader.readLine());
                break;
            case 2:
                deleteFain();
                addNewFain();
                break;
            case 3:
                System.out.println("Введите ID человека:");
                tempIDReplace = Integer.parseInt(reader.readLine());
                System.out.println("Введите новый город:");
                person.get(tempIDReplace).setCity(reader.readLine());
                break;
        }
    }

    private static void deleteFain() throws IOException {
        System.out.println("Введите ID человека:");
        int tempIDDelete = Integer.parseInt(reader.readLine());
        System.out.println("Введите штраф который хотите удалить:");
        String tempStringDelete = reader.readLine();
        if (person.get(tempIDDelete).getFine().contains(tempStringDelete)) {
            person.get(tempIDDelete).getFine().remove(tempStringDelete);
        } else {
            System.out.println("У данного ID такой штраф не найден!");
        }

    }

    private static void addNewFain() throws IOException {
        System.out.println("Введите ID человека:");
        int tempID = Integer.parseInt(reader.readLine());
        System.out.println("Введите штраф которой хотите добавить:");
        person.get(tempID).getFine().add(reader.readLine());
        System.out.println(person.get(tempID));
    }

    private static void createNewPerson() throws IOException {
        System.out.println("Введите индефикационный номер для человека:");
        int idNum = Integer.parseInt(reader.readLine());
        System.out.println("Введите имя:");
        String name = reader.readLine();
        System.out.println("Введите город:");
        String city = reader.readLine();
        System.out.println("Введите штрафы через пробел:");
        String fines = reader.readLine();
        String[] spil = fines.split(" ");
        ArrayList<String> asd = new ArrayList<>(Arrays.asList(spil));
        person.put(idNum, new fineBase(city, asd, name));
        System.out.println(person.get(idNum));
    }

    private static void byCity() throws IOException {
        Set<Map.Entry<Integer, fineBase>> entrySet = person.entrySet();
        System.out.println("Введите город:");
        String cityName = reader.readLine();
        for (Map.Entry<Integer, fineBase> pair :
                entrySet) {
            if (Objects.equals(pair.getValue().getCity(), cityName)) {
                System.out.println(pair);
            }
        }
    }

    private static void byFair() throws IOException {
        Set<Map.Entry<Integer, fineBase>> entrySet = person.entrySet();
        System.out.println("Введите названия нарушения:");
        String fineName = reader.readLine();
        for (Map.Entry<Integer, fineBase> pair :
                entrySet) {
            for (int i = 0; i < pair.getValue().getFine().size(); i++) {
                if (Objects.equals(pair.getValue().getFine().get(i), fineName)) {
                    System.out.println(pair);
                }
            }
        }
    }

    private static void printByCode() throws IOException {
        System.out.println("Введите индификационный номер человека:");
        int tempPrintByCode = Integer.parseInt(reader.readLine());
        if (person.containsKey(tempPrintByCode)) {
            System.out.println(person.get(tempPrintByCode));
        } else {
            System.err.println("Данный инификационный номер не найден!");
        }

    }

    public static int menu() throws IOException {
        System.out.println("""
                1. Полная распечатка базы данных.
                2. Распечатка данных по конкретному коду.
                3. Распечатка данных по конкретному типу штрафа.
                4. Распечатка данных по конкретному городу.
                5. Добавление нового человека с информацией о нем.
                6. Добавление новых штрафов для уже существующей записи.
                7. Удаление штрафа.
                8. Замена информации о человеке и его штрафах.
                9. Выход из программы.
                """);
        return Integer.parseInt(reader.readLine());
    }

}
