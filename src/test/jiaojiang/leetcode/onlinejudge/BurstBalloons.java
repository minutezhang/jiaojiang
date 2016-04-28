package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Apr 4, 2016
 */
public class BurstBalloons {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(167, method.invoke(null, new int[]{3, 1, 5, 8}));

            if (!"maxCoins".equals(methodName)) {
                    long time = System.nanoTime();
                    Test.assertEquals(1654, method.invoke(null, new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3}));
                    Utils.printElapsedTime(time, methodName);
                if (!"maxCoins2".equals(methodName)) {
                    time = System.nanoTime();
                    Test.assertEquals(3446, method.invoke(null, new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2}));
                    Utils.printElapsedTime(time, methodName);
                }
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
