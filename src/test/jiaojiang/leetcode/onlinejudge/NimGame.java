package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 4, 2016
 */
public class NimGame {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertTrue((Boolean) method.invoke(null, 1));
            Test.assertFalse((Boolean) method.invoke(null, 4));
            Test.assertFalse((Boolean) method.invoke(null, 8));
            Test.assertTrue((Boolean) method.invoke(null, 41));

            if (methodName.endsWith("2")) {
                Test.assertFalse((Boolean) method.invoke(null, 1348820612));
            }
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
