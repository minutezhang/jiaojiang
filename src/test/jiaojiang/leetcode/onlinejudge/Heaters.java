package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Heaters {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class);
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2, 3}, new int[]{2}));
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2, 3, 4}, new int[]{1, 4}));
            Test.assertEquals(3, method.invoke(null, new int[]{1, 5}, new int[]{2}));
            Test.assertEquals(0, method.invoke(null, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
            Test.assertEquals(0, method.invoke(null, new int[]{1, 2, 3, 4, 5, 2}, new int[]{1, 2, 3, 4, 5, 2}));
            Test.assertEquals(161834419, method.invoke(null,
                            new int[]{282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923},
                            new int[]{823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612}
                    )
            );
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}





