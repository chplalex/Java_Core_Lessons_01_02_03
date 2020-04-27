package lesson0107;

public class Cat {

    private String name;
    private int appetite;
    boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void hungry() {
        satiety = false;
    }

    public void info() {
        if (satiety) {
            System.out.printf("Cat %s: I'm full!\n", name);
        } else {
            System.out.printf("Cat %s: I'm hungry!\n", name);
        }
    }

    public void eat(Plate plate) {
        System.out.println("Cat : I'm eatting. My appetite is " + appetite);
        satiety = plate.decreaseFood(appetite);
    }
}
