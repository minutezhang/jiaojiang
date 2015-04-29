package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/6/15 11:22 AM
 */
public class ContainerWithMostWater {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(1, method.invoke(null, new int[]{1, 1}));
            Test.assertEquals(0, method.invoke(null, new int[]{0, 2}));
            Test.assertEquals(20, method.invoke(null, new int[]{3, 5, 3, 4, 6, 8}));
            Test.assertEquals(36, method.invoke(null, new int[]{2, 3, 10, 5, 7, 8, 9}));
            Test.assertEquals(25, method.invoke(null, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
            Test.assertEquals(96, method.invoke(null, new int[]{10, 14, 10, 4, 10, 2, 6, 1, 6, 12}));
            Test.assertEquals(18048, method.invoke(null, new int[]{76, 155, 15, 188, 180, 154, 84, 34, 187, 142, 22, 5, 27, 183, 111, 128, 50, 58, 2, 112, 179, 2, 100, 111, 115, 76, 134, 120, 118, 103, 31, 146, 58, 198, 134, 38, 104, 170, 25, 92, 112, 199, 49, 140, 135, 160, 20, 185, 171, 23, 98, 150, 177, 198, 61, 92, 26, 147, 164, 144, 51, 196, 42, 109, 194, 177, 100, 99, 99, 125, 143, 12, 76, 192, 152, 11, 152, 124, 197, 123, 147, 95, 73, 124, 45, 86, 168, 24, 34, 133, 120, 85, 81, 163, 146, 75, 92, 198, 126, 191}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
