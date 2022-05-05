public class Bear extends Thread {
    private HoneyThread bearHoneyThread;

    public Bear(HoneyThread honey) {
        this.bearHoneyThread = honey;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bearHoneyThread) {
                while (!bearHoneyThread.isFull()) {
                    try {
                        bearHoneyThread.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Медведь поел");
                bearHoneyThread.emptyPot();
            }
        }
    }
}
