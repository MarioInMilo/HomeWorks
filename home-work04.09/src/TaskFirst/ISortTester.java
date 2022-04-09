package TaskFirst;

import java.util.Collections;
import java.util.Comparator;

public class ISortTester implements ISort {

    public static void main(String[] args) {
        ArrayInt arr = new ArrayInt(20);
        ISortTester rt = new ISortTester();
        arr.create(11);
        arr.create(22);
        arr.create(33);

        rt.SortAsc(arr);
        rt.SortDesc(arr);

    }

    @Override
    public void SortAsc(ArrayInt array) {
        Collections.sort(array.getArray());
        System.out.println(array);
    }

    @Override
    public void SortDesc(ArrayInt array) {
        Collections.sort(array.getArray(), new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(array);

    }
}
