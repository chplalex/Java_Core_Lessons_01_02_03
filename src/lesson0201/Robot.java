package lesson0201;

public class Robot implements Duothlon {

    final int maxDistance = 100000;
    final int maxHeight = 4;
    private String id;
    private boolean onDistance = true;

    public Robot (String id) {
        this.id = id;
    }

    @Override
    public void Jump(int height) {
        if (!onDistance) {
            System.out.println("I am not on distance.");
            return;
        }
        if (maxHeight < height) {
            System.out.printf("I can't jump %d meters.\n", height);
            onDistance = false;
        } else {
            System.out.printf("I've successfully jump %d meters.\n", height);
        }
    }

    @Override
    public void Run(int distance) {
        if (!onDistance) {
            System.out.println("I am not on distance.");
            return;
        }
        if (maxDistance < distance) {
            System.out.printf("I can't run %d meters.\n", distance);
            onDistance = false;
        } else {
            System.out.printf("I've successfully run %d meters.\n", distance);
        }
    }

    @Override
    public void Info() {
        System.out.printf("I am a robot. My ID is %s. I am %s.\n",
                id,
                (onDistance ? "on distance" : "out of distance"));
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }
}
