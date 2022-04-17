package lesson06;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkWithMassive {
    private static final Logger logger = Logger.getLogger(WorkWithMassive.class.getName());
// Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
// Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
// идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
// необходимо выбросить RuntimeException.

    public static int[] doRevertMassive(int[] preMassive) {
        if (preMassive.length == 0) {
            throw new NullPointerException("Пустой массив");
        }
        int lastIndexOf4 = -1;
        for (int i = 0; i < preMassive.length; i++)
            if (preMassive[i] == 4) lastIndexOf4 = i + 1;

        if (lastIndexOf4 == -1) throw new RuntimeException("Массив без 4");
        else return Arrays.copyOfRange(preMassive, lastIndexOf4, preMassive.length);
    }

    // Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы, то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//[ 1 1 1 4 4 1 4 4 ] -> true
//[ 1 1 1 1 1 1 ] -> false
//[ 4 4 4 4 ] -> false
//[ 1 4 4 1 1 4 3 ] -> false
    public static boolean checkArrayFor1And4(int[] arr) {
        int count1 = 0, count4 = 0;
        for (int element : arr) {
            if (element == 1) count1++;
            else if (element == 4) count4++;
        }
        return (count1 > 0 && count4 > 0 && count1 + count4 == arr.length);
    }

    public static void main(String[] args) {
        int[] massive = {1, 4, 1, 4};
        System.out.println(Arrays.toString(doRevertMassive(massive)));

        System.out.println(checkArrayFor1And4(massive));

        logger.log(Level.INFO, "Java core");
    }
}
