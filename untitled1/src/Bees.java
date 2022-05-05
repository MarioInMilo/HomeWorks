public class Bees extends Thread {
    private HoneyThread beeHoneyThread;

    public Bees(HoneyThread honey) {
        this.beeHoneyThread = honey;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (beeHoneyThread) {
                if (!beeHoneyThread.isFull()) {
                    beeHoneyThread.addPortions();
                    if (beeHoneyThread.isFull()) ;
                    beeHoneyThread.notifyAll();
                }
            }
        }
    }
}
