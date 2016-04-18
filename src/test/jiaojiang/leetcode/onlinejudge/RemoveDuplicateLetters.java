package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 27, 2016
 */
public class RemoveDuplicateLetters {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals("abc", method.invoke(null, "bcabc"));
            Test.assertEquals("acdb", method.invoke(null, "cbacdcbc"));
            Test.assertEquals("bacd", method.invoke(null, "dcbacdcd"));
            Test.assertEquals("abcd", method.invoke(null, "abcabdbd"));
            Test.assertEquals("acbd", method.invoke(null, "bacabdbd"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
