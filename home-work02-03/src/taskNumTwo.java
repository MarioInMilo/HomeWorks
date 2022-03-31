import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class taskNumTwo {
    protected static HashSet<LoginAndPass> accountInfo = new HashSet<>();
    protected static String fLogin;

    public static void main(String[] args) throws IOException {
        loginPass();
    }


    public static void loginPass() throws IOException {

        BufferedReader loginReader = new BufferedReader(new InputStreamReader(System.in));
        boolean actionMenu = true;
        LoginAndPass tempAcc;
        String login, password;
        while (actionMenu) {
            System.out.println("""
                    1. Добавить нового пользователя.
                    2. Удалить существующего пользователя.
                    3. Проверить существует ли пользователь.
                    4. Изменить логин существующего пользователя.
                    5. Изменить пароль существующего пользователя.
                    6. Список пользователей.
                    7. Выход.""");
            switch (Integer.parseInt(loginReader.readLine())) {
                case 1 -> {
                    System.out.println("Введите логин:");
                    login = loginReader.readLine();
                    System.out.println("Введите пароль:");
                    password = loginReader.readLine();
                    if (accountInfo.add(new LoginAndPass(login, password))) {
                        System.out.println("Аккаунт создан.");
                    } else {
                        System.out.println("Такой аккаунт уже существует.");
                    }
                }
                case 2 -> {
                    System.out.println("Введите логин:");
                    login = loginReader.readLine();
                    fLogin = login;
                    if (accountInfo.removeIf(LoginAndPass -> fLogin.equals(LoginAndPass.getLogin()))) {
                        System.out.println("Аккаунт удален");
                    } else {
                        System.out.println("Такой аккаунт не существует");
                    }
                }
                case 3 -> {
                    System.out.println("Введите логин:");
                    login = loginReader.readLine();
                    System.out.println("Введите пароль:");
                    password = loginReader.readLine();
                    LoginAndPass l = new LoginAndPass(login, password);
                    if (accountInfo.contains(l)) {
                        System.out.println("Аккаует существует");
                    } else {
                        System.out.println("Аккаунт не существует");
                    }
                }
                case 4 -> {
                    System.out.println("Введите логин:");
                    login = loginReader.readLine();
                    fLogin = login;
                    System.out.println("Введите пароль:");
                    password = loginReader.readLine();
                    tempAcc = new LoginAndPass(login, password);
                    if (accountInfo.contains(tempAcc)) {
                        accountInfo.removeIf(LoginAndPass -> fLogin.equals(LoginAndPass.getLogin()));
                        System.out.println("Введите новый логин:");
                        login = loginReader.readLine();
                        accountInfo.add(new LoginAndPass(login, password));
                        System.out.println("Успешно!");
                    } else {
                        System.out.println("Аккаунта не существует!");
                    }
                }
                case 5 -> {
                    System.out.println("Введите логин:");
                    login = loginReader.readLine();
                    fLogin = login;
                    System.out.println("Введите пароль:");
                    password = loginReader.readLine();
                    tempAcc = new LoginAndPass(login, password);
                    if (accountInfo.contains(tempAcc)) {
                        accountInfo.removeIf(LoginAndPass -> fLogin.equals(LoginAndPass.getLogin()));
                        System.out.println("Введите новый пароль:");
                        password = loginReader.readLine();
                        accountInfo.add(new LoginAndPass(login, password));
                        System.out.println("Успешно!");
                    } else {
                        System.out.println("Аккаунта не существует!");
                    }
                }
                case 6 -> System.out.println(accountInfo);
                case 7 -> {
                    System.out.println("Выход.");
                    actionMenu = false;
                }
                default -> throw new IllegalStateException("Unexpected value: " + Integer.parseInt(loginReader.readLine()));
            }
        }
    }

}
