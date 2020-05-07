package lesson0108;

public class Move {
    public int x;
    public int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move() {
        x = 0;
        y = 0;
    }

    public Move(Move move) {
        x = move.x;
        y = move.y;
    }

    public void copyMove(Move sourceMove) {
        x = sourceMove.x;
        y = sourceMove.y;
    }

    public void setMove(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
