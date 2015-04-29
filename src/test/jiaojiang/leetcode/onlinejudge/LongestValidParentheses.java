package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 3/16/15 7:27 PM
 */
public class LongestValidParentheses {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(2, method.invoke(null, "(()"));
            Test.assertEquals(4, method.invoke(null, ")()())"));
            Test.assertEquals(4, method.invoke(null, ")()())"));
            Test.assertEquals(22, method.invoke(null, ")(((((()())()()))()(()))("));
            Test.assertEquals(2, method.invoke(null, "()(()"));
            Test.assertEquals(2, method.invoke(null, "())(()"));
            Test.assertEquals(4, method.invoke(null, "))))())()()(()"));
            Test.assertEquals(4, method.invoke(null, "())()()(()"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
