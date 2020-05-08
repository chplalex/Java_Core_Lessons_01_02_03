package lesson0102;

import java.util.Arrays;
import java.util.Random;

import static java.util.Random.*;

public class MainApp0102 {

    public static void main(String[] args) {
        task01();
        task02();
        task03();
        task04();
        task05();
        task06();
        task07();
    }

    public static void task01() {
        System.out.printf("%nЗадача № 1%n");

        final int count = 10;
        int[] arr;
        arr = new int[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(2);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < count; i++) {
            if (arr[i] == 0) {
                arr[i]++;
            } else {
                arr[i]--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task02() {
        System.out.printf("%nЗадача № 2%n");

        final int count = 8;
        int[] arr;
        arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task03() {
        System.out.printf("%nЗадача № 3%n");

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void task04() {
        System.out.printf("%nЗадача № 4%n");

        final int count = 5;
        int[][] arr = new int[count][count];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if ((i == j) || ((i + j) == (count - 1))) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void task05() {
        System.out.printf("%nЗадача № 5%n");

        final int count = 10, base = 10;
        int count_min = 1, count_max = 1; // количество минимальных и максимальных элементов в массиве
        int item_min = 0, item_max = 0; // значения максимальных и минимальных элементьов в массиве
        int[] arr = new int[count];
        Random random = new Random();

        // заполнение и печать массива
        for (int i = 0; i < count; i++) {
            arr[i] = random.nextInt(10);
            if (i == 0) {
                count_min = 1;
                count_max = 1;
                item_min = arr[i];
                item_max = arr[i];
            } else {

                if (arr[i] == item_min) count_min++;

                if (arr[i] < item_min) {
                    item_min = arr[i];
                    count_min = 1;
                }

                if (arr[i] == item_max) count_max++;

                if (arr[i] > item_max) {
                    item_max = arr[i];
                    count_max = 1;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        System.out.print("Минимальное значение = " + item_min + "; Таких элементов в массиве " + count_min + "; Их номера - ");
        for (int i = 0; i < count; i++) {
            if (arr[i] == item_min) System.out.print(i + "; ");
        }

        System.out.println();

        System.out.print("Максимальное значение = " + item_max + "; Таких элементов в массиве " + count_max + "; Их номера - ");
        for (int i = 0; i < count; i++) {
            if (arr[i] == item_max) System.out.print(i + "; ");
        }

        System.out.println();
    }

    public static void task06() {

        System.out.printf("%nЗадача № 6%n");

        int[] arr1 = {2, 2, 2, 1, 2, 2, 10, 1};
        printBorderPresent(arr1);

        int[] arr2 = {1, 1, 1, 2, 1};
        printBorderPresent(arr2);

        int[] arr3 = {3, 2, 5, 1, 2, 8, 10, 1};
        printBorderPresent(arr3);

    }

    public static void printBorderPresent(int[] arr) {
        String prefix;
        if (borderPresent(arr)) {
            prefix = "";
        } else {
            prefix = "не ";
        }
        System.out.printf("В массиве %s граница %sприсутствует.%n", Arrays.toString(arr), prefix);
    }

    public static boolean borderPresent(int[] arr) {
        int[] arr_left;
        arr_left = new int[arr.length];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr_left[i] = sum;
        }

        sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            if (sum == arr_left[i - 1]) {
                return true;
            } else {
                if (sum > arr_left[i - 1]) {
                    return false;
                }
            }
        }

        return false;
    }

    public static void task07() {
        System.out.printf("%nЗадача № 7%n");

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.printf("%s%n", Arrays.toString(arr));

        shiftArr(arr, 1);
        System.out.printf("%s shift = %d%n", Arrays.toString(arr), 1);

        shiftArr(arr, 2);
        System.out.printf("%s shift = %d%n", Arrays.toString(arr), 2);

        shiftArr(arr, -3);
        System.out.printf("%s shift = %d%n", Arrays.toString(arr), -3);
    }

    public static void shiftArr(int[] arr, int shift) {
        if (shift == 0) {
            return;
        }

        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                shiftArrRigth(arr);
            }
        } else {
            for (int i = 0; i > shift; i--) {
                shiftArrLeft(arr);
            }
        }
    }

    public static void shiftArrRigth(int[] arr) {
        int a = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = a;
    }

    public static void shiftArrLeft(int[] arr) {
        int a = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = a;
    }
}
