package homeWorkOne;

public class Tasks {
    public static void main(String[] args) throws InterruptedException {
        t1();
    }

    private static void t1(){
        MyThread t = new MyThread(10);
        t.setName("GENERATE");
        t.start();
        try {
            t.join();
            MyThread t2 = new MyThread(t.getArray());
            t2.setName("AVG");
            t2.start();
            MyThread t3 = new MyThread(t.getArray());
            t3.setName("SUM");
            t3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}