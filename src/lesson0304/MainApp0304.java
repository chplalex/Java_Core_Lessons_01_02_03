package lesson0304;

public class MainApp0304 {
    private final Object monitor = new Object();
    private volatile char waitingChar = 'A';
    private volatile int count = 5;

    public static void main(String[] args) {
        MainApp0304 mainApp = new MainApp0304();

        new Thread(() -> {
            mainApp.printChar('A', 'B', false);
        }).start();

        new Thread(() -> {
            mainApp.printChar('B', 'C', false);
        }).start();

        new Thread(() -> {
            mainApp.printChar('C', 'A', true);
        }).start();
    }

    private void printChar(char presentChar, char nextChar, boolean countIncrement) {
        System.out.printf("print '%s' start%s", presentChar, System.lineSeparator());
        synchronized (monitor) {
            while (true) {
                try {
                    monitor.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 0) {
                    break;
                }
                if (waitingChar == presentChar) {
                    System.out.print(presentChar);
                    waitingChar = nextChar;
                    if (countIncrement) {
                        count--;
                        System.out.println("");
                    }
                }
                monitor.notifyAll();
            }
        }
    }

}
