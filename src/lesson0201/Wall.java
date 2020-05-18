package lesson0201;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    void DoIt(Duothlon participant) {
        participant.Jump(height);
    }

    @Override
    void Info() {
        System.out.printf("The wall. Let jump %d meters.\n", height);
    }
}
