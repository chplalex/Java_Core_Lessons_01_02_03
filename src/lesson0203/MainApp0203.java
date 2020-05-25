package lesson0203;

import java.util.*;

public class MainApp0203 {
    public static void main(String[] args) {
        String[] furnitureArr = {
                "Стул",
                "Стол",
                "Кровать",
                "Диван",
                "Кресло",
                "Шкаф",
                "Стол",
                "Торшер",
                "Шкаф",
                "Кровать",
                "Комод",
                "Торшер",
                "Стол",
                "Табурет",
                "Тумбочка",
                "Шкаф",
                "Кровать",
                "Стол",
                "Раскладушка",
                "Стол"};
        task011(furnitureArr); // решение с использованием массива и HashSet
        task012(furnitureArr); // решение с использованием сортированного массива и ArraysList
        task02();
    }

    // недостаток решения в избыточности иттераций
    public static void task011(String[] furnitureArr){
        Set<FurnitureEntry> furnitureSet = new HashSet<>();
        for (String s: furnitureArr) {
            furnitureSet.add(new FurnitureEntry(s));
        }
        for (FurnitureEntry furnitureEntry: furnitureSet) {
            for (String s: furnitureArr) {
                if (s.equals(furnitureEntry.getType())) {
                    furnitureEntry.incCount();
                }
            }
        }

        System.out.println("Задача № 1. Решение через массив и HashMap.");
        System.out.printf("Ответ: в списке всего %d предметов %d наименований:\n", furnitureArr.length, furnitureSet.size());
        for (FurnitureEntry furnitureEntry: furnitureSet) {
            System.out.println(furnitureEntry);
        }
        System.out.println("");
    }

    // достоинство решения в одном проходе исходного массива
    // недостаток в применении сортировки - относительно затратно по времени исполнения
    public static void task012(String[] furnitureArr) {
        Arrays.sort(furnitureArr);
        List<FurnitureEntry> furnitureList = new ArrayList<>();
        int count = 0;
        String type = furnitureArr[0];
        for (String s: furnitureArr) {
            if (s.equals(type)) {
                count++;
            } else {
                furnitureList.add(new FurnitureEntry(type, count));
                type = s;
                count = 1;
            }
        }
        furnitureList.add(new FurnitureEntry(type, count));

        System.out.println("Задача № 1. Решение через сортированный массив и ArrayList.");
        System.out.printf("Ответ: в списке всего %d предметов %d наименований:\n", furnitureArr.length, furnitureList.size());
        for (FurnitureEntry entry: furnitureList) {
            System.out.println(entry);
        }
        System.out.println("");
    }

    public static void task02(){

        System.out.println("Задача № 2. Телефонный справочник.");

        String[][] phoneArr = {
                {"Иванов", "+7 (903) 345-73-67"},
                {"Сидоров", "+7 (945) 456-32-72"},
                {"Петров", "+7 (934) 365-95-27"},
                {"Романов", "+7 (945) 789-15-37"},
                {"Иванов", "+7 (985) 258-94-18"},
                {"Васильев", "+7 (934) 458-25-19"},
                {"Романов", "+7 (927) 456-73-18"},
                {"Иванов", "+7 (912) 479-19-28"},
                {"Петров", "+7 (597) 759-82-15"},
                {"Романов", "+7 (927) 198-73-29"},
        };

        PhonesDirectory phonesDirectory = new PhonesDirectory(phoneArr);
        System.out.println(phonesDirectory.getNameInfo("Иванов"));
        System.out.println(phonesDirectory.getNameInfo("Петров"));
        System.out.println(phonesDirectory.getNameInfo("Сидоров"));
        System.out.println(phonesDirectory.getNameInfo("Фёдоров"));
        phonesDirectory.add("Фёдоров", "+7 (957) 597-14-53");
        System.out.println(phonesDirectory.getNameInfo("Фёдоров"));
        phonesDirectory.add("Фёдоров", "+7 (978) 256-74-82");
        System.out.println(phonesDirectory.getNameInfo("Фёдоров"));
        // попытка добавить уже имеющийся в справочнике телефон
        phonesDirectory.add("Фёдоров", "+7 (978) 256-74-82");
        System.out.println(phonesDirectory.getNameInfo("Фёдоров"));

    }
}
