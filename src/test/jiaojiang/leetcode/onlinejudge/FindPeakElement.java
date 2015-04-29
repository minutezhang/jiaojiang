package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/30/15 9:35 PM
 */
public class FindPeakElement {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(2, method.invoke(null, new int[]{3, 2, 6, 5, 0, 3}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 2, 3, 1}));
            Test.assertEquals(0, method.invoke(null, new int[]{3, 2, 1}));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 2, 3}));
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2}));
            Test.assertEquals(0, method.invoke(null, new int[]{2, 1}));
            Test.assertEquals(0, method.invoke(null, new int[]{1}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
