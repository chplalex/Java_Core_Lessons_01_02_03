package lesson0301;

import java.util.ArrayList;

public class App0301 {
    public static void main(String[] args) {
        task01();
        task02();
        task03();
    }

    private static void task01() {
        System.out.println("Задача № 1");

        TestArr<String> arrStr = new TestArr<>(new String[]{"A", "B", "C"});
        arrStr.info();
        arrStr.changeItems(0, 2);
        arrStr.info();

        TestArr<Integer> arrInt = new TestArr<>(new Integer[]{1, 2, 3});
        arrInt.info();
        arrInt.changeItems(0, 2);
        arrInt.info();

        System.out.println("");
    }

    private static void task02() {
        System.out.println("Задача № 2");

        TestArr<Integer> arrInt = new TestArr<>(new Integer[]{1, 2, 3});
        System.out.print("массив = ");
        arrInt.info();
        ArrayList<Integer> listInt = arrInt.getArrayList();
        System.out.println("list   = " + listInt);

        System.out.println("");
    }

    private static void task03() {
        System.out.println("Задача № 3");
        System.out.println("");

        Box boxApple1 = new Box("Apple", 10);
        Box boxApple2 = new Box("Apple", 7);
        Box boxOrange1 = new Box("Orange", 15);
        Box boxOrange2 = new Box("Orange", 9);

        boxApple1.info();
        boxApple2.info();
        boxOrange1.info();
        boxOrange2.info();
        System.out.println("");

        System.out.println("Заполняем первую коробку яблоками:");
        while (boxApple1.add(new Apple())) {
            System.out.printf("Яблоко успешно добавлено. Текущий вес коробки = %.2f\n", boxApple1.getWeight());
        }
        boxApple1.info();

        System.out.println("");

        System.out.printf("Пересыпаем яблоки во вторую коробку. Результат = %b\n", boxApple1.moveTo(boxApple2));
        boxApple1.info();
        boxApple2.info();
        System.out.println("");

        System.out.printf("Пересыпаем яблоки в коробку для апельсинов. Результат = %b\n", boxApple1.moveTo(boxOrange1));
        boxOrange1.info();
        System.out.println("");

        System.out.println("Кладем 5 апельсинов в первую коробку");
        for (int i = 0; i < 5; i++) {
            if (boxOrange1.add(new Orange())) {
                System.out.printf("Апельсин успешно добавлен. Текущий вес коробки = %.2f\n", boxOrange1.getWeight());
            }
        }
        boxOrange1.info();
        System.out.println("");

        System.out.println("Кладем 5 апельсинов во вторую коробку");
        for (int i = 0; i < 5; i++) {
            if (boxOrange2.add(new Orange())) {
                System.out.printf("Апельсин успешно добавлен. Текущий вес коробки = %.2f\n", boxOrange2.getWeight());
            }
        }
        boxOrange2.info();
        System.out.println("");

        System.out.printf("Сравниваем коробки с апельсинами. Результат = %b\n", boxOrange1.compare(boxOrange2));
        System.out.println("");

        System.out.printf("Сравниваем коробку с апельсинами с коробкой с яблоками. Результат = %b\n", boxOrange1.compare(boxApple1));
        System.out.println("");

    }
}