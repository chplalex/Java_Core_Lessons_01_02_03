package lesson0106;

import java.util.Random;
import java.util.Scanner;

public class MainApp0106 {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static Animal[] arrAnimals = new Animal[]{
            new Cat("Tom", 3),
            new Cat("Freddy", 2),
            new Dog("Mikl", 3),
            new DogRun400("Paul", 3),
            new DogRun600("Sam", 5),
            new Cat("Percy", 4),
            new Dog("Andy", 2)
    };

    public static void main(String[] args) {

        animalsPrintInfo();
        animalsJump();
        animalsRun();
        animalsSwim();

    }

    private static void animalsPrintInfo() {
        int countDogs = 0;
        int countCats = 0;

        System.out.println("List of animals:");
        for (Animal a : arrAnimals) {
            if (a instanceof Dog) {
                countDogs++;
            } else if (a instanceof Cat) {
                countCats++;
            }
            System.out.println(a.toString());
        }
        System.out.printf("\nThere are %d cats and %d dogs in the list.\n", countCats, countDogs);
    }

    private static void animalsJump() {
        System.out.printf("\nLet's jump! Press <enter> for jumping.\n");

        do {
            scanner.nextLine();

            int i = random.nextInt(arrAnimals.length);
            int jumpHeight = random.nextInt(4);

            System.out.println(arrAnimals[i].toString());

            System.out.printf("I try to jump %d meters. Press <enter>.", jumpHeight);
            scanner.nextLine();

            arrAnimals[i].jump(jumpHeight);
            System.out.println("Press 1 for continue or any digit + <enter> for exit.");
        } while (scanner.nextInt() == 1);

        scanner.nextLine();
    }

    private static void animalsRun() {
        System.out.printf("\nLet's run! Press <enter> for running.\n");

        do {
            scanner.nextLine();

            int i = random.nextInt(arrAnimals.length);
            int runLength = random.nextInt(8) * 100;

            System.out.println(arrAnimals[i].toString());

            System.out.printf("I try to run %d meters. Press <enter>.", runLength);
            scanner.nextLine();

            arrAnimals[i].run(runLength);
            System.out.println("Press 1 for continue or any digit + <enter> for exit.");
        } while (scanner.nextInt() == 1);

        scanner.nextLine();
    }

    private static void animalsSwim() {
        System.out.printf("\nLet's swim! Press <enter> for swimming.\n");

        do {
            scanner.nextLine();

            int i = random.nextInt(arrAnimals.length);
            int swimLength = random.nextInt(3) * 10;

            System.out.println(arrAnimals[i].toString());

            System.out.printf("I try to swim %d meters. Press <enter>.", swimLength);
            scanner.nextLine();

            arrAnimals[i].swim(swimLength);
            System.out.println("Press 1 for continue or any digit + <enter> for exit.");
        } while (scanner.nextInt() == 1);

        scanner.nextLine();
    }
}
