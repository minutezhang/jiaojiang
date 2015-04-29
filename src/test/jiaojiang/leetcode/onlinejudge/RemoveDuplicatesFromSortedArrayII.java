package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 10:43 AM
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            int[] A = new int[]{1, 1, 1, 2, 2, 3};
            int[] expected = new int[]{1, 1, 2, 2, 3};
            int length = (Integer) method.invoke(null, A);
            Test.assertEquals(length, 5);
            Test.assertEquals(A, expected, 5);

            A = new int[]{1};
            length = (Integer) method.invoke(null, A);
            Test.assertEquals(length, 1);
            Test.assertEquals(A, new int[]{1}, 1);

            A = new int[0];
            length = (Integer) method.invoke(null, A);
            Test.assertEquals(length, 0);
            Test.assertEquals(A, new int[0], 0);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
