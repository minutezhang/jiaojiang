package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Feb 25, 2016
 */
public class CoinChange {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(0, method.invoke(null, new int[]{1}, 0));
            Test.assertEquals(3, method.invoke(null, new int[]{1, 2, 5}, 11));
            Test.assertEquals(-1, method.invoke(null, new int[]{2}, 3));
            Test.assertEquals(2, method.invoke(null, new int[]{5, 4, 3, 1}, 7));
            Test.assertEquals(26, method.invoke(null, new int[]{346, 29, 395, 188, 155, 109}, 9401));
            Test.assertEquals(31, method.invoke(null, new int[]{227, 99, 328, 299, 42, 322}, 9847));
            Test.assertEquals(7, method.invoke(null, new int[]{294, 177, 81, 226, 425, 316, 204, 356, 336, 278, 60}, 2267));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
