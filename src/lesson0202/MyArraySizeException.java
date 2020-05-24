package lesson0202;

import static lesson0202.MainApp0202.SIZE;

public class MyArraySizeException extends RuntimeException {
    private int row;
    private int col;

    public MyArraySizeException(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        if (col == -1) {
            return String.format("ИСКЛЮЧЕНИЕ. Неккорректный размер массива. Колличество строк %d (должно быть %d).",
                    row, SIZE);
        } else {
            return String.format("ИСКЛЮЧЕНИЕ. Неккорректный размер массива. Строка %d соддержит %d значений (должно быть %d).",
                    row, col, SIZE);
        }
    }
}
