package lesson0201;

public class Treadmill extends Obstacle {
    int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    void DoIt(Duothlon participant) {
        participant.Run(distance);
    }

    @Override
    void Info() {
        System.out.printf("The threadmill. Let run %d meters.\n", distance);
    }
}
