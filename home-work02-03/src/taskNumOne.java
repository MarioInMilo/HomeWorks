import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class taskNumOne {
    public static void main(String[] args) throws IOException {
        first();
    }

    public static void first() throws IOException {
        HashSet<Integer> num = new HashSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean startMenuFirst = true, actionMenu = true;
        int tempFirst;
        System.out.println("Введите в консоль: ");
        while (startMenuFirst) {
            System.out.println("Хотите добавить значение в список - 1.\nХотите выйти из добавления - 2.");
            if (Integer.parseInt(reader.readLine()) == 1) {
                System.out.println("Введите число:");
                tempFirst = Integer.parseInt(reader.readLine());
                if (!num.contains(tempFirst)) {
                    num.add(tempFirst);
                } else {
                    System.err.println("Значние уже есть в списке!");
                }

            } else {
                startMenuFirst = false;
            }
        }
        while (actionMenu) {
            System.out.println("""
                    1. Добавить элемент в список.
                    2. Удалить элемент из списка.
                    3. Показать содержимое списка.
                    4. Проверить есть ли значение в списке.
                    5. Заменить значение в списке.
                    6. Выйти из программы.
                    Введите номер операции которую хотите выполнить в консоль:
                    """);
            switch (Integer.parseInt(reader.readLine())) {
                case 1 -> {
                    System.out.println("Введите Значение:");
                    tempFirst = Integer.parseInt(reader.readLine());
                    if (num.contains(tempFirst)) {
                        System.err.println("Данное значние уже есть в списке!");
                    } else {
                        num.add(tempFirst);
                        System.out.println("Число успешно добавлено!");
                    }
                }
                case 2 -> {
                    System.out.println("Введите Значение:");
                    tempFirst = Integer.parseInt(reader.readLine());
                    if (num.contains(tempFirst)) {
                        System.err.println("Значения нет в списке!");
                    } else {
                        num.remove(tempFirst);
                        System.out.println("Значение успешно удалено!");
                    }
                }
                case 3 -> System.out.println(num);
                case 4 -> {
                    System.out.println("Введите Значение:");
                    if (num.contains(Integer.parseInt(reader.readLine()))) {
                        System.out.println("Значение есть в списке!");
                    } else {
                        System.out.println("Значение нет в списке!");
                    }
                }
                case 5 -> {
                    System.out.println("Введите Значение:");
                    tempFirst = Integer.parseInt(reader.readLine());
                    if (num.contains(tempFirst)) {
                        num.remove(tempFirst);
                        System.out.println("Введите новое Значение:");
                        num.add(Integer.parseInt(reader.readLine()));
                        System.out.println("Значение успешно заменено!");
                    } else {
                        System.err.println("Значения нет в списке!");
                    }
                }

                case 6 -> {
                    System.out.println("Программа завершена!");
                    actionMenu = false;
                }
            }
        }


    }
}
