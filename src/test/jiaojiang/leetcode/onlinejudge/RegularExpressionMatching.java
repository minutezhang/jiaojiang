package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zhang
 * @date: Mar 22, 2015 10:29:27 PM
 */
public class RegularExpressionMatching {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertFalse((Boolean)method.invoke(null, "aa","a"));
            Test.assertTrue((Boolean)method.invoke(null, "aa","aa"));
            Test.assertFalse((Boolean)method.invoke(null, "aaa","aa"));
            Test.assertTrue((Boolean)method.invoke(null, "aa", "a*"));
            Test.assertTrue((Boolean)method.invoke(null, "aa", ".*"));
            Test.assertTrue((Boolean)method.invoke(null, "ab", ".*"));
            Test.assertTrue((Boolean)method.invoke(null, "aab", "c*a*b"));
            Test.assertFalse((Boolean)method.invoke(null, "ab", ".*c"));
            Test.assertTrue((Boolean)method.invoke(null, "aa", "a*"));
            Test.assertFalse((Boolean)method.invoke(null, "baccbbcbcacacbbc", "c*.*b*c*ba*b*b*.a*"));
            Test.assertTrue((Boolean)method.invoke(null, "a", "ab*"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
