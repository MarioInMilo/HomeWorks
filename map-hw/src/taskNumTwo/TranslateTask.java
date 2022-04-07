//package taskNumTwo;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//
//public class TranslateTask {
//    protected static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    protected static HashMap<String, List<String>> words = new HashMap<>();
//    public static HashMap<String, Integer> statistic = new HashMap<>();
//
//
//
//
//
//    public static void main(String[] args) throws IOException {
//        translateWords();
//        boolean isSwitchRound = true;
//        while (isSwitchRound) {
//            int choice = menu();
//            switch (choice) {
//                case 1 -> addWord();
//                case 2 -> rusToEng();
//                case 3 -> replaceWord();
//                case 4 -> deleteWord();
//                case 5 -> upStat();
//                case 6 -> downStat();
//                case 7 -> isSwitchRound = false;
//            }
//        }
//
//    }
//
//    private static void downStat() {
//        System.out.println(stat);
//
//    }
//
//    private static void upStat() {
//
//    }
//
//
////
////    private static void replaceTranslate() throws IOException {
////        System.out.println("Введите слово:");
////        String addWordReader;
////        addWordReader = reader.readLine();
////        Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
////        List<String> tempAdd = new ArrayList<>();
////        for (Map.Entry<String, List<String>> pair : entrySet) {
////            if (addWordReader.equals(pair.getKey())) {
////                tempAdd.addAll(pair.getValue());
////            }
////        }
////        System.out.println("Введите перевод который хотите удалить:");
////        String replaceDelete = reader.readLine();
////        tempAdd.remove(replaceDelete);
////        words.put(addWordReader, tempAdd);
////
////    }
//
//    // Удаление перевода слова
//    private static void replaceWord() throws IOException {
//        System.out.println("Введите слово:");
//        String addWordReader;
//        addWordReader = reader.readLine();
//        Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
//        List<String> tempAdd = new ArrayList<>();
//        for (Map.Entry<String, List<String>> pair : entrySet) {
//            if (addWordReader.equals(pair.getKey())) {
//                tempAdd.addAll(pair.getValue());
//            }
//        }
//        words.remove(addWordReader.toLowerCase());
//        System.out.println("Введите слово на которое хотите заменить:");
//        words.put(reader.readLine(), tempAdd);
//
//    }
//
//    // Добавление нового слова, переводов и изменение существующих переводов
//    private static void addWord() throws IOException {
//        System.out.println("""
//                1 - Хотите добавить новое слово.
//                2 - Хотите добавить переводы к слову.
//                3 - Хотите удалить перевод.
//                """);
//        String addWordReader;
//        boolean addWordFlag = true;
//        int choiceAddWord = Integer.parseInt(reader.readLine());
//        if (choiceAddWord == 1) {
//            System.out.println("Введите слово по-Английски:");
//            addWordReader = reader.readLine();
//            System.out.println("Введите перевод к этому слову:");
//            String addTranslateWord = reader.readLine();
//            words.put(addWordReader, List.of(addTranslateWord));
//        } else if (choiceAddWord == 2) {
//            System.out.println("Введите слово по-Английски:");
//            addWordReader = reader.readLine();
//            Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
//            List<String> tempAdd = new ArrayList<>();
//            for (Map.Entry<String, List<String>> pair : entrySet) {
//                if (addWordReader.equals(pair.getKey())) {
//                    tempAdd.addAll(pair.getValue());
//                }
//            }
//            while (addWordFlag) {
//                System.out.println("Введите перевод который хотите добавть:");
//                tempAdd.add(reader.readLine());
//                System.out.println("Если хотите добавить еще переводы - 1");
//                if (Integer.parseInt(reader.readLine()) != 1) {
//                    words.put(addWordReader, tempAdd);
//                    addWordFlag = false;
//                }
//            }
//        } else if (choiceAddWord == 3) {
//            System.out.println("Введите слово по-Английски:");
//            addWordReader = reader.readLine();
//            Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
//            List<String> tempAdd = new ArrayList<>();
//            for (Map.Entry<String, List<String>> pair : entrySet) {
//                if (addWordReader.equals(pair.getKey())) {
//                    tempAdd.addAll(pair.getValue());
//                }
//            }
//            words.remove(addWordReader.toLowerCase());
//            System.out.println("Введите слово на которое хотите заменить:");
//            words.put(reader.readLine(), tempAdd);
//        } else {
//            System.err.println("Вы ввели неправильное число!");
//        }
//    }
//
//    private static void deleteWord() throws IOException {
//        System.out.println("Введите слово по-Английски:");
//        String deleteUserWords = reader.readLine();
//        if (words.containsKey(deleteUserWords.toLowerCase(Locale.ROOT))) {
//            System.out.printf("%s - %s%n", deleteUserWords, words.get(deleteUserWords.toLowerCase()));
//            System.out.println("""
//                    Введите '1' для удаления всей коллекции слова.
//                    Введите '2' для удаления.
//                    """);
//            int switchDeleteChoice = Integer.parseInt(reader.readLine());
//            switch (switchDeleteChoice) {
//                case 1 -> words.remove(deleteUserWords.toLowerCase());
//                case 2 -> {
//                    Set<Map.Entry<String, List<String>>> entrySet = words.entrySet();
//                    List<String> tempAdd = new ArrayList<>();
//                    for (Map.Entry<String, List<String>> pair : entrySet) {
//                        if (deleteUserWords.equals(pair.getKey())) {
//                            tempAdd.addAll(pair.getValue());
//                        }
//                    }
//                    System.out.println("Введите перевод который хотите удалить:");
//                    tempAdd.remove(reader.readLine());
//                    words.put(deleteUserWords, tempAdd);
//                }
//            }
//        } else {
//            System.out.println("Перевод не найден.");
//        }
//    }
//
//    // Сам переводчик
//    private static void rusToEng() throws IOException {
//        System.out.println("Введите слово по-Английски:");
//        String rusToEngUserWords = reader.readLine();
//        if (words.containsKey(rusToEngUserWords.toLowerCase(Locale.ROOT))) {
//            System.out.printf("%s - %s%n", rusToEngUserWords, words.get(rusToEngUserWords.toLowerCase()));
//            int statWordCount = statistic.get(rusToEngUserWords.toLowerCase());
//            statistic.put(rusToEngUserWords, ++statWordCount);
//
//
//        } else {
//            System.out.println("Перевод не найден.");
//        }
//
//
//    }
//
//
//    private static int menu() throws IOException {
//        System.out.println("""
//                _-Выберите операцию-_
//                1 - Перевод слова.
//                2 - Удалить слова.
//                3 - Добавить слово.
//                4 - Удалить слово.
//                5 - Удалить перевод слова.
//                6 - Заменить перевод слова.
//                7 - Добавить перевод слову.
//                8 - Отобразить 10 самых популярных слов.
//                9 - Отобразить 10 самых непопулярных слов.
//                10 - Выход.
//                _-Данный номер операции необходимо ввести в консоль-_
//                """);
//        return Integer.parseInt(reader.readLine());
//    }
//
//    // default words pack
//    private static void translateWords() {
//        List<String> hello = new ArrayList<>(Arrays.asList("привет", "здравствуйте"));
//        words.put("hello", hello);
//        statistic.put("hello", 0);
//        List<String> bye = new ArrayList<>(Arrays.asList("пока", "до встречи"));
//        words.put("bye", bye);
//        statistic.put("bye", 0);
//        List<String> okay = new ArrayList<>(Arrays.asList("хорошо", "окей"));
//        words.put("okay", okay);
//        statistic.put("okay", 0);
//    }
//
//}
//
