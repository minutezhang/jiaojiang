package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 26, 2016
 */
public class CountBits {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertEquals(new int[]{0, 1, 1, 2, 1, 2}, (int[])method.invoke(null, 5));
            Test.assertEquals(new int[]{0, 1, 1}, (int[])method.invoke(null, 2));
            Test.assertEquals(new int[]{0}, (int[])method.invoke(null, 0));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
