package lesson0103;

import java.util.Random;
import java.util.Scanner;

public class MainApp0103 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task01();
        task02();
    }

    public static void task01() {
        System.out.printf("%nЗадача № 1. Игра \"Угадай число!\"%n");

        Random random = new Random();

        int a = random.nextInt(10);
        int b = 0;
        final int iMax = 2;

        System.out.println("Я загадала число. Попробуй угадать. У тебя 3 попытки.");

        for (int i = 0; i <= iMax; i++) {

            System.out.printf("Попытка № %d. Введите число: ", i + 1);
            b = scanner.nextInt();

            if (a == b) {
                System.out.println("Ты угадал! Молодец!");
                break;
            }

            if (a < b) {
                System.out.println("Ты не угадал! Моё число меньше твоего!");
            } else {
                System.out.println("Ты не угадал! Моё число больше твоего!");
            }

            if (i == iMax) {
                System.out.printf("Я загадала число %d. А ты - лузер!%n", a);
            }
        }
    }

    public static void task02() {

        System.out.printf("%nЗадача № 2. Игра \"Угадай слово!\" (подсказка - слово на русском языке, фрукт или ягода)%n");

        Scanner scanner = new Scanner(System.in);
        String[] arr = {
                "яблоко",
                "вишня",
                "дыня",
                "арбуз",
                "виноград",
                "слива",
                "абрикос",
                "груша",
                "ежевика",
                "персик",
                "банан",
                "апельсин",
                "мандарин",
                "малина",
                "крыжовник",
                "голубика",
                "клубника",
                "черешня"
        };

        Random random = new Random();
        String strMine = new String();
        strMine = arr[random.nextInt(arr.length)];
        char[] charArrMine = strMine.toCharArray();

        System.out.printf("***Подсказка для проверяющего: я загадала слово \"%s\"***%n", strMine);

        int count = 1;
        String strYour = new String();
        char[] charArrYour;

        do {

            char[] charArrMask = {'*', '*', '*', '*', '*',
                    '*', '*', '*', '*', '*',
                    '*', '*', '*', '*', '*'};

            System.out.printf("Попытка № %d.Введи слово и нажмите Enter: ", count);
            strYour = scanner.nextLine();
            charArrYour = strYour.toCharArray();

            if (charArrYour.length > charArrMask.length) {
                System.out.printf("Вы загадали слишком длинное слово. Прошу не более %d букв!%n", charArrMask.length);
                count++;
                continue;
            }

            if (strMine.equals(strYour)) {
                System.out.println("Ты угадал! Молодец!");
                break;
            }

            int iMax;

            if (charArrYour.length < charArrMine.length) {
                iMax = charArrYour.length - 1;
            } else {
                iMax = charArrMine.length - 1;
            }

            for (int i = 0; i < iMax; i++) {

                if (charArrMine[i] == charArrYour[i]) {
                    charArrMask[i] = charArrMine[i];
                }

            }

            String strMask = new String(charArrMask);
            System.out.printf("Пока что так: %s. Сделайте следующую попытку.%n", strMask);

            count++;
        } while (true);
    }

}
