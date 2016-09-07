package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Aug 6, 2016
 */
public class KthSmallestElementInASortedMatrix {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[][].class, int.class);
            Test.assertEquals(13, method.invoke(null, new int[][] {{1, 5, 9},
                    {10, 11, 13},
                    {12, 13, 15}}, 8));

            Test.assertEquals(30, method.invoke(null, new int[][] {{10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {24, 29, 37, 48},
                    {32, 33, 39, 50}}, 7));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
