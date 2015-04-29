package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/29/15 10:13 PM
 */
public class BestTimeToBuyAndSellStockIII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(2, method.invoke(null, new int[]{2, 1, 2, 0, 1}));
            Test.assertEquals(7, method.invoke(null, new int[]{4, 2, 1, 6, 8}));
            Test.assertEquals(3, method.invoke(null, new int[]{1, 2, 4}));
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2}));
            Test.assertEquals(0, method.invoke(null, new int[]{}));
            Test.assertEquals(0, method.invoke(null, new int[]{2}));
            Test.assertEquals(0, method.invoke(null, new int[]{3}));
            Test.assertEquals(2, method.invoke(null, new int[]{2, 4, 1}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
