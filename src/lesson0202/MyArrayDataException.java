package lesson0202;

public class MyArrayDataException extends NumberFormatException {

    private int indexI;
    private int indexJ;
    private String arrElement;

    public MyArrayDataException(int indexI, int indexJ, String arrElement) {
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.arrElement = arrElement;
    }

    public String toString() {
        return String.format("ИСКЛЮЧЕНИЕ. Ошибка преобразования. Элемент массива [%d][%d] не является числом - \"%s\".",
                indexI, indexJ, arrElement);
    }

}
