package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Feb 25, 2016
 */
public class PowerOfThree {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, int.class);
            Test.assertFalse((Boolean)method.invoke(null, 2));
            Test.assertFalse((Boolean)method.invoke(null, 21));
            Test.assertFalse((Boolean)method.invoke(null, 19992));

            Test.assertTrue((Boolean)method.invoke(null, 3));
            Test.assertTrue((Boolean)method.invoke(null, 9));
            Test.assertTrue((Boolean)method.invoke(null, 27));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
