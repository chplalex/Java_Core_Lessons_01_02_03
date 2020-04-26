package lesson0106;

public class Cat extends Animal{

    public Cat(String name, int age) {
        super (name, age, 200, 2, 0);
    }

    @Override
    public String toString() {
        return "I am a cat. " + super.toString();
    }
}
