package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhang
 *
 * Created on Sep 6, 2016
 */
public class RemoveInvalidParentheses {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(Arrays.asList(new String[]{"()()()", "(())()"}), method.invoke(null, "()())()"));
            Test.assertEquals(Arrays.asList(new String[]{"(a)()()", "(a())()"}), method.invoke(null, "(a)())()"));
            Test.assertEquals(Arrays.asList(new String[0]), method.invoke(null, ")("));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
