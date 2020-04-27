package lesson0107;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dF = 0;

        Cat[] catArr = {
                new Cat("Tom", 5),
                new Cat("Pus", 3),
                new Cat("Ful", 4),
                new Cat("Jey", 5),
                new Cat("Rep", 6),
                new Cat("Hoy", 7),
                new Cat("Ziv", 8),
                new Cat("Liz", 2),
                new Cat("Vau", 9),

        };
        Plate plate = new Plate(45, 50);

        while (true) {

            for (Cat cat : catArr) {
                System.out.println("***");

                cat.info();
                plate.info();

                cat.eat(plate);

                cat.info();
                plate.info();

                System.out.println("***");
            }

            System.out.println("Type number to increase plate or 0 for exit");
            dF = scanner.nextInt();

            if (dF == 0) {
                break;
            }

            if (!plate.increaseFood(dF)) {
                System.out.println("Too much! The food is not changed.");
            }
        }
    }
}
