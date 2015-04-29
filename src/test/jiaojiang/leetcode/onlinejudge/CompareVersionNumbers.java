package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/14/15 11:09 PM
 */
public class CompareVersionNumbers {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals(-1, method.invoke(null, "0.1", "1.1"));
            Test.assertEquals(1, method.invoke(null, "1.1", "0.1"));
            Test.assertEquals(1, method.invoke(null, "1.2", "1.1"));
            Test.assertEquals(-1, method.invoke(null, "1.1", "1.2"));
            Test.assertEquals(-1, method.invoke(null, "1.1", "13.27"));
            Test.assertEquals(0, method.invoke(null, "1.1", "1.1"));
            Test.assertEquals(-1, method.invoke(null, "1.1", "1.10"));
            Test.assertEquals(-1, method.invoke(null, "1.9", "1.11"));
            Test.assertEquals(0, method.invoke(null, "1", "01"));
            Test.assertEquals(-1, method.invoke(null, "1", "1.1"));
            Test.assertEquals(1, method.invoke(null, "0.1", "0.0.1"));
            Test.assertEquals(0, method.invoke(null, "1.0", "1"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
