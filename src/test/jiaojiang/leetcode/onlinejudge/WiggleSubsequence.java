package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Aug 11, 2016
 */
public class WiggleSubsequence {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(6, method.invoke(null, new int[]{1, 7, 4, 9, 2, 5}));
            Test.assertEquals(7, method.invoke(null, new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
