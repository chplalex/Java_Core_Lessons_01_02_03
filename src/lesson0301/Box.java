package lesson0301;

import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> {
    private String name;
    private float weightMax;
    private ArrayList<T> fruits;

    public Box(String name, float weightMax) {
        this.name = name;
        this.weightMax = weightMax;
        fruits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        float weigth = 0;
        for (T fruit: fruits) {
            weigth += fruit.getWeight();
        }
        return weigth;
    }

    public float getWeightMax() {
        return weightMax;
    }

    public boolean add(T fruit) {
        if (!name.equals(fruit.getName()) || getWeight() + fruit.getWeight() > weightMax) {
            return false;
        }
        fruits.add(fruit);
        return true;
    }

    public boolean moveTo(Box box) {
        if (!name.equals(box.getName())) {
            return false;
        }

        // сортируем список фруктов в убывающем порядке для оптимального заполнения целевой коробки
        // в случае, если фрукты будут иметь разный вес
        Collections.sort(fruits);
        Collections.reverse(fruits);

        ArrayList<T> fruitsForRemove = new ArrayList<>(fruits.size());
        boolean result = true;

        for (T fruit: fruits) {
            if (box.add(fruit)) {
                fruitsForRemove.add(fruit);
            } else {
                result = false;
            }
        }

        for (T fruit: fruitsForRemove) {
            fruits.remove(fruit);
        }

        return result;
    }

    public boolean compare(Box box) {
        return (name.equals(box.getName()) && Math.abs(getWeight() - box.getWeight()) < 0.001f);
    }

    public void info() {
        System.out.printf("Коробка для %s. Максимально допустимый вес = %.2f. Текущий вес коробки = %.2f. \n",
                name, weightMax, getWeight());
    }

}
