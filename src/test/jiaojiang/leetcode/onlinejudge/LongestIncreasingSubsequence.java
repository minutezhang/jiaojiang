package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 3, 2016
 */
public class LongestIncreasingSubsequence {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(0, method.invoke(null, (Object) new int[0]));
            Test.assertEquals(4, method.invoke(null, (Object) new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
            Test.assertEquals(6, method.invoke(null, (Object) new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
            Test.assertEquals(6, method.invoke(null, (Object) new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
