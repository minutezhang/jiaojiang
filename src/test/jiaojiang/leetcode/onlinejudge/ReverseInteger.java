package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/8/15 10:06 AM
 */
public class ReverseInteger {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(321, method.invoke(null, 123));
            Test.assertEquals(-321, method.invoke(null, -123));
            Test.assertEquals(1, method.invoke(null, 100));
            Test.assertEquals(0, method.invoke(null, Integer.MAX_VALUE));
            Test.assertEquals(0, method.invoke(null, Integer.MIN_VALUE));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
