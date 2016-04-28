package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Apr 19, 2016
 */
public class PowerOfFour {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertFalse((Boolean)method.invoke(null, 5));
            Test.assertFalse((Boolean)method.invoke(null, 63));
            Test.assertFalse((Boolean)method.invoke(null, 15));

            Test.assertTrue((Boolean)method.invoke(null, 4));
            Test.assertTrue((Boolean)method.invoke(null, 16));
            Test.assertTrue((Boolean)method.invoke(null, 64));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
