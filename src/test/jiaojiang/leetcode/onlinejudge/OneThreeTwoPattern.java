package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OneThreeTwoPattern {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertFalse((boolean) method.invoke(null, new int[]{1, 2, 3, 4}));
            Test.assertTrue((boolean) method.invoke(null, new int[]{3, 1, 4, 2}));
            Test.assertTrue((boolean) method.invoke(null, new int[]{-1, 3, 2, 0}));
            Test.assertFalse((boolean) method.invoke(null, new int[]{1, 0, 1, -4, -3}));
            Test.assertTrue((boolean) method.invoke(null, new int[]{3, 5, 0, 3, 4}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}





