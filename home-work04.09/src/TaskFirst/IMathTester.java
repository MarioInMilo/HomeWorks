package TaskFirst;

import java.util.Collections;

public class IMathTester implements IMath {

    public static void main(String[] args) {
        ArrayInt arr = new ArrayInt(20);
        IMathTester rt = new IMathTester();
        arr.create(11);
        arr.create(22);
        arr.create(33);
        System.out.println(rt.max(arr));
        System.out.println(rt.min(arr));
        System.out.println(rt.avg(arr));
    }


    @Override
    public int max(ArrayInt array) {
        return Collections.max(array.getArray());
    }

    @Override
    public int min(ArrayInt array) {
        return Collections.min(array.getArray());
    }

    @Override
    public float avg(ArrayInt array) {
        int sum = 0, size = 0;
        for (Integer i :
                array.getArray()) {
            sum += i;
            size++;
        }
        return sum / size;
    }
}
