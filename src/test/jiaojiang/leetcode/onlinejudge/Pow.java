package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 7, 2015 9:27:12 PM
 */
public class Pow {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, double.class, int.class);
            Test.assertEquals(1024.0, method.invoke(null, 2, 10));
            Test.assertEquals(243.0, method.invoke(null, 3, 5));
            Test.assertEquals(1/243.0, method.invoke(null, 3, -5));
            Test.assertEquals(1.0, method.invoke(null, 1.00000, -2147483648));
            Test.assertEquals(1.0, method.invoke(null, 0.44528, 0));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
