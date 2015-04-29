package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/17/15 9:01 AM
 */
public class ThreeSumClosest {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class);
            Test.assertEquals(2, method.invoke(null, new int[]{-1, 2, 1, -4}, 1));
            Test.assertEquals(3, method.invoke(null, new int[]{0, 1, 2}, 3));
            Test.assertEquals(2, method.invoke(null, new int[]{1, 1, 1, 0}, -100));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
