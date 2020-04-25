package lesson0101;

public class MainApp0101 {

    public static void main(String[] args) {

        byte dataBy = 0;
        short dataS = 0;
        int dataI = 0;
        long dataL = 0L;

        float dataF = 0.0f;
        double dataD = 0.0;

        char dataC = 'Ю';
        boolean dataBo = true;

        dataF = calculate(3, 4, 5, 6);

        dataBo = isInRange(3, 5);
        dataBo = isInRange(6, 8);
        dataBo = isInRange(13, 15);

        printKindOfNumber(-5);
        printKindOfNumber(0);
        printKindOfNumber(5);

        dataBo = isNegative(-5);
        dataBo = isNegative(0);
        dataBo = isNegative(5);

        printName("Василий");

        printYearLeap(1200);
        printYearLeap(1300);
        printYearLeap(1304);
        printYearLeap(1307);

    }

    public static float calculate(int a, int b, int c, int d) {
        return (a * (b + (c / d)));
    }

    public static boolean isInRange(int a, int b) {
        int c = a + b;
        if ((10 < c) && (c <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void printKindOfNumber(int a) {
        if (a < 0) {
            System.out.println("Число " + a + " отрицательное");
        } else {
            System.out.println("Число " + a + " положительное или ноль");
        }

    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    //использовать printf
    public static void printName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //сделать метод возвращающий boolean, а печать отдедьнно
    public static void printYearLeap(int year) {
        boolean isLeap;
        if ((year % 400) == 0) {
            isLeap = true;
        } else if ((year % 100) == 0) {
            isLeap = false;
        } else if ((year % 4) == 0) {
            isLeap = true;
        } else {
            isLeap = false;
        }

//использовать printf и выводить префикс NOT или пусто в зависимости от результата
        if (isLeap) {
            System.out.println("Year " + year + " is LEAP!");
        } else {
            System.out.println("Year " + year + " is NOT leap!");
        }
    }
}
