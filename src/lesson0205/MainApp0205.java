package lesson0205;

public class MainApp0205 {
    private static int SIZE = 10000000;
    private static int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("START");
        method1();
        method2();
        System.out.println("END");

    }

    public static void method1() throws InterruptedException {
        ArrThread arrThread = new ArrThread(SIZE, 0);
        long a = System.currentTimeMillis();
        arrThread.start();
        arrThread.join();
        long b = System.currentTimeMillis();
        System.out.printf("Method1. Вычисление в 1 потоке.  Время выполнения = %d миллисекунд.\n", (b - a));
    }

    public static void method2() throws InterruptedException {
        ArrThread arrThread1 = new ArrThread(HALF, 0);
        ArrThread arrThread2 = new ArrThread(HALF, HALF);

        long a = System.currentTimeMillis();
        arrThread1.start();
        arrThread2.start();
        arrThread1.join();
        arrThread2.join();
        arrThread1.addArr(arrThread2.getArr());
        long b = System.currentTimeMillis();
        System.out.printf("Method2. Вычисление в 2 потоках. Время выполнения = %d миллисекунд.\n", b - a);
    }

}
