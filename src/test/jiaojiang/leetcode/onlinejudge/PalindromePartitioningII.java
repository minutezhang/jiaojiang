package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/27/15 2:54 PM
 */
public class PalindromePartitioningII {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(1, method.invoke(null, "aab"));
            Test.assertEquals(3, method.invoke(null, "cabababcbc"));
            Test.assertEquals(1, method.invoke(null, "ab"));
            Test.assertEquals(0, method.invoke(null, "ababababababababababababcbabababababababababababa"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
