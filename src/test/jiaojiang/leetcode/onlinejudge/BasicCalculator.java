package test.jiaojiang.leetcode.onlinejudge;

import utils.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author zhang
 *
 * Created on Mar 12, 2016
 */
public class BasicCalculator {
    public static void test(String packageName, String className, String methodName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = Class.forName(packageName + "." + className).getMethod(methodName, String.class);
            Test.assertEquals(2, method.invoke(null, "1 + 1"));
            Test.assertEquals(0, method.invoke(null, "1-1"));
            Test.assertEquals(3, method.invoke(null, " 2-1 + 2 "));
            Test.assertEquals(23, method.invoke(null, "(1+(4+5+2)-3)+(6+8)"));
            Test.assertEquals(3, method.invoke(null, "10-(7-(8-(9-6)-(3+2)))"));
        } catch (Exception e) {
            System.err.println("Cannot find method " + methodName + " for class " + packageName + "." + className);
            e.printStackTrace();
        }
    }
}
