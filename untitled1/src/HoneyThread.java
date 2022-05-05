public class HoneyThread {
    private int size, portions;

    public HoneyThread(int size) {
        this.size = size;
    }

    void emptyPot() {
        portions = 0;
        System.out.println(portions);
    }

    void addPortions() {
        portions++;
        System.out.println(portions);
    }

    boolean isFull() {
        return size == portions;
    }
}
