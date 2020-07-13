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

    @Test(priority = 1)
    public void method03() {
        System.out.println("Вызван метод method03 с аннотацией @Test P = 1");
    }

    @Test(priority = 2)
    public void method04() {
        System.out.println("Вызван метод method04 с аннотацией @Test P = 2");
    }

    @AfterSuite
    public void method05() {
        System.out.println("Вызван метод method05 с аннотацией @AfterSuite");
    }

    @BeforeSuite
    @Test(priority = 2)
    public void method06() {
        System.out.println("Вызван метод method06 с аннотацией @BeforeSuite и @Test P = 2");
    }

    @Test(priority = 3)
    public void method07() {
        System.out.println("Вызван метод method07 с аннотацией @Test P = 3");
    }

    @Test(priority = 1)
    public void method08() {
        System.out.println("Вызван метод method08 с аннотацией @Test P = 1");
    }
}