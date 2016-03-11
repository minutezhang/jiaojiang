package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 9, 2016
 */
public class MinimumSizeSubarraySum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[].class);
            Test.assertEquals(0, method.invoke(null, 11, new int[0]));
            Test.assertEquals(2, method.invoke(null, 7, new int[]{2, 3, 1, 2, 4, 3}));
            Test.assertEquals(3, method.invoke(null, 11, new int[]{1, 2, 3, 4, 5}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
