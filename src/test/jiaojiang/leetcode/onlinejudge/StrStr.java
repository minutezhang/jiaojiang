package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/17/15 11:19 PM
 */
public class StrStr {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals(7, method.invoke(null, "hello, world", "world"));
            Test.assertEquals(-1, method.invoke(null, "hello, world", "word"));
            Test.assertEquals(0, method.invoke(null, "a", ""));
            Test.assertEquals(3, method.invoke(null, "abcabcabd", "abcabd"));
            Test.assertEquals(0, method.invoke(null, "aaa", "aa"));
            Test.assertEquals(5, method.invoke(null, "babbbbbabb", "bbab"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
