package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 4, 2016
 */
public class FindTheDuplicateNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class);
            Test.assertEquals(1, method.invoke(null, (Object)new int[]{1, 1}));
            Test.assertEquals(2, method.invoke(null, (Object)new int[]{1, 2, 2}));
            Test.assertEquals(2, method.invoke(null, (Object)new int[]{2, 2, 2, 2, 2}));
            Test.assertEquals(2, method.invoke(null, (Object)new int[]{1, 3, 4, 2, 2}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
