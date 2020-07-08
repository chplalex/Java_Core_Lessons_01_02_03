package lesson0305;

import java.util.concurrent.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier startGun;
    private CountDownLatch finishFlag;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier startGun, CountDownLatch finishFlag) {
        this.race = race;
        this.speed = speed;
        this.startGun = startGun;
        this.finishFlag = finishFlag;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " готовится...");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(name + " готов!");
            startGun.await();
            System.out.println(name + " стартовал!");
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println("Фальшстарт! " + name + " выбыл из гонки.");
            return;
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).doit(this);
        }
        finishFlag.countDown();
        System.out.println(name + " гонку закончил.");
    }
}