package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;
import utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Apr 3, 2016
 */
public class CountOfRangeSum {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class, int.class);
            Test.assertEquals(3, method.invoke(null, new int[]{-2, 5, -1}, -2, 2));

            long time = System.nanoTime();
            Test.assertEquals(48645, method.invoke(null, Utils.getData("CountOfRangeSum.data"), 1, 4));
            System.out.println("Large case: it takes " + (System.nanoTime() - time) / 1000000 + "ms to run method " + methodName);
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
