package lesson0301;

public class Fruit implements Comparable {
    private String name;
    private float weight;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        if (!o.getClass().getName().equals(this.getClass().getName())) {
            return 0;
        }

        float weigthObj = ((Fruit) o).getWeight();

        if (Math.abs(weight - weigthObj) < 0.001f) {
            return 0;
        }

        if (weight < weigthObj) {
            return -1;
        } else {
            return 1;
        }
    }
}
