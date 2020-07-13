package lesson0307;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestMaker {
    public static void start(Object ob) throws InvocationTargetException, IllegalAccessException {
        if (ob == null) {
            return;
        }
        System.out.println("Тестируются методы класса " + ob.getClass().getName() +
                ", имеющие аннотации @BeforeSuite, @Test и @AfterSuite");
        Method[] methods = ob.getClass().getDeclaredMethods();
        Method bsMethod = null;
        Method asMethod = null;
        List<Method> methodsForTesting = new ArrayList<>();
        for (Method m: methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (bsMethod != null) {
                    throw new RuntimeException(
                            String.format("Ошибка аннотирования метода %s. " +
                                            "В классе аннотация @BeforeSuite допускается в единственном числе.",
                                    m.getName()));
                }
                bsMethod = m;
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (asMethod != null) {
                    throw new RuntimeException(
                            String.format("Ошибка аннотирования метода %s. " +
                                            "В классе аннотация @AfterSuite допускается в единственном числе.",
                                    m.getName()));
                }
                asMethod = m;
            }
            if (m.getAnnotation(Test.class) != null) {
                methodsForTesting.add(m);
            }
        }
        if (methodsForTesting.size() > 0) {
            methodsForTesting.sort(Comparator.comparingInt((Method m) -> m.getAnnotation(Test.class).priority()));
            Collections.reverse(methodsForTesting);
        }
        if (bsMethod != null) {
            methodsForTesting.add(0, bsMethod);
        }
        if (asMethod != null) {
            methodsForTesting.add(asMethod);
        }
        for (Method m: methodsForTesting) {
            m.invoke(ob);
        }
    }
}
