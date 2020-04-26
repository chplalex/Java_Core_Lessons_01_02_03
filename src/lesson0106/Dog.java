package lesson0106;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age, 500, (float) 0.5, 10);
    }

    @Override
    public String toString() {
        return "I am a dog. " + super.toString();
    }
}
