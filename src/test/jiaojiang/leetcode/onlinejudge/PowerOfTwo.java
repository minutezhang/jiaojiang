package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 14, 2016
 */
public class PowerOfTwo {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertTrue((Boolean)method.invoke(null, 1));
            Test.assertTrue((Boolean)method.invoke(null, 2));
            Test.assertTrue((Boolean)method.invoke(null, 16));

            Test.assertFalse((Boolean)method.invoke(null, 0));
            Test.assertFalse((Boolean)method.invoke(null, 3));
            Test.assertFalse((Boolean)method.invoke(null, 33));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
