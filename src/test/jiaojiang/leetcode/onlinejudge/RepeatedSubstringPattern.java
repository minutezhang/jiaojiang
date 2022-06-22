package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/28/15 6:38 PM
 */
public class RepeatedSubstringPattern {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertTrue((boolean) method.invoke(null, "abab"));
            Test.assertTrue((boolean) method.invoke(null, "abcabcabcabc"));
            Test.assertFalse((boolean) method.invoke(null, "aba"));
            Test.assertFalse((boolean) method.invoke(null, "ababaa"));
            Test.assertFalse((boolean) method.invoke(null, "abac"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
