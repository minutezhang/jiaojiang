package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/27/15 6:48 PM
 */
public class SortColors {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            int[] colors = new int[]{2, 0, 2};
            int[] expected = new int[]{0, 2, 2};
            method.invoke(null, colors);
            Test.assertEquals(expected, colors);

            colors = new int[]{2, 0, 0};
            expected = new int[]{0, 0, 2};
            method.invoke(null, colors);
            Test.assertEquals(expected, colors);

            colors = new int[]{1, 0, 0};
            expected = new int[]{0, 0, 1};
            method.invoke(null, colors);
            Test.assertEquals(expected, colors);

            colors = new int[]{2, 0, 1};
            expected = new int[]{0, 1, 2};
            method.invoke(null, colors);
            Test.assertEquals(expected, colors);

            colors = new int[]{2, 0, 1, 2, 1, 1, 0};
            expected = new int[]{0, 0, 1, 1, 1, 2, 2};
            method.invoke(null, colors);
            Test.assertEquals(expected, colors);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
