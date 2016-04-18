package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhang
 *
 * Created on Apr 10, 2016
 */
public class CreateMaximumNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int[].class, int.class);
            Test.assertEquals(new int[]{9, 8, 6, 5, 3}, (int[]) method.invoke(null, new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5));
            Test.assertEquals(new int[]{6, 7, 6, 0, 4}, (int[]) method.invoke(null, new int[]{6, 7}, new int[]{6, 0, 4}, 5));
            Test.assertEquals(new int[]{9, 8, 9}, (int[]) method.invoke(null, new int[]{3, 9}, new int[]{8, 9}, 3));
            if (methodName.endsWith("Dp")) {
                long time = System.nanoTime();
                Test.assertEquals(new int[]{9, 8, 8, 8, 7, 6, 2, 3}, (int[]) method.invoke(null, new int[]{5, 9, 3, 7, 5, 6, 2, 3}, new int[]{3, 8, 1, 2, 8, 6, 0, 8}, 8));
                System.out.println("It took " + (System.nanoTime() - time) / 1000000 + "ms to complete this testcase");
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
