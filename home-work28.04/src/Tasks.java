import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Tasks {

    public static void main(String[] args) throws Exception {
//        System.out.println(t1("qwerty", "qwert", "qwer"));
//        System.out.println(t1(1, 4, 9));
//        System.out.println(t1(0.2, 0.9, 300.0));
//        double[] a = {1.0, 2.2, 3.3, 4.3};
//        System.out.println(t2(a));
//        int[] b = {1, 2, 3, 5, 7};
//        System.out.println(t2(b));
//        String[] c = {"qw", "qwert", "qwer"};
//        System.out.println(t2(c));
        ///////
        Matrix<Integer> integerMatrix = new Matrix<>(new Integer[4][4]);
        Matrix<Integer> integerMatrix1 = new Matrix<>(new Integer[4][4]);
        integerMatrix.randomSet();
        integerMatrix1.randomSet();
        integerMatrix.printC();
        System.out.println();
        integerMatrix1.printC();
        integerMatrix.avg();
        integerMatrix.minAndMax();
        System.out.println();
        integerMatrix.compMatrix(integerMatrix1.getValue());

    }

    private static <T> T t1(T first, T two, T three) {
        if (first instanceof Integer) {
            return (T) (Integer) Math.min(Math.min((Integer) first, (Integer) two), (Integer) three);
        } else if (first instanceof Double) {
            return (T) (Double) Math.min(Math.min((Double) first, (Double) two), (Double) three);
        } else if (three instanceof String) {
            Integer a = Math.min(Math.min(first.toString().length(), two.toString().length()), three.toString().length());

            if (first.toString().length() == a) {
                return first;
            } else if (two.toString().length() == a) {
                return two;
            } else {
                return three;
            }

        }
        throw new IllegalArgumentException("Invalid Value");
    }

    private static <T> T t2(T mass) {
        if (mass instanceof int[]) {
            IntStream avg = Arrays.stream((int[]) mass);
            OptionalInt max = avg.max();
            Integer maxi = max.getAsInt();
            return (T) maxi;
        } else if (mass instanceof double[]) {
            DoubleStream avg = Arrays.stream((double[]) mass);
            OptionalDouble max = avg.max();
            Double maxi = max.getAsDouble();
            return (T) maxi;
        } else if (mass instanceof String[]) {
            String[] b = (String[]) mass;
            Optional<String> optional = Arrays.stream(b)
                    .max((o1, o2) -> o1.length() - o2.length());
            String max = optional.toString();
            return (T) max;

        }
        throw new IllegalArgumentException("Invalid Value");
    }


}
