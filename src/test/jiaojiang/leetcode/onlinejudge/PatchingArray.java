package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Feb 24, 2016
 */
public class PatchingArray {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(3, method.invoke(null, new int[0], 6));
            Test.assertEquals(4, method.invoke(null, new int[0], 8));
            Test.assertEquals(1, method.invoke(null, new int[]{1, 3}, 6));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 5, 10}, 20));
            Test.assertEquals(0, method.invoke(null, new int[]{1, 2, 2}, 5));
            Test.assertEquals(28, method.invoke(null, new int[]{1, 2, 31, 33}, 2147483647));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
