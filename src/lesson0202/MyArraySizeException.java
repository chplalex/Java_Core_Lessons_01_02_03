package lesson0202;

public class MyArraySizeException extends Exception {
    private int lengthI;
    private int lengthJ;
    private int indexI;

    public MyArraySizeException(int lengthI) {
        this.lengthI = lengthI;
        this.lengthJ = -1;
        this.indexI  = -1;
    }

    public MyArraySizeException(int indexI, int lengthJ) {
        this.lengthI = -1;
        this.lengthJ = lengthJ;
        this.indexI  = indexI;
    }

    @Override
    public String toString() {
        if (lengthI == -1) {
            return String.format("ИСКЛЮЧЕНИЕ. Неккорректный размер массива. Строка %d соддержит %d значений (должно быть 4)",
                    indexI, lengthJ);
        } else {
            return String.format("ИСКЛЮЧЕНИЕ. Неккорректный размер массива. Колличество строк %d (должно быть 4)",
                    lengthI);
        }
    }
}
