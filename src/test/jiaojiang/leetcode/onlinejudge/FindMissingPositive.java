package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Feb 28, 2015 9:38:45 AM
 */
public class FindMissingPositive {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(2, method.invoke(null, new int[]{3, 4, -1, 1}));
            Test.assertEquals(3, method.invoke(null, new int[]{1, 2, 0}));
            Test.assertEquals(2, method.invoke(null, new int[]{1}));
            Test.assertEquals(1, method.invoke(null, new int[]{2}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 1}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
