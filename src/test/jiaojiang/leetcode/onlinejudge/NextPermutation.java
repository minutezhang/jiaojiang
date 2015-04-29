package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/6/15 3:30 PM
 */
public class NextPermutation {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            int[] permutation = new int[]{1, 2, 3};
            method.invoke(null, permutation);
            int[] expected = new int[]{1, 3, 2};
            Test.assertEquals(expected, permutation);

            permutation = new int[]{3, 2, 1};
            method.invoke(null, permutation);
            expected = new int[]{1, 2, 3};
            Test.assertEquals(expected, permutation);

            permutation = new int[]{1, 1, 5};
            method.invoke(null, permutation);
            expected = new int[]{1, 5, 1};
            Test.assertEquals(expected, permutation);

            permutation = new int[]{1, 4, 8, 7, 5, 2};
            method.invoke(null, permutation);
            expected = new int[]{1, 5, 2, 4, 7, 8};
            Test.assertEquals(expected, permutation);

            permutation = new int[]{6, 0, 6, 2, 6, 1, 8, 7, 9, 2, 0, 2, 3};
            method.invoke(null, permutation);
            expected = new int[]{6, 0, 6, 2, 6, 1, 8, 7, 9, 2, 0, 3, 2};

            permutation = new int[]{11, 7, 14, 13, 1, 14, 6, 9, 4, 22, 22, 26, 14, 1, 12, 18, 18, 19, 22, 18, 18, 18, 6, 18, 13, 8, 3, 13, 13, 8, 0, 24, 7, 6, 8, 9, 20, 6, 18, 17, 29, 10, 13, 13, 3, 17, 23, 22, 6, 15, 2, 16, 25, 8, 27};
            method.invoke(null, permutation);
            expected = new int[]{11, 7, 14, 13, 1, 14, 6, 9, 4, 22, 22, 26, 14, 1, 12, 18, 18, 19, 22, 18, 18, 18, 6, 18, 13, 8, 3, 13, 13, 8, 0, 24, 7, 6, 8, 9, 20, 6, 18, 17, 29, 10, 13, 13, 3, 17, 23, 22, 6, 15, 2, 16, 25, 27, 8};
            Test.assertEquals(expected, permutation);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
