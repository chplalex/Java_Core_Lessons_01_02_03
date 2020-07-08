package lesson0205;

public class MainApp0205 {
    private static int SIZE = 10000000;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("START");

        method(1);

        int count = Runtime.getRuntime().availableProcessors();
        System.out.printf("\nВ системе обнаружено процессоров = %d.\n\n", count);

        method(count);

        System.out.println("END");

    }

    public static void method(int thrdCount) throws InterruptedException {
        ArrThread[] arr = new ArrThread[thrdCount];
        int arrSize = SIZE % thrdCount;
        int arrDiff = 0;

        for (int i = 0; i < thrdCount; i++) {
            arrSize += SIZE / thrdCount;
            arr[i] = new ArrThread(arrSize, arrDiff);
            arrDiff += arrSize;
            arrSize = 0;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < thrdCount; i++) {
            arr[i].start();
        }
        for (int i = 0; i < thrdCount; i++) {
            arr[i].join();
        }
        long b = System.currentTimeMillis();
        System.out.printf("Число потоков  = %d. Время вычислений = %d миллисекунд.\n", thrdCount, b - a);

        a = System.currentTimeMillis();
        for (int i = 1; i < thrdCount; i++) {
            arr[0].addArr(arr[i].getArr());
        }
        b = System.currentTimeMillis();
        System.out.printf("Число массивов = %d. Время склейки    = %d миллисекунд.\n", thrdCount, b - a);
    }

}
