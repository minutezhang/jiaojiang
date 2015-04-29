package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/10/15 11:15 PM
 */
public class ValidParentheses {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertTrue((Boolean) method.invoke(null, "()[]{}"));
            Test.assertTrue((Boolean) method.invoke(null, "{[()]}"));
            Test.assertFalse((Boolean) method.invoke(null, "([)]"));
            Test.assertFalse((Boolean) method.invoke(null, "("));
            Test.assertFalse((Boolean) method.invoke(null, "]"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
