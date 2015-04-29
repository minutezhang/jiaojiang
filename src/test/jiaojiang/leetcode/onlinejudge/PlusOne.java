package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/6/15 5:06 PM
 */
public class PlusOne {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(new int[]{1, 3, 4, 7, 0}, (int[])method.invoke(null, new int[]{1, 3, 4, 6, 9}));
            Test.assertEquals(new int[]{1, 0, 0, 0, 0, 0}, (int[])method.invoke(null, new int[]{9, 9, 9, 9, 9}));
            Test.assertEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}, (int[])method.invoke(null, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
            Test.assertEquals(new int[]{5, 9, 0, 8, 4, 0, 2, 3, 5, 5, 7, 0, 0, 3, 1, 3, 7, 2, 4, 8, 8, 5, 0, 6, 1, 1, 3}, (int[])method.invoke(null, new int[]{5, 9, 0, 8, 4, 0, 2, 3, 5, 5, 7, 0, 0, 3, 1, 3, 7, 2, 4, 8, 8, 5, 0, 6, 1, 1, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
