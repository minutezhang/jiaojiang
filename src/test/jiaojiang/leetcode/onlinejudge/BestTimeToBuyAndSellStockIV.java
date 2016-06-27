package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Jun 7, 2016
 */
public class BestTimeToBuyAndSellStockIV {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class, int[].class);
            Test.assertEquals(0, method.invoke(null, 2, new int[]{}));
            Test.assertEquals(0, method.invoke(null, 0, new int[]{1, 3}));
            Test.assertEquals(1, method.invoke(null, 1, new int[]{1, 2}));
            Test.assertEquals(19, method.invoke(null, 5, new int[]{0, 3, 8, 6, 8, 6, 6, 8, 2, 0, 2, 7}));
            Test.assertEquals(19, method.invoke(null, 4, new int[]{0, 3, 8, 6, 8, 6, 6, 8, 2, 0, 2, 7}));
            Test.assertEquals(17, method.invoke(null, 3, new int[]{0, 3, 8, 6, 8, 6, 6, 8, 2, 0, 2, 7}));
            Test.assertEquals(15, method.invoke(null, 2, new int[]{0, 3, 8, 6, 8, 6, 6, 8, 2, 0, 2, 7}));
            Test.assertEquals(8, method.invoke(null, 3, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
            Test.assertEquals(6, method.invoke(null, 2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
            Test.assertEquals(4, method.invoke(null, 1, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
            Test.assertEquals(11, method.invoke(null, 2, new int[]{8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6}));
            Test.assertEquals(12, method.invoke(null, 2, new int[]{5, 2, 3, 0, 3, 5, 6, 8, 1, 5}));
            Test.assertEquals(7, method.invoke(null, 2, new int[]{6, 5, 4, 8, 6, 8, 7, 8, 9, 4, 5}));
            Test.assertEquals(5, method.invoke(null, 1, new int[]{6, 1, 6, 4, 3, 0, 2}));
            Test.assertEquals(10, method.invoke(null, 2, new int[]{1, 3, 5, 4, 3, 7, 6, 9, 2, 4}));
            if (methodName.endsWith("Dp")) {
                Test.assertEquals(1648961, method.invoke(null, 1000000000, Utils.getIntArray("BestTimeToBuyAndSellStockIV_2.data")));
            }

            if (methodName.endsWith("2Dp")) {
                Test.assertEquals(2818, method.invoke(null, 29, Utils.getIntArray("BestTimeToBuyAndSellStockIV.data")));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}

