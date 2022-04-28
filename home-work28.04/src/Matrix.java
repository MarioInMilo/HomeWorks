import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Matrix<T> {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private T[][] value;
    private T[][] op;

    public Matrix(T[][] value) {
        this.value = value;
    }

    public T[][] getValue() {
        return value;
    }

    public void setValue(T[][] value) {
        this.value = value;
    }


    public void set() throws IOException {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                if (value instanceof Integer[][]) {
                    value[i][j] = (T) (Integer) Integer.parseInt(reader.readLine());
                } else if (value instanceof Double[][]) {
                    value[i][j] = (T) (Double) Double.parseDouble(reader.readLine());
                }
            }
        }
    }

    public void randomSet() {
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                if (value instanceof Double[][]) {
                    value[i][j] = (T) (Double) (Math.random() * 100);
                } else if (value instanceof Integer[][]) {
                    int a = (int) (Math.random() * 100);
                    value[i][j] = (T) (Integer) a;
                }
            }
        }
        //  printC(value);
    }

    //    public void sum(T[][] otherMatrix) {
//        T[][] summa = this.value.clone();
//        T[][] summas;
//        for (int basicMatrix = 0, alienMatrix = 0; basicMatrix < value.length || alienMatrix < otherMatrix.length; basicMatrix++, alienMatrix++) {
//            for (int basicMatrixSecond = 0, alienMatrixSecond = 0; basicMatrixSecond < value[basicMatrix].length
//                    || alienMatrixSecond < otherMatrix[alienMatrix].length; basicMatrixSecond++, alienMatrixSecond++) {
//                if (value instanceof Integer[][]) {
//                    int tempSumInt = (Integer) value[alienMatrix][alienMatrixSecond] + (Integer) otherMatrix[basicMatrix][basicMatrixSecond];
//                    summa[basicMatrix][basicMatrixSecond] = (T) (Integer) tempSumInt;
//                    summas[1][1] =
//                    summas[1][1] = (T)(Integer) 1;
//                }
//            }
//        }
//    }
    public void compMatrix(T[][] otherMatrix) {
        boolean checkInstance = value instanceof Integer[][];
        T[][] summa = (T[][]) new Object[value.length][value[0].length];
        T[][] minus = (T[][]) new Object[value.length][value[0].length];
        T[][] multi = (T[][]) new Object[value.length][value[0].length];
        int tempSumInt, tempMinusInt, tempMultInt;
        for (int basicMatrix = 0, alienMatrix = 0; basicMatrix < value.length || alienMatrix < otherMatrix.length; basicMatrix++, alienMatrix++) {
            for (int basicMatrixSecond = 0, alienMatrixSecond = 0; basicMatrixSecond < value[basicMatrix].length
                    || alienMatrixSecond < otherMatrix[alienMatrix].length; basicMatrixSecond++, alienMatrixSecond++) {
                if (checkInstance) {
                    tempSumInt = (Integer) value[alienMatrix][alienMatrixSecond] + (Integer) otherMatrix[basicMatrix][basicMatrixSecond];
                    summa[basicMatrix][basicMatrixSecond] = (T) (Integer) tempSumInt;
                    tempMinusInt = (Integer) value[alienMatrix][alienMatrixSecond] - (Integer) otherMatrix[basicMatrix][basicMatrixSecond];
                    minus[basicMatrix][basicMatrixSecond] = (T) (Integer) tempMinusInt;
                    tempMultInt = (Integer) value[alienMatrix][alienMatrixSecond] * (Integer) otherMatrix[basicMatrix][basicMatrixSecond];
                    multi[basicMatrix][basicMatrixSecond] = (T) (Integer) tempMultInt;
                } else {
                    double tempSumDouble = (Double) value[alienMatrix][alienMatrixSecond] + (Double) otherMatrix[basicMatrix][basicMatrixSecond];
                    summa[basicMatrix][basicMatrixSecond] = (T) (Double) tempSumDouble;
                    double tempMinusDouble = (Double) value[alienMatrix][alienMatrixSecond] - (Double) otherMatrix[basicMatrix][basicMatrixSecond];
                    summa[basicMatrix][basicMatrixSecond] = (T) (Double) tempMinusDouble;
                    double tempMultDouble = (Double) value[alienMatrix][alienMatrixSecond] * (Double) otherMatrix[basicMatrix][basicMatrixSecond];
                    multi[basicMatrix][basicMatrixSecond] = (T) (Double) tempMultDouble;
                }
            }

        }

        System.out.println("          SUM:");
        printC(summa);
        System.out.println("          MINUS:");
        printC(minus);
        System.out.println("          MULT:");
        printC(multi);

    }

    public void minAndMax() {
        if (value instanceof Integer[][]) {
            int maxResultInt = Integer.MIN_VALUE, minResultInt = Integer.MAX_VALUE;
            for (T[] ts : value) {
                for (T t : ts) {
                    if ((Integer) t > maxResultInt) {
                        maxResultInt = (Integer) t;
                    }
                    if ((Integer) t < minResultInt) {
                        minResultInt = (Integer) t;
                    }
                }
            }
            System.out.printf("MAX - %d | MIN - %d%n", maxResultInt, minResultInt);

        } else if (value instanceof Double[][]) {
            double maxResultDouble = Double.MIN_VALUE, minResultDouble = Double.MAX_VALUE;
            for (T[] ts : value) {
                for (T t : ts) {
                    if ((Double) t > maxResultDouble) {
                        maxResultDouble = (Double) t;
                    }
                    if ((Double) t < minResultDouble) {
                        minResultDouble = (Double) t;
                    }
                }
            }
        }
    }

    public void avg() {
        int len = 0;
        int sum = 0;

        boolean mat = value instanceof Integer[][];
        for (T[] ts : value) {
            len += ts.length;
        }
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                if (mat) {
                    sum += (Integer) value[i][j];
                } else {
                    sum += (Double) value[i][j];
                }
            }
        }
        System.out.printf("AVG - %d%n", sum / len);


    }

    public void printC(T[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.printf("[%-4d] ", mass[i][j]);
            }
            System.out.println();
        }
    }

    public void printC() {
        printC(getValue());
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
