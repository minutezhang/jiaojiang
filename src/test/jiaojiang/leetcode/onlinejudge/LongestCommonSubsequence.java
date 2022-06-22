package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LongestCommonSubsequence {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals(2, method.invoke(null, "sea", "eat"));
            Test.assertEquals(3, method.invoke(null, "abcde", "ace"));
            Test.assertEquals(3, method.invoke(null, "abc", "abc"));
            Test.assertEquals(0, method.invoke(null, "abc", "def"));
            Test.assertEquals(3, method.invoke(null, "abcdghe", "aedfhr"));
            Test.assertEquals(1, method.invoke(null, "bsbininm", "jmjkbkjkv"));
            Test.assertEquals(0, method.invoke(null, "", ""));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
