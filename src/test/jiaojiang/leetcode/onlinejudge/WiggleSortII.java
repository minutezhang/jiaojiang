package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 28, 2016
 */
public class WiggleSortII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method isWiggleMethod = Class.forName(packageName + "." + className).getMethod("isWiggle", int[].class);
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);

            int[] data = new int[]{1, 5, 1, 1, 1, 6, 4};
            Test.assertFalse((Boolean)isWiggleMethod.invoke(null, data));
            method.invoke(null, data);
            Test.assertTrue((Boolean)isWiggleMethod.invoke(null, data));

            data = new int[]{1, 3, 2, 2, 3, 1};
            Test.assertFalse((Boolean)isWiggleMethod.invoke(null, data));
            method.invoke(null, data);
            Test.assertTrue((Boolean)isWiggleMethod.invoke(null, data));

            data = new int[]{4, 5, 5, 6};
            Test.assertFalse((Boolean)isWiggleMethod.invoke(null, data));
            method.invoke(null, data);
            Test.assertTrue((Boolean)isWiggleMethod.invoke(null, data));  // 5 6 4 5
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
