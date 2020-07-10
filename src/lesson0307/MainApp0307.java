package lesson0307;

import java.lang.reflect.InvocationTargetException;

public class MainApp0307 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestMaker.start(new MainApp0307());
    }

    public void method01() {
        System.out.println("Вызван метод method01 без аннотации");
    }

    private void method02() {
        System.out.println("Вызван метод method02 без аннотации");
    }

    @TEST (priority = 1)
    public void method03() {
        System.out.println("Вызван метод method03 с аннотацией @TEST P = 1");
    }

    @TEST (priority = 2)
    public void method04() {
        System.out.println("Вызван метод method04 с аннотацией @TEST P = 2");
    }

    @AFTER_SUITE
    public void method05() {
        System.out.println("Вызван метод method05 с аннотацией @AFTER_SUITE");
    }

    @BEFORE_SUITE
    @TEST (priority = 2)
    public void method06() {
        System.out.println("Вызван метод method06 с аннотацией @BEFORE_SUITE и @TEST P = 2");
    }

    @TEST (priority = 3)
    public void method07() {
        System.out.println("Вызван метод method07 с аннотацией @TEST P = 3");
    }

    @TEST (priority = 1)
    public void method08() {
        System.out.println("Вызван метод method08 с аннотацией @TEST P = 1");
    }
}