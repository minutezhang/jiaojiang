package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NthDigit {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(0, method.invoke(null, 11));
            Test.assertEquals(3, method.invoke(null, 3));
            Test.assertEquals(1, method.invoke(null, 195));
            Test.assertEquals(1, method.invoke(null, 1000000000));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
