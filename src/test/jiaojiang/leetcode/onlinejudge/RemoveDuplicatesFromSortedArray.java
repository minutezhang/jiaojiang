package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 10:43 AM
 */
public class RemoveDuplicatesFromSortedArray {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            int[] A = new int[]{1, 1, 1, 2, 2, 3};
            int[] expected = new int[]{1, 2, 3};
            method.invoke(null, A);
            Test.assertEquals(expected, A, 3);

            A = new int[]{1};
            method.invoke(null, A);
            Test.assertEquals(new int[]{1}, A, 1);

            A = new int[0];
            method.invoke(null, A);
            Test.assertEquals(new int[0], A, 0);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
