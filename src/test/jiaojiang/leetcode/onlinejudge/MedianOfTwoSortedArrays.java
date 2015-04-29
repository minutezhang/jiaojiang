package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 19, 2015 6:35:10 PM
 */
public class MedianOfTwoSortedArrays {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class);
            Test.assertEquals(7.5, method.invoke(null,new int[]{1,3, 5, 8, 22}, new int[]{4, 7, 9, 11, 25}));
            Test.assertEquals(4.0, method.invoke(null, new int[]{}, new int[]{4}));
            Test.assertEquals(4.5, method.invoke(null, new int[]{}, new int[]{4, 5}));
            Test.assertEquals(2.5, method.invoke(null, new int[]{1}, new int[]{2, 3, 4}));
            Test.assertEquals(2.5, method.invoke(null, new int[]{2, 3, 4}, new int[]{1}));
            Test.assertEquals(3.0, method.invoke(null, new int[]{}, new int[]{1, 2, 3, 4, 5}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}

