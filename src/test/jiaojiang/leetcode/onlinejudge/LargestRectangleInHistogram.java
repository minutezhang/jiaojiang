package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 5, 2015 10:12:47 PM
 */
public class LargestRectangleInHistogram {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(10, method.invoke(null, (Object) new int[]{2, 1, 5, 6, 2, 3}));
            Test.assertEquals(10, method.invoke(null, (Object) new int[]{2, 1, 5, 6, 2, 1}));
            Test.assertEquals(0, method.invoke(null, (Object) new int[]{}));
            Test.assertEquals(2, method.invoke(null, (Object) new int[]{2, 1}));
            Test.assertEquals(3, method.invoke(null, (Object) new int[]{2, 1, 2}));
            Test.assertEquals(2, method.invoke(null, (Object) new int[]{1, 1}));
            Test.assertEquals(6, method.invoke(null, (Object) new int[]{4, 2, 0, 3, 2, 5}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
