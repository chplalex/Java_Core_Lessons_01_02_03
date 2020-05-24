package lesson0202;

public class MainApp0202 {

    static final int SIZE = 4;

    public static void main(String[] args) {

        String[][] arrCorrect = {
                {"01", "02", "03", "04"},
                {"05", "06", "07", "08"},
                {"09", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrIncorrect1 = {
                {"01", "02", "03", "04"},
                {"06", "R07", "08"},
                {"09", "10", "11", "12"}
        };

        String[][] arrIncorrect2 = {
                {"01", "02", "03", "04"},
                {"06", "R07", "08"},
                {"09", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrIncorrect3 = {
                {"01", "02", "03", "04"},
                {"05", "06", "R07", "08"},
                {"09", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        doIt ("Пример № 1: Массив \"правильный\".", arrCorrect);
        doIt ("Пример № 2: Массив \"неправильный\".", arrIncorrect1);
        doIt ("Пример № 3: Массив \"неправильный\".", arrIncorrect2);
        doIt ("Пример № 4: Массив \"неправильный\".", arrIncorrect3);
    }

    private static void doIt (String msg, String[][] arr) {
        System.out.println(msg);
        try {
            System.out.printf("Сумма элементов массива = %d.\n", sumArray(arr));
        } catch (MyArraySizeException e) {
            System.out.println(e);
        } catch (MyArrayDataException e) {
            System.out.println(e);
        }
        System.out.println("");
    }

    static int sumArray(String[][] arr) throws MyArrayDataException, MyArraySizeException {

        if (arr.length != SIZE) {
            throw new MyArraySizeException(arr.length, -1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != SIZE) {
                throw new MyArraySizeException(i, arr[i].length);
            }
        }

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j]);
                }
            }
        }
        return count;
    }
}
