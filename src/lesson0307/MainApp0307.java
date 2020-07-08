package lesson0307;

public class MainApp0307 {
    public static void main(String[] args) {
        TestMaker.runTest(new MainApp0307());
    }

    public void method01() {
        System.out.println("Вызван метод method01 без аннотации");
    }

    private void method02() {
        System.out.println("Вызван метод method02 без аннотации");
    }

    @TEST
    public void method03() {
        System.out.println("Вызван метод method03 с аннотацией @TEST");
    }

    @TEST
    public void method04() {
        System.out.println("Вызван метод method04 с аннотацией @TEST");
    }

    @AFTER_SUITE
    public void method05() {
        System.out.println("Вызван метод method05 с аннотацией @AFTER_SUITE");
    }

    @BEFORE_SUITE
    public void method06() {
        System.out.println("Вызван метод method06 с аннотацией @BEFORE_SUITE");
    }

}
