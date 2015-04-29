package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 4/24/15 4:48 PM
 */
public class HappyNumber {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertTrue((Boolean)method.invoke(null, 1));
            Test.assertTrue((Boolean)method.invoke(null, 7));
            Test.assertTrue((Boolean)method.invoke(null, 10));
            Test.assertTrue((Boolean)method.invoke(null, 13));
            Test.assertTrue((Boolean)method.invoke(null, 19));

            Test.assertFalse((Boolean)method.invoke(null, 2));
            Test.assertFalse((Boolean)method.invoke(null, 3));
            Test.assertFalse((Boolean)method.invoke(null, 4));
            Test.assertFalse((Boolean)method.invoke(null, 5));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
