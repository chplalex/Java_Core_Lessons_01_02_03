package lesson0205;

public class MainApp0205 {
    private static int SIZE = 10000000;
    private static int HALF = SIZE / 2;

    public static void main(String[] args) {

        method1();
        method2();

    }

    public static void initArr(float[] arr) {
        for (float f : arr) {
            f = 1;
        }
    }

    public static void calcArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void method1() {
        float[] arr = new float[SIZE];
        initArr(arr);
        long a = System.currentTimeMillis();
        calcArr(arr);
        long b = System.currentTimeMillis();
        System.out.printf("Method1. Вычисление в 1 потоке.         Время выполнения = %d миллисекунд.\n", (b - a));
    }

    public static void method2() {
        long a, b;
        float[] arr = new float[SIZE];

        initArr(arr);

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];

        a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        b = System.currentTimeMillis();
        System.out.printf("Method2. Копирование arr -> arr1, arr2. Время выполнения = %d миллисекунд.\n", b - a);

        a = System.currentTimeMillis();
        new Thread(() -> calcArr(arr1)).start();
        new Thread(() -> calcArr(arr2)).start();
        b = System.currentTimeMillis();
        System.out.printf("Method2. Вычисление в 2 потоках.        Время выполнения = %d миллисекунд.\n", b - a);

        a = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.printf("Method2. Копирование arr1, arr2 -> arr. Время выполнения = %d миллисекунд.\n", b - a);

    }


}
