package taskNumTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serial;
import java.util.*;


public class Translate {
    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected static HashMap<String, List<String>> words = new HashMap<>();
    //    protected static List<String> stats = new ArrayList<>();
    protected static HashMap<String, Integer> stat = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException {
        boolean userChoiceMenu = true;
        init();
        while (userChoiceMenu) {
            int choice = menu();
            switch (choice) {
                case 1 -> rusToEng();
                case 2 -> addWord();
                case 3 -> deleteWord();
                case 5 -> replaceWord();
                case 6 -> statUp();
                case 7 -> statDown();
                case 8 -> userChoiceMenu = false;

            }
        }

    }

    private static void statDown() {
        stat.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue()).forEach(System.out::println);
    }

    private static void statUp() {
        stat.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
    }

    private static void replaceWord() throws IOException {
        System.out.println("""
                Введите в консоль:
                '1' - для изменения слова
                '2' - для изменения перевода в слове
                """);
        String userWordReplace;
        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> {
                System.out.println("Введите слово");
                userWordReplace = reader.readLine();
                Set<Map.Entry<String, List<String>>> entrySetReplace = words.entrySet();
                List<String> tempAddReplace = new ArrayList<>();
                for (Map.Entry<String, List<String>> pair : entrySetReplace) {
                    if (userWordReplace.equals(pair.getKey())) {
                        tempAddReplace.addAll(pair.getValue());
                    }
                }
                words.remove(userWordReplace);
                System.out.println("Введите новое название для слова:");
                words.put(reader.readLine().toLowerCase(Locale.ROOT), tempAddReplace);
            }
            case 2 -> {
                System.out.println("Введите слово:");
                userWordReplace = reader.readLine();
                List<String> replaceTemp = new ArrayList<>();
                Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
                for (Map.Entry<String, List<String>> pair :
                        entrySet) {
                    if (userWordReplace.equals(pair.getKey())) {
                        replaceTemp = pair.getValue();
                    }
                }

                System.out.println(replaceTemp + "\nВведите слово которое хотите заменить:");
                replaceTemp.remove(reader.readLine().toLowerCase(Locale.ROOT));
                System.out.println("Введите новое слово:");
                replaceTemp.add(reader.readLine().toLowerCase(Locale.ROOT));
                words.put(userWordReplace, replaceTemp);
            }
        }
    }

    private static void deleteWord() throws IOException {
        System.out.println("Введите слово:");
        String deleteWord = reader.readLine();
        System.out.println("""
                Введите в консоль:
                '1' - для удаления слова.
                '2' - для удаления перевода.
                """);
        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> {
                if (words.containsKey(deleteWord.toLowerCase(Locale.ROOT))) {
                    words.remove(deleteWord);
                } else {
                    System.out.println("Слово не найдено.");
                }
            }
            case 2 -> {
                List<String> tempDelete = new ArrayList<>();
                Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
                for (Map.Entry<String, List<String>> pair :
                        entrySet) {
                    if (deleteWord.equals(pair.getKey())) {
                        tempDelete.addAll(pair.getValue());
                    }
                }

                System.out.println(tempDelete + "\nВведите перевод:");
                String tempTransDelete = reader.readLine();
                if (tempDelete.contains(tempTransDelete)) {
                    tempDelete.remove(reader.readLine().toLowerCase(Locale.ROOT));
                    System.out.println("Перевод удален");
                } else {
                    System.out.println("Перевода нет");
                }
            }


        }

    }

    private static void addWord() throws IOException {
        System.out.println("""
                 Введите в консоль:
                '1' - Если хотите добавить новое слово.
                '2' - Если хотите добавить перевод к существующему слову.
                 """);
        String userWordAdd;
        switch (Integer.parseInt(reader.readLine())) {
            case 1 -> {
                System.out.println("Введите слово:");
                userWordAdd = reader.readLine();
                System.out.println("Введите перевод к данному слову:");
                words.put(userWordAdd.toLowerCase(Locale.ROOT), List.of(reader.readLine()));
                System.out.printf("Слово %s успешно добавлено", userWordAdd);
                stat.put(userWordAdd, 0);
            }
            case 2 -> {
                System.out.println("Введите слово:");
                userWordAdd = reader.readLine();
                Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
                List<String> tempAdd = new ArrayList<>();
                for (Map.Entry<String, List<String>> pair : entrySet) {
                    if (userWordAdd.equals(pair.getKey())) {
                        tempAdd.addAll(pair.getValue());
                    }
                }
                System.out.println("Введите перевод:");
                tempAdd.add(reader.readLine());
                words.put(userWordAdd.toLowerCase(Locale.ROOT), tempAdd);
            }

        }
    }

    private static void rusToEng() throws IOException {
        System.out.println("Введите слово на английском:");
        String rusToEngUserWord = reader.readLine();
        if (words.containsKey(rusToEngUserWord.toLowerCase(Locale.ROOT))) {
            System.out.printf("Слово %s переводится как - %s", rusToEngUserWord, words.get(rusToEngUserWord.toLowerCase(Locale.ROOT)));
            int statistic = stat.get(rusToEngUserWord.toLowerCase(Locale.ROOT));
            stat.put(rusToEngUserWord, ++statistic);
        } else {
            System.out.println("""
                    Данного слова нет в колекции.
                    Хотите добавить слово - введите в консоль - '+'.
                    """);
            if (Objects.equals(reader.readLine(), "+")) {
                addWord();
            }

        }
    }

    private static int menu() throws IOException {
        System.out.println("""
                  
                  _-Выберите операцию-_
                '1' - Перевод слова.
                '2' - Добавление новоего слово, добавления перевода.
                '3' - Удаление слова, удаление перевода.
                '4' - Изменение слова, изменения перевода.
                '5' - Статистика слова по убыванию.
                '6' - Статистика слова по возрастанию.
                '7' - Выход.
                  _-Данный номер операции необходимо ввести в консоль-_
                  
                  """);
        return Integer.parseInt(reader.readLine());
    }

    private static void init() {
        words.put("hello", Arrays.asList("привет", "хай"));
        stat.put("hello", 0);
        words.put("bye", List.of("пока"));
        stat.put("bye", 0);
        words.put("no", Arrays.asList("нет", "неа"));
        stat.put("no", 0);

    }
}
