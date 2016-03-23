package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 15, 2016
 */
public class SlidingWindowMaximum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(new int[]{3, 3, 5, 5, 6, 7}, (int[])method.invoke(null, new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
            Test.assertEquals(new int[0], (int[])method.invoke(null, new int[0], 0));
            Test.assertEquals(new int[]{1, -1}, (int[])method.invoke(null, new int[]{1, -1}, 1));
            Test.assertEquals(new int[]{7, 4}, (int[])method.invoke(null, new int[]{7, 2, 4}, 2));
            Test.assertEquals(new int[]{3, 3, 2, 5}, (int[])method.invoke(null, new int[]{1, 3, 1, 2, 0, 5}, 3));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
