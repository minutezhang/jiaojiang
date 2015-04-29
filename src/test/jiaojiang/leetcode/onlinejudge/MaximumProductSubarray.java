package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/26/15 4:52 PM
 */
public class MaximumProductSubarray {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(6, method.invoke(null, new int[]{2, 3, -2, 4}));
            Test.assertEquals(48, method.invoke(null, new int[]{2, 3, -2, -1, 4}));
            Test.assertEquals(-2, method.invoke(null, new int[]{-2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
