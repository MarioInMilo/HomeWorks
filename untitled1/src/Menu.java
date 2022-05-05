import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Menu {

    public static void menu(int size, int numberThreads) {
        HoneyThread honeyThread = new HoneyThread(size);
        Bear bear = new Bear(honeyThread);
        bear.start();
        Bees bees = new Bees(honeyThread);
        ExecutorService executorService = Executors.newFixedThreadPool(numberThreads);
        for (int i = 0; i <= numberThreads; i++) {
            executorService.submit(bees);
        }
        try {
            bear.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
