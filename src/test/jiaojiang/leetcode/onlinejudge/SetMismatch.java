package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SetMismatch {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(new int[]{2, 3}, (int[])method.invoke(null, new int[]{1, 2, 2, 4}));
            Test.assertEquals(new int[]{1, 2}, (int[])method.invoke(null, new int[]{1, 1}));
            Test.assertEquals(new int[]{2, 1}, (int[])method.invoke(null, new int[]{2, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
