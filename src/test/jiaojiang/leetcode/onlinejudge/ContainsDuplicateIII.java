package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 10, 2016
 */
public class ContainsDuplicateIII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int[].class, int.class, int.class);
            Test.assertTrue((Boolean)method.invoke(null, new int[]{1, 5, 3, 2, 1}, 3, 1));
            Test.assertFalse((Boolean)method.invoke(null, new int[]{1, 5, 13, 22, 2}, 2, 3));
            Test.assertFalse((Boolean)method.invoke(null, new int[]{-1, 2147483647}, 1, 2147483647));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
