package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 28, 2015 9:27:22 PM
 */
public class JumpGame {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertTrue((Boolean) method.invoke(null, new int[]{2, 3, 1, 1, 4}));
            Test.assertFalse((Boolean) method.invoke(null, new int[]{3, 2, 1, 0, 4}));
            Test.assertTrue((Boolean) method.invoke(null, new int[]{0}));
            Test.assertTrue((Boolean) method.invoke(null, new int[]{1}));

            if (methodName.endsWith("DP")) {
                Test.assertFalse((Boolean) method.invoke(null, new int[]{2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6}));
                Test.assertFalse((Boolean) method.invoke(null, getSampleArray()));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

    private static int[] getSampleArray() {
        int size = 25000;
        int[] ret = new int[size + 3];

        for (int i = 0; i < size; i++) {
            ret[i] = size - i;
        }

        ret[2] = 1;

        return ret;
    }
}
