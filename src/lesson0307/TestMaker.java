package lesson0307;

import java.lang.reflect.Method;

public class TestMaker {
    public static void runTest(Object ob) {
        if (ob == null) {
            return;
        }

        Class cl = ob.getClass();
        Method[] methods = cl.getMethods();
        for (Method m: methods) {
            if (m.getAnnotation(TEST.class) != null) {
                System.out.println(m);
            }
        }


    }
}
