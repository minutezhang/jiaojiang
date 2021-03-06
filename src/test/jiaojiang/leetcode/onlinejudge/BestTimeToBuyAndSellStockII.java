package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/29/15 10:09 PM
 */
public class BestTimeToBuyAndSellStockII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(7, method.invoke(null, new int[]{3, 2, 6, 5, 0, 3}));
            Test.assertEquals(3, method.invoke(null, new int[]{1, 2, 4}));
            Test.assertEquals(1, method.invoke(null, new int[]{1, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
