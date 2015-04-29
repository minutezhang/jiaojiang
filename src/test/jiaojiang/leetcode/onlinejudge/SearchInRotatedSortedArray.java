package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/6/15 3:55 PM
 */
public class SearchInRotatedSortedArray {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(3, method.invoke(null, new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 7));
            Test.assertEquals(6, method.invoke(null, new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 2));
            Test.assertEquals(0, method.invoke(null, new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 4));
            Test.assertEquals(1, method.invoke(null, new int[]{3, 1}, 1));
            Test.assertEquals(-1, method.invoke(null, new int[]{1}, 2));
            Test.assertEquals(-1, method.invoke(null, new int[]{1, 3}, 0));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
