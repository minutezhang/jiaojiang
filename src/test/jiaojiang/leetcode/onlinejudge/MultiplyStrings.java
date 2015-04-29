package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 2/2/15 11:47 AM
 */
public class MultiplyStrings {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class, String.class);
            Test.assertEquals(String.valueOf(1234 * 45), method.invoke(null, "1234", "45"));
            Test.assertEquals("0", method.invoke(null, "1234", "0"));
            Test.assertEquals("1234", method.invoke(null, "1234", "1"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
