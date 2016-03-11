package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 4, 2016
 */
public class MaximumProductOfWorldLength {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String[].class);
            Test.assertEquals(16, method.invoke(null, (Object) new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
            Test.assertEquals(4, method.invoke(null, (Object) new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
            Test.assertEquals(0, method.invoke(null, (Object) new String[]{"a", "aa", "aaa", "aaaa"}));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
