package lesson0106;

public class Animal {
    private String kind;
    private String name;
    private int age;
    private int runMax;
    private float jumpMax;
    private int swimMax;

    public Animal(String name, int age, int runMax, float jumpMax, int swimMax) {
        this.name = name;
        this.age = age;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
        this.swimMax = swimMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRunMax(int runMax) {
        this.runMax = runMax;
    }

    public void setJumpMax(int jumpMax) {
        this.jumpMax = jumpMax;
    }

    public void setSwimMax(int swimMax) {
        this.swimMax = swimMax;
    }

    public void run (int l) {
        if ((l <= 0) || (runMax < l)) {
            System.out.printf("I can't run %d m.\n", l);
        } else {
            System.out.printf("I have run %d m.\n", l);
        }
    }

    public void jump (int h) {
        if ((h <= 0) || (jumpMax < h)) {
            System.out.printf("I can't jump %d m.\n", h);
        } else {
            System.out.printf("I have jumped %d m.\n", h);
        }
    }

    public void swim (int l) {
        if ((l <= 0) || (swimMax < l)) {
            System.out.printf("I can't swim %d m.\n", l);
        } else {
            System.out.printf("I have swum %d m.\n", l);
        }
    }

    @Override
    public String toString() {
        return ("My name is " + name + ". I am " + age + " years old.");
    }
}