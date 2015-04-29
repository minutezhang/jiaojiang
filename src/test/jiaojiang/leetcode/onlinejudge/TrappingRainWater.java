package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/6/15 1:55 PM
 */
public class TrappingRainWater {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(0, method.invoke(null, new int[0]));
            Test.assertEquals(14, method.invoke(null, new int[]{5, 2, 1, 2, 1, 5}));
            Test.assertEquals(23, method.invoke(null, new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
            Test.assertEquals(6, method.invoke(null, new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
            Test.assertEquals(31, method.invoke(null, new int[]{3, 1, 4, 7, 5, 0, 1, 5, 1, 5, 9, 6, 8, 9, 3, 3, 1}));
            Test.assertEquals(58, method.invoke(null, new int[]{6, 0, 0, 2, 8, 9, 2, 6, 5, 0, 0, 9, 7, 0, 4, 7, 3}));
            Test.assertEquals(83, method.invoke(null, new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1, 3}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
