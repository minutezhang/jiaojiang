package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AssignCookies {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class);
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2, 3}, new int[]{1, 1}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 2}, new int[]{1, 2, 3}));
            Test.assertEquals(2, method.invoke(null, new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
