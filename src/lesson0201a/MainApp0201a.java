package lesson0201a;

public class MainApp0201a {
    public static void main(String[] args) {
        printInfo(DaysOfWeekInRussia.Monday);
        printInfo(DaysOfWeekInRussia.Tuesday);
        printInfo(DaysOfWeekInRussia.Wednesday);
        printInfo(DaysOfWeekInRussia.Thursday);
        printInfo(DaysOfWeekInRussia.Friday);
        printInfo(DaysOfWeekInRussia.Saturday);
        printInfo(DaysOfWeekInRussia.Sunday);

        System.out.println("");

        printInfo(DaysOfWeekInIsrael.Sunday);
        printInfo(DaysOfWeekInIsrael.Monday);
        printInfo(DaysOfWeekInIsrael.Tuesday);
        printInfo(DaysOfWeekInIsrael.Wednesday);
        printInfo(DaysOfWeekInIsrael.Thursday);
        printInfo(DaysOfWeekInIsrael.Friday);
        printInfo(DaysOfWeekInIsrael.Saturday);
    }

    public static void printInfo(DaysOfWeekInRussia dayOfWeek) {
        System.out.printf("Сегодня в России %s. ", dayOfWeek);
        printWorkingHours(getWorkingHours(dayOfWeek));
    }

    public static void printInfo(DaysOfWeekInIsrael dayOfWeek) {
        System.out.printf("Сегодня в Израиле %s. ", dayOfWeek);
        printWorkingHours(getWorkingHours(dayOfWeek));
    }

    public static int getWorkingHours(DaysOfWeekInRussia dayOfWeek) {
        int daysBetween = DaysOfWeekInRussia.Saturday.compareTo(dayOfWeek);
        if (daysBetween < 1) {
            return 0;
        } else {
            return (daysBetween * 8);
        }
    }

    public static int getWorkingHours(DaysOfWeekInIsrael dayOfWeek) {
        int workingHours = 0;
        for (DaysOfWeekInIsrael day : DaysOfWeekInIsrael.values()) {
            if (day.compareTo(dayOfWeek) < 0) {
                continue;
            }
            workingHours += day.workingHours;
        }
        return workingHours;
    }

    public static void printWorkingHours(int workingHours) {
        if (workingHours == 0) {
            System.out.println("Сегодня выходной");
        } else {
            System.out.printf("До конца рабочей недели осталось %d часов\n", workingHours);
        }
    }
}
