package homeWorkTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task {


    public static void main(String[] args) throws IOException {
        BufferedReader fractionTaskReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первую дробь:");
        String[] fractionSplit = fractionTaskReader.readLine().split("/");
        double firstFraction = Integer.parseInt(fractionSplit[0]) / Integer.parseInt(fractionSplit[1]);
        System.out.println("Введите вторую дробь:");
        fractionSplit = fractionTaskReader.readLine().split("/");
        double secondFraction = Integer.parseInt(fractionSplit[0]) / Integer.parseInt(fractionSplit[1]);


        Runnable summa = () -> System.out.println(firstFraction + secondFraction);
        new Thread(summa).start();

        Runnable minus = () -> System.out.println(firstFraction - secondFraction);
        new Thread(minus).start();

        Runnable multiplication = () -> System.out.println(firstFraction * secondFraction);
        new Thread(multiplication).start();

        Runnable div = () -> System.out.println(firstFraction / secondFraction);
        new Thread(div).start();

    }


}
