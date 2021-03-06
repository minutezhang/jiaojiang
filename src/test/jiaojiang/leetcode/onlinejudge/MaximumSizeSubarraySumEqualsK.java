package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Sep 5, 2016
 */
public class MaximumSizeSubarraySumEqualsK {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(4, method.invoke(null, new int[]{1, -1, 5, -2, 3}, 3));
            Test.assertEquals(2, method.invoke(null, new int[]{-2, -1, 2, 1}, 1));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
