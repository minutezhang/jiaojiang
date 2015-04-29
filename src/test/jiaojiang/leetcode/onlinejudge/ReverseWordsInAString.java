package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/9/15 10:33 PM
 */
public class ReverseWordsInAString {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals("blue is sky the", method.invoke(null, "the sky is blue"));
            Test.assertEquals("blue is sky the", method.invoke(null, "  the sky is blue  "));
            Test.assertEquals("blue is sky the", method.invoke(null, "  the sky  is   blue  "));
            Test.assertEquals("a", method.invoke(null, "a"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }

}
