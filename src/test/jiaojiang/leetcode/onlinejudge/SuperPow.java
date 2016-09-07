package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Aug 5, 2016
 */
public class SuperPow {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[].class);
            Test.assertEquals(8, method.invoke(null, 2, new int[]{3}));
            Test.assertEquals(1024, method.invoke(null, 2, new int[]{1, 0}));
            Test.assertEquals(1198, method.invoke(null, 2147483647, new int[]{2, 0, 0}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
