package lesson0202;

public class MainApp0202 {
    public static void main(String[] args) {
        String[][] arrCorrect = {
                {"01", "02", "03", "04"},
                {"05", "06", "07", "08"},
                {"09", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arrIncorrect = {
                {"01", "02", "03", "04"},
                {"06", "R07", "08"},
                {"09", "10", "11", "12"}
        };

        System.out.println("Пример № 1: Массив \"правильный\".");
        System.out.printf("Сумма корректных элементов массива = %d.\n", sumArray(arrCorrect));

        System.out.println("");

        System.out.println("Пример № 2: Массив \"неправильный\".");
        System.out.printf("Сумма корректных элементов массива = %d.\n", sumArray(arrIncorrect));
    }

    static int sumArray(String[][] arr) {
        int count = 0;
        if (arr.length != 4) {
            try {
                throw new MyArraySizeException(arr.length);
            } catch (MyArraySizeException e) {
                System.out.println(e);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                try {
                    throw new MyArraySizeException(i, arr[i].length);
                } catch (MyArraySizeException e) {
                    System.out.println(e);
                }
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException(i, j, arr[i][j]);
                    } catch (MyArrayDataException exception) {
                        System.out.println(exception);
                    }
                }
            }

        }
        return count;
    }
}
