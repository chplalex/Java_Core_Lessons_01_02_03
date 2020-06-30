package lesson0305;

public abstract class Stage {
    protected int length;
    protected String description;
    private Car winner;

    public String getDescription() {
        return description;
    }

    public Car getWinner() {
        return winner;
    }

    public void doit(Car car) {
        go(car);
        if (winner == null) {
            winner = car;
        }
    }

    protected abstract void go(Car c);
}
