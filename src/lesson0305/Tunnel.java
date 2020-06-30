package lesson0305;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore semaphore;

    public Tunnel() {
        final int MAX_CARS_NUM = 2;
        this.length = 80;
        this.description = "Тоннель " + length + " метров на " + MAX_CARS_NUM + " машины";
        semaphore = new Semaphore(MAX_CARS_NUM, true);
    }
    @Override
    protected void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
