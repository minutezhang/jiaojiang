package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThirdMaximumNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2, 2, 4}));
            Test.assertEquals(1, method.invoke(null, new int[]{1, 1}));
            Test.assertEquals(1, method.invoke(null, new int[]{3, 2, 1}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 2}));
            Test.assertEquals(-2147483648, method.invoke(null, new int[]{1, 2, -2147483648}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
