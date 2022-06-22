package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CircularArrayLoop {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertTrue((boolean)method.invoke(null, new int[]{2, -1, 1, 2, 2}));
            Test.assertFalse((boolean)method.invoke(null, new int[]{-1,2}));
            Test.assertFalse((boolean)method.invoke(null, new int[]{-2,1,-1,-2,-2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
