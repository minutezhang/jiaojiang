package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 22, 2015 12:24:31 AM
 */
public class SingleNumberII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(4, method.invoke(null, new int[]{1, 1, 1, 3, 3, 3, 4}));
            Test.assertEquals(4, method.invoke(null, new int[]{1, 1, 1, 4}));
            Test.assertEquals(-4, method.invoke(null, new int[]{-2, -2, 1, 1, -3, 1, -3, -3, -4, -2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
