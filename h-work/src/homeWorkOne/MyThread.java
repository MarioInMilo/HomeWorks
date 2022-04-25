package homeWorkOne;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class MyThread extends Thread {
    private int[] array;
    private int size;

    public MyThread(int[] array) {
        this.array = array;
    }

    public MyThread(int size) {
        this.size = size;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("GENERATE")) {
            randomGenerateArray();
        } else if (Thread.currentThread().getName().equals("AVG")) {
            System.out.println(getAvg());
        } else if (Thread.currentThread().getName().equals("SUM")) {
            System.out.println(getSum());
        }
    }

    private int getSum() {
        return Arrays.stream(array)
                .sum();
    }

    private double getAvg() {
        return Arrays.stream(array)
                .average()
                .getAsDouble();
    }


    private void randomGenerateArray() {
        this.array = new int[this.size];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = (int) (Math.random() * 10) + 1;
        }
    }


}
